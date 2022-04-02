package com.vicking.util;

import lombok.extern.slf4j.Slf4j;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.*;

@Slf4j
public class SeriWriterUtil {

    public static class FieldInfo {
        public Field field;
        public boolean isFinal; // 是否是final
        public Method readMethod; // get is 函数
        public Method writeMethod;// set 函数
        public Object value; // 默认值
        public PropertyDescriptor pd;

        @Override
        public String toString() {
            return "FieldInfo{" +
                    "field=" + field.getName() +
                    ", isFinal=" + isFinal +
                    ", readMethod=" + (readMethod == null ? "null" : readMethod.getName()) +
                    ", value=" + value +
                    '}';
        }
    }

    public static List<FieldInfo> getFieldInfos(Class<?> clazz, boolean withSuperClassFields) {

        Object instance;
        try {
            Constructor<?> constructor = clazz.getConstructor();
            instance = constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(clazz.getName() + " 没有默认构造函数");
        }


        List<FieldInfo> needSD = new ArrayList<>();

        // 遍历所有的属性
        ArrayList<Field> pubFields = new ArrayList<>();
        ArrayList<Field> allFields = new ArrayList<>();

        Class<?> searchType = clazz;
        while (searchType != null) {
            Field[] _pubFields = searchType.getFields();
            for (Field pubField : _pubFields) {
                SD_NO sd_no = pubField.getAnnotation(SD_NO.class);
                if (sd_no == null) pubFields.add(pubField);
            }
            Field[] _allFields = searchType.getDeclaredFields();
            for (Field allField : _allFields) {
                SD_NO sd_no = allField.getAnnotation(SD_NO.class);
                if (sd_no == null) allFields.add(allField);
            }
            searchType = withSuperClassFields ? searchType.getSuperclass() != Object.class ? searchType.getSuperclass() : null : null;
        }

        for (Field pubField : pubFields) {
            needSD.add(getFieldInfo(pubField, null, null, instance));
        }

        for (Field allField : allFields) {
            if (!pubFields.contains(allField)) {
                try {
                    PropertyDescriptor pd = new PropertyDescriptor(allField.getName(), clazz);
                    //获得get方法
                    Method readMethod = pd.getReadMethod();
                    Method writeMethod = pd.getWriteMethod();
                    if (readMethod != null && writeMethod != null) {
                        //System.out.println("readMethod ; " + readMethod);
                        FieldInfo fieldInfo = getFieldInfo(allField, readMethod, writeMethod, instance);
                        fieldInfo.pd = pd;
                        needSD.add(fieldInfo);
                    } else {
                        System.out.println(allField.getName() + " 没有read write函数1");
                    }


                } catch (IntrospectionException e) {
                    // 没有read函数
                    System.out.println(allField.getName() + " 没有read write函数2");
                }
            }
        }

//        System.out.println("-----------");
//
//        for (FieldInfo fieldInfo : needSD) {
//            System.out.println(fieldInfo);
//        }
//
//        System.out.println("-------------");

        return needSD;
    }

    public static FieldInfo getFieldInfo(Field field, Method readMethod, Method writeMethod, Object instance) {
        FieldInfo fieldInfo = new FieldInfo();
        fieldInfo.field = field;
        //field.isEnumConstant();// 枚举
        fieldInfo.isFinal = field.isAccessible();  // 是否是final
        fieldInfo.writeMethod = writeMethod;
        if (readMethod != null) {
            fieldInfo.readMethod = readMethod;
            try {
                fieldInfo.value = readMethod.invoke(instance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                fieldInfo.value = field.get(instance);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return fieldInfo;
    }

    private static final String ENDWORD = "\r\n";

    public static StringBuilder javaWriterBuilder(Class<?> clazz) throws IntrospectionException {
        String simpleName = clazz.getSimpleName();
        List<FieldInfo> fields = getFieldInfos(clazz, true);

        StringBuilder sb4Writer = new StringBuilder();
        sb4Writer.append("package ").append(clazz.getPackage().getName()).append(";").append(ENDWORD);
        sb4Writer.append("import java.io.IOException;").append(ENDWORD);
        sb4Writer.append("import java.io.OutputStream;").append(ENDWORD);
        sb4Writer.append("public class ").append(simpleName).append("Writer {").append(ENDWORD);
        sb4Writer.append("\tpublic static void write(OutputStream os,").append(simpleName).append(" o) throws IOException {").append(ENDWORD);
        sb4Writer.append("\t\tif (o == null) {").append(ENDWORD);
        sb4Writer.append("\t\t\tSeriUtil.put(os, (byte)0);").append(ENDWORD);
        sb4Writer.append("\t\t\treturn;").append(ENDWORD);
        sb4Writer.append("\t\t}").append(ENDWORD);
        sb4Writer.append("\t\tSeriUtil.put(os, (byte)1);").append(ENDWORD);


        StringBuilder sb4Reader = new StringBuilder();
        sb4Reader.append("package ").append(clazz.getPackage().getName()).append(";").append(ENDWORD);
        sb4Reader.append("import java.io.IOException;").append(ENDWORD);
        sb4Reader.append("import java.io.InputStream;").append(ENDWORD);
        sb4Reader.append("import java.util.Collection;").append(ENDWORD);
        sb4Reader.append("public class ").append(simpleName).append("Reader {").append(ENDWORD);
        sb4Reader.append("\tpublic static ").append(simpleName).append(" read(InputStream is) throws IOException {").append(ENDWORD);
        sb4Reader.append("\t\tif(DeseriUtil.get(is) == 0) return null;").append(ENDWORD);
        sb4Reader.append("\t\t").append(simpleName).append(" o = new ").append(simpleName).append("();").append(ENDWORD);

        for (FieldInfo field : fields) {
            javaWriterBuilder(sb4Writer, sb4Reader, clazz, field);
        }

        sb4Reader.append("\t\treturn o;").append(ENDWORD);
        sb4Reader.append("\t}").append(ENDWORD);
        sb4Reader.append("}");

        sb4Writer.append("\t}").append(ENDWORD);
        sb4Writer.append("}");

//        System.out.println(sb4Writer.toString());
//        System.out.println(sb4Reader.toString());

        try {
            FileWriter fileWriter1 = new FileWriter(new File("./" + simpleName+"Writer.java"));
            fileWriter1.write(sb4Writer.toString());
            fileWriter1.flush();
            FileWriter fileWriter2 = new FileWriter(new File("./" + simpleName+"Reader.java"));
            fileWriter2.write(sb4Reader.toString());
            fileWriter2.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb4Writer;
    }




    public static void javaWriterBuilder(StringBuilder sb4Writer,StringBuilder sb4Reader, Class<?> clazz, FieldInfo fieldInfo) {
        Class<?> propertyType = fieldInfo.pd.getPropertyType();
        String fieldName = fieldInfo.field.getName();
        String writeMethodName = fieldInfo.writeMethod.getName();
        Method readMethod = fieldInfo.readMethod;
        ParameterizedType parameterizedType = null;
        try {
            parameterizedType = (ParameterizedType) fieldInfo.field.getGenericType();
        } catch (ClassCastException e) {}

        javaWriterBuilder(sb4Writer, sb4Reader, clazz, propertyType, fieldName, writeMethodName, readMethod, parameterizedType);
    }
    public static void javaWriterBuilder(StringBuilder sb4Writer,StringBuilder sb4Reader, Class<?> clazz,
                                         Class<?> propertyType, String fieldName, String writeMethodName, Method readMethod, ParameterizedType parameterizedType
    ) {

        if (propertyType == Date.class) {
            sb4Writer.append("\t\tSeriUtil.putDate(os, ");

            sb4Reader.append("\t\to.").append(writeMethodName).append("(");
            sb4Reader.append("DeseriUtil.getDate(is)");
            sb4Reader.append(");").append(ENDWORD);
        } else if (propertyType == double.class || propertyType == Double.class) {
            sb4Writer.append("\t\tSeriUtil.putDouble(os, ");

            sb4Reader.append("\t\to.").append(writeMethodName).append("(");
            sb4Reader.append("DeseriUtil.getDouble(is)");
            sb4Reader.append(");").append(ENDWORD);
        } else if (propertyType == float.class || propertyType == Float.class) {
            sb4Writer.append("\t\tSeriUtil.putFloat(os, ");

            sb4Reader.append("\t\to.").append(writeMethodName).append("(");
            sb4Reader.append("DeseriUtil.getFloat(is)");
            sb4Reader.append(");").append(ENDWORD);
        } else if (propertyType == byte.class || propertyType == Byte.class) {
            sb4Writer.append("\t\tSeriUtil.put(os, ");

            sb4Reader.append("\t\to.").append(writeMethodName).append("(");
            sb4Reader.append("(byte)DeseriUtil.get(is)");
            sb4Reader.append(");").append(ENDWORD);
        } else if (propertyType == short.class || propertyType == Short.class) {
            sb4Writer.append("\t\tSeriUtil.putShort(os, ");

            sb4Reader.append("\t\to.").append(writeMethodName).append("(");
            sb4Reader.append("DeseriUtil.getShort(is)");
            sb4Reader.append(");").append(ENDWORD);
        } else if (propertyType == int.class || propertyType == Integer.class) {
            sb4Writer.append("\t\tSeriUtil.putInt(os, ");

            sb4Reader.append("\t\to.").append(writeMethodName).append("(");
            sb4Reader.append("DeseriUtil.getInt(is)");
            sb4Reader.append(");").append(ENDWORD);
        } else if (propertyType == long.class || propertyType == Long.class) {
            sb4Writer.append("\t\tSeriUtil.putLong(os, ");

            sb4Reader.append("\t\to.").append(writeMethodName).append("(");
            sb4Reader.append("DeseriUtil.getLong(is)");
            sb4Reader.append(");").append(ENDWORD);
        } else if (propertyType == String.class) {
            sb4Writer.append("\t\tSeriUtil.putString(os, ");

            sb4Reader.append("\t\to.").append(writeMethodName).append("(");
            sb4Reader.append("DeseriUtil.getString(is)");
            sb4Reader.append(");").append(ENDWORD);
        } else if (Collection.class.isAssignableFrom(propertyType)) {
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length == 1) {
                Type actualTypeArgument = actualTypeArguments[0];
                if (actualTypeArgument == Short.class) {
                    sb4Writer.append("\t\tSeriUtil.putShortCol(os, ");




                    sb4Reader.append("\t\tCollection<Short> ").append(fieldName).append(" = DeseriUtil.getShortCol(is);").append(ENDWORD);
                    sb4Reader.append("\t\tif(").append(fieldName).append(" != null) ");
                    appendGetValue(sb4Reader, fieldName, readMethod);
                    sb4Reader.append(".addAll(");
                    sb4Reader.append(fieldName).append(");").append(ENDWORD);
                } else if (actualTypeArgument == Integer.class) {
                    sb4Writer.append("\t\tSeriUtil.putIntCol(os, ");


                    sb4Reader.append("\t\tCollection<Integer> ").append(fieldName).append(" = DeseriUtil.getIntCol(is);").append(ENDWORD);
                    sb4Reader.append("\t\tif(").append(fieldName).append(" != null) ");
                    appendGetValue(sb4Reader, fieldName, readMethod);
                    sb4Reader.append(".addAll(");
                    sb4Reader.append(fieldName).append(");").append(ENDWORD);
                } else if (actualTypeArgument == Long.class) {
                    sb4Writer.append("\t\tSeriUtil.putLongCol(os, ");

                    sb4Reader.append("\t\tCollection<Long> ").append(fieldName).append(" = DeseriUtil.getLongCol(is);").append(ENDWORD);
                    sb4Reader.append("\t\tif(").append(fieldName).append(" != null) ");
                    appendGetValue(sb4Reader, fieldName, readMethod);
                    sb4Reader.append(".addAll(");
                    sb4Reader.append(fieldName).append(");").append(ENDWORD);
                } else if (actualTypeArgument == String.class) {
                    sb4Writer.append("\t\tSeriUtil.putStringCol(os, ");

                    sb4Reader.append("\t\tCollection<String> ").append(fieldName).append(" = DeseriUtil.getStringCol(is);").append(ENDWORD);
                    sb4Reader.append("\t\tif(").append(fieldName).append(" != null) ");
                    appendGetValue(sb4Reader, fieldName, readMethod);
                    sb4Reader.append(".addAll(");
                    sb4Reader.append(fieldName).append(");").append(ENDWORD);
                } else {
                    //throw new RuntimeException("未处理类型:" + actualTypeArgument);
                    sb4Writer.append("\t\tSeriUtil.putShort(os, (short)");
                    if (readMethod == null) {
                        sb4Writer.append("o.").append(fieldName).append(".size());").append(ENDWORD);
                    } else {
                        sb4Writer.append("o.").append(readMethod.getName()).append("()").append(".size());").append(ENDWORD);
                    }

                    sb4Writer.append("\t\tfor (").append(actualTypeArgument.getTypeName()).append(" item : ");
                    appendGetValue(sb4Writer, fieldName, readMethod);
                    sb4Writer.append(") {").append(ENDWORD);
                        sb4Writer.append("\t\t\t").append(actualTypeArgument.getTypeName()).append("Writer.write(os, item);").append(ENDWORD);
                    sb4Writer.append("\t\t}").append(ENDWORD);


                    // TODO 有个奇怪的BUG,不能将DeseriUtil.getShort(is) 反在循环体中 short size = DeseriUtil.getShort(is);
                    sb4Reader.append("\t\t{short size = DeseriUtil.getShort(is);").append(ENDWORD);
                    sb4Reader.append("\t\tfor (int i = 0; i < size; i++) {").append(ENDWORD);
                    sb4Reader.append("\t\t\t");
                    appendGetValue(sb4Reader, fieldName, readMethod);
                    sb4Reader.append(".add(");
                    sb4Reader.append(actualTypeArgument.getTypeName()).append("Reader.read(is));").append(ENDWORD);
                    sb4Reader.append("\t\t}}").append(ENDWORD);

                    return;
//                    for (actualTypeArgument.getName item : ) {
//
//                    }
                }
            } else {
                throw new RuntimeException("未指定泛型类型或多个泛型类型:" + propertyType);
            }
        } else if (Map.class.isAssignableFrom(propertyType)) {
            log.info("Map");
//            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
//            System.out.println(actualTypeArguments.length);
//            if (actualTypeArguments.length == 2) {
//                Type kt = actualTypeArguments[0];
//                Type vt = actualTypeArguments[1];
//                // 写入数量
//                sb4Writer.append("\t\tSeriUtil.putShort(os, (short)");
//                if (readMethod == null) {
//                    sb4Writer.append("o.").append(fieldName).append(".size());").append(ENDWORD);
//                } else {
//                    sb4Writer.append("o.").append(readMethod.getName()).append("()").append(".size());").append(ENDWORD);
//                }
//            } else {
//                throw new RuntimeException("未指定泛型类型或多个泛型类型:" + propertyType);
//            }
        }
        // TODO 暂时不考虑数组情况
        //else if (propertyType.isArray()) {
        //    System.out.println("数组:" + propertyType);
        //    Class<?> componentType = propertyType.getComponentType();
        //    if (componentType == Short.class) {
        //        sb.append("\t\tSeriUtil.putShortCol(os, ");
        //    } else if (componentType == Integer.class) {
        //        sb.append("\t\tSeriUtil.putIntCol(os, ");
        //    } else if (componentType == Long.class) {
        //        sb.append("\t\tSeriUtil.putLongCol(os, ");
        //    } else if (componentType == String.class) {
        //        sb.append("\t\tSeriUtil.putStringCol(os, ");
        //    }else {
        //        log.error("未处理类型:" + componentType);
        //    }
        //}
        else {
            sb4Writer.append("\t\t").append(propertyType.getSimpleName()).append("Writer.write(os, ");

            sb4Reader.append("\t\to.").append(writeMethodName).append("(");
            sb4Reader.append(propertyType.getSimpleName()).append("Reader.read(is)");
            sb4Reader.append(");").append(ENDWORD);
        }

        appendGetValue(sb4Writer, fieldName, readMethod);
        sb4Writer.append(");").append(ENDWORD);
    }

    private static void appendGetValue(StringBuilder sb, String fieldName, Method readMethod) {
        if (readMethod == null) {
            sb.append("o.").append(fieldName);
        } else {
            sb.append("o.").append(readMethod.getName()).append("()");
        }
    }

    public static void main(String[] args) throws Exception {
        javaWriterBuilder(Player.class);
        javaWriterBuilder(User.class);
    }
}
