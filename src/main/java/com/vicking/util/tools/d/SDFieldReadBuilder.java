package com.vicking.util.tools.d;

import lombok.extern.slf4j.Slf4j;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

@Slf4j
public class SDFieldReadBuilder {

    public static String field4Read(Class<?> clazz, String fieldName, boolean isPublic) throws IntrospectionException, NoSuchFieldException {
        Field field;
        if (isPublic) {
            field = clazz.getField(fieldName);
        } else {
            field = clazz.getDeclaredField(fieldName);
        }
        return field4Read(clazz, field, isPublic);
    }

    /**
     * @param clazz
     * @param field
     * @param isPublic
     * @return
     * @throws IntrospectionException
     */
    public static String field4Read(Class<?> clazz, Field field, boolean isPublic) throws IntrospectionException {
        Class<?> propertyClass;  // interface java.util.List
        Type propertyType; // java.util.List<java.lang.Boolean>
        String setValueStr;
        if (isPublic) {
            propertyClass = field.getType();
            propertyType = field.getGenericType();
            // o.xxx

            setValueStr = "o." + field.getName() + "= %s;";
        } else {
            // 通过具有 getFoo 和 setFoo 访问器方法
            try {

                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), clazz);
                propertyClass = propertyDescriptor.getPropertyType();
                propertyType = field.getGenericType();

                //Method readMethod = propertyDescriptor.getReadMethod(); // getter
                Method writeMethod = propertyDescriptor.getWriteMethod(); // setter

                // o.getXXX()
                setValueStr = "o." + writeMethod.getName() + "(%s);";
            } catch (Exception e) {
                log.error("属性:" + field.getName() + " 没有set/get");
                return "";
            }
        }

        if (List.class.isAssignableFrom(propertyClass)) {
            return getField4ReadStrList((ParameterizedType) propertyType, setValueStr);
        } else if (Set.class.isAssignableFrom(propertyClass)) {
            return getField4ReadStrSet((ParameterizedType) propertyType, setValueStr);
        } else if (Map.class.isAssignableFrom(propertyClass)) {
            return getField4ReadStrMap((ParameterizedType) propertyType, setValueStr);
        } else if (propertyClass.isArray()) {
            Class<?> componentType = propertyClass.getComponentType();
            return getField4ReadStrArr(componentType, setValueStr);
        } else {
            return getField4ReadStr(propertyType, setValueStr);
        }

    }

    public static String getField4ReadStr(Type propertyType, String setValueStr) {
        if (propertyType == Date.class) {
            return DeseriUtilBuilder.getDate(setValueStr);
        } else if (propertyType == double.class || propertyType == Double.class) {
            return DeseriUtilBuilder.getDouble(setValueStr);
        } else if (propertyType == float.class || propertyType == Float.class) {
            return DeseriUtilBuilder.getFloat(setValueStr);
        } else if (propertyType == byte.class || propertyType == Byte.class) {
            return DeseriUtilBuilder.getByte(setValueStr);
        } else if (propertyType == short.class || propertyType == Short.class) {
            return DeseriUtilBuilder.getShort(setValueStr);
        } else if (propertyType == int.class || propertyType == Integer.class) {
            return DeseriUtilBuilder.getInt(setValueStr);
        } else if (propertyType == long.class || propertyType == Long.class) {
            return DeseriUtilBuilder.getLong(setValueStr);
        } else if (propertyType == String.class) {
            return DeseriUtilBuilder.getString(setValueStr);
        } else if (propertyType == boolean.class || propertyType == Boolean.class) {
            return DeseriUtilBuilder.getBoolean(setValueStr);
        } else {
            return String.format(setValueStr, propertyType.getTypeName() + "Reader.read(is)");
        }
    }

    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    private static String randVariableName(String variableName) {
        return variableName + getRandomString(6);
    }

    public static String getField4ReadStrMap(ParameterizedType parameterizedType, String setValueStr) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments(); /*字段泛型类型*/
        Type KT = actualTypeArguments[0];
        Type VT = actualTypeArguments[1];

        //log.info(parameterizedType.getTypeName());
        //log.info(KT.getTypeName());
        //log.info(VT.getClass());

        Class<?> vtClass = null;
        if (VT instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) VT).getRawType();
            try {
                vtClass = Class.forName(rawType.getTypeName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            vtClass = (Class) VT;
        }

        //String type = actualTypeArgument.getTypeName();
        String len = randVariableName("len");
        String i = randVariableName("i");
        String map = randVariableName("map");
        String _k = randVariableName("_k");
        String _v = randVariableName("_v");
        StringBuilder sb = new StringBuilder();
        sb.append("{int " + len + " = DeseriUtil.getInt(is);");
        sb.append("if (" + len + " > 0) {");
        sb.append(parameterizedType.getTypeName()).append(" "+map+" = new ").append(parameterizedType.getTypeName()).append("();");
        sb.append("for (int " + i + " = 0; " + i + " < " + len + "; " + i + "++) {");

        {

            if (List.class.isAssignableFrom(vtClass)) {
                sb.append(KT.getTypeName()).append(" "+_k+" = ").append(getField4ReadStr(KT, "%s")).append(";");
                sb.append(VT.getTypeName()).append(" "+_v+" = null;");

                sb.append(getField4ReadStrList((ParameterizedType) VT, _v +" = %s;"));

                sb.append(map+".put("+_k+","+_v+");");// putKey
            } else if (Set.class.isAssignableFrom(vtClass)) {
                sb.append(KT.getTypeName()).append(" "+_k+" = ").append(getField4ReadStr(KT, "%s")).append(";");
                sb.append(VT.getTypeName()).append(" "+_v+" = null;");

                sb.append(getField4ReadStrSet((ParameterizedType) VT, _v + " = %s;"));

                sb.append(map+".put("+_k+","+_v+");");// putKey
            } else if (vtClass.isArray()) {
                sb.append(KT.getTypeName()).append(" "+_k+" = ").append(getField4ReadStr(KT, "%s")).append(";");
                sb.append(VT.getTypeName()).append(" "+_v+" = null;");

                Class<?> componentType = vtClass.getComponentType();
                sb.append(getField4ReadStrArr(componentType, _v + " = %s;"));

                sb.append(map+".put("+_k+","+_v+");");// putKey
            } else if (Map.class.isAssignableFrom(vtClass)) {
                sb.append(KT.getTypeName()).append(" "+_k+" = ").append(getField4ReadStr(KT, "%s")).append(";");
                sb.append(VT.getTypeName()).append(" "+_v+" = null;");

                sb.append(getField4ReadStrMap((ParameterizedType) VT, _v+" = %s;"));

                sb.append(map+".put("+_k+","+_v+");");// putKey
            } else {
                //sb.append(getField4ReadStr(VT, _v+" = %s;"));
                sb.append(map+".put(").append(getField4ReadStr(KT, "%s")).append(",").append(getField4ReadStr(VT, "%s")).append(");");
            }
        }

        sb.append("}");
        sb.append(String.format(setValueStr, map));
        sb.append("}}");
        return sb.toString();

    }

    public static String getField4ReadStrList(ParameterizedType parameterizedType, String setValueStr) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments(); /*字段泛型类型*/
        Type actualTypeArgument = actualTypeArguments[0];

        //log.info(actualTypeArgument.getTypeName());
        //log.info(actualTypeArgument.getClass());

        String type = actualTypeArgument.getTypeName();
        StringBuilder sb = new StringBuilder();
        String len = randVariableName("len");
        String i = randVariableName("i");
        String list = randVariableName("list");
        sb.append("{int " + len + " = DeseriUtil.getInt(is);");
        sb.append("if (" + len + " > 0) {");
        sb.append(parameterizedType.getTypeName()).append(" "+list+" = new ArrayList<>();");
        sb.append("for (int " + i + " = 0; " + i + " < " + len + "; " + i + "++) {");
        sb.append(list+".add(").append(getField4ReadStr(actualTypeArgument, "%s"));
        sb.append(");");
        sb.append("}");
        sb.append(String.format(setValueStr, list));
        sb.append("}}");
        return sb.toString();

    }

    public static String getField4ReadStrSet(ParameterizedType parameterizedType, String setValueStr) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments(); /*字段泛型类型*/
        Type actualTypeArgument = actualTypeArguments[0];

        //log.info(actualTypeArgument.getTypeName());
        //log.info(actualTypeArgument.getClass());\

        String type = actualTypeArgument.getTypeName();
        StringBuilder sb = new StringBuilder();
        String len = randVariableName("len");
        String i = randVariableName("i");
        String set = randVariableName("set");
        sb.append("{int " + len + " = DeseriUtil.getInt(is);");
        sb.append("if (" + len + " > 0) {");
        sb.append(parameterizedType.getTypeName()).append(" "+set+" = new HashSet<>();");
        sb.append("for (int " + i + " = 0; " + i + " < " + len + "; " + i + "++) {");
        sb.append(set+".add(").append(getField4ReadStr(actualTypeArgument, "%s"));
        sb.append(");");
        sb.append("}");
        sb.append(String.format(setValueStr, set));
        sb.append("}}");
        return sb.toString();
    }

    public static String getField4ReadStrArr(Class<?> componentType, String setValueStr) {
        String type = componentType.getTypeName();
        StringBuilder sb = new StringBuilder();
        String len = randVariableName("len");
        String i = randVariableName("i");
        String arr = randVariableName("arr");
        sb.append("{int " + len + " = DeseriUtil.getInt(is);");
        sb.append("if (" + len + " > 0) {");
        sb.append(type).append("[] "+arr+" = new ").append(type).append("["+len+"];");
        sb.append("for (int " + i + " = 0; " + i + " < " + len + "; " + i + "++) {");
        sb.append(arr+"[" + i + "] = ").append(getField4ReadStr(componentType, "%s"));
        sb.append(";}");
        sb.append(String.format(setValueStr, arr));
        sb.append("}}");
        return sb.toString();
    }

}
