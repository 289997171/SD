package com.vicking.util.tools.s;

import lombok.extern.slf4j.Slf4j;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

@Slf4j
public class SDFieldWriteBuilder {

    public static String field4Write(Class<?> clazz, String fieldName, boolean isPublic) throws IntrospectionException, NoSuchFieldException {
        Field field;
        if (isPublic) {
            field = clazz.getField(fieldName);
        } else {
            field = clazz.getDeclaredField(fieldName);
        }
        return field4Write(clazz, field, isPublic);
    }

    /**
     * @param clazz
     * @param field
     * @param isPublic
     * @return
     * @throws IntrospectionException
     */
    public static String field4Write(Class<?> clazz, Field field, boolean isPublic) throws IntrospectionException {
        Class<?> propertyClass;  // interface java.util.List
        Type propertyType; // java.util.List<java.lang.Boolean>
        String getValueStr;
        if (isPublic) {
            propertyClass = field.getType();
            propertyType = field.getGenericType();

            // o.xxx
            getValueStr = "o." + field.getName();
        } else {
            // 通过具有 getFoo 和 setFoo 访问器方法
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), clazz);
            propertyClass = propertyDescriptor.getPropertyType();
            propertyType = field.getGenericType();

            Method readMethod = propertyDescriptor.getReadMethod(); // getter
            //Method writeMethod = propertyDescriptor.getWriteMethod(); // setter

            // o.getXXX()
            getValueStr = "o." + readMethod.getName() + "()";
        }

        if (Collection.class.isAssignableFrom(propertyClass)) {
            return getField4WriteStrCollection((ParameterizedType) propertyType, getValueStr);
        } else if (propertyClass.isArray()) {
            Class<?> componentType = propertyClass.getComponentType();
            return getField4WriteStrArr(componentType, getValueStr);
        } else if (Map.class.isAssignableFrom(propertyClass)) {
            return getField4WriteStrMap((ParameterizedType) propertyType, getValueStr);
        } else {
            return getField4WriteStr(propertyType, getValueStr);
        }
    }

    public static String getField4WriteStr(Type propertyType /*字段类型*/, String getValueStr) {
        if (propertyType == Date.class) {
            return SeriUtilBuilder.putDate(getValueStr);
        } else if (propertyType == double.class || propertyType == Double.class) {
            return SeriUtilBuilder.putDouble(getValueStr);
        } else if (propertyType == float.class || propertyType == Float.class) {
            return SeriUtilBuilder.putFloat(getValueStr);
        } else if (propertyType == byte.class || propertyType == Byte.class) {
            return SeriUtilBuilder.putByte(getValueStr);
        } else if (propertyType == short.class || propertyType == Short.class) {
            return SeriUtilBuilder.putShort(getValueStr);
        } else if (propertyType == int.class || propertyType == Integer.class) {
            return SeriUtilBuilder.putInt(getValueStr);
        } else if (propertyType == long.class || propertyType == Long.class) {
            return SeriUtilBuilder.putLong(getValueStr);
        } else if (propertyType == String.class) {
            return SeriUtilBuilder.putString(getValueStr);
        } else if (propertyType == boolean.class || propertyType == Boolean.class) {
            return SeriUtilBuilder.putBoolean(getValueStr);
        } else {
            return propertyType.getTypeName() + "Writer.write(os, " + getValueStr + ");";
        }
    }


    public static String getField4WriteStrMap(ParameterizedType parameterizedType, String getValueStr) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments(); /*字段泛型类型*/
        Type KT = actualTypeArguments[0];
        Type VT = actualTypeArguments[1];

//        log.info("xxxx1");
//        log.info(VT.getTypeName()); //java.util.ArrayList<java.lang.String>
//        log.info(VT.getClass()); //class sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl'
//        log.info(((ParameterizedType) VT).getRawType()); // class java.util.ArrayList
//        log.info("xxxx2");

        StringBuilder sb = new StringBuilder();
        sb.append("if (").append(getValueStr).append(" == null) {").append(SeriUtilBuilder.putShort("0")).append("} else {");
        sb.append("SeriUtil.putShort(os, (short)").append(getValueStr).append(".size());");  // 写入长度
        sb.append("for (Map.Entry<").append(KT.getTypeName()).append(",").append(VT.getTypeName()).append("> entry : ").append(getValueStr).append(".entrySet()) {");
        sb.append(getField4WriteStr(KT, "entry.getKey()"));

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
        //System.out.println(vtClass); // class java.util.ArrayList
        if (Collection.class.isAssignableFrom(vtClass)) {
            sb.append(getField4WriteStrCollection((ParameterizedType) VT, "entry.getValue()"));
        } else if (vtClass.isArray()) {
            Class<?> componentType = vtClass.getComponentType();
            sb.append(getField4WriteStrArr(componentType, "entry.getValue()"));
        } else if (Map.class.isAssignableFrom(vtClass)) {
            sb.append(getField4WriteStrMap((ParameterizedType) VT, "entry.getValue()"));
        } else {
            sb.append(getField4WriteStr(VT, "entry.getValue()"));
        }
//        }
//        if (Collection.class.isAssignableFrom(VT)) {
//            return getField4WriteStrCollection((ParameterizedType) propertyType, getValueStr);
//        } else if (VT.isArray()) {
//            Class<?> componentType = propertyClass.getComponentType();
//            return getField4WriteStrArr(componentType, getValueStr);
//        } else if (Map.class.isAssignableFrom(propertyClass)) {
//            return getField4WriteStrMap((ParameterizedType) propertyType, getValueStr);
//        } else {
//            sb.append(getField4WriteStr(VT, "entry.getValue()"));
//        }
        sb.append("}}");

        return sb.toString();
    }

    public static String getField4WriteStrCollection(ParameterizedType parameterizedType, String getValueStr) {
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments(); /*字段泛型类型*/
        Type actualTypeArgument = actualTypeArguments[0];

        //log.info(actualTypeArgument.getTypeName());
        //log.info(actualTypeArgument.getClass());

        StringBuilder sb = new StringBuilder();
        sb.append("if (").append(getValueStr).append(" == null) {").append(SeriUtilBuilder.putShort("0")).append("} else {");
        sb.append("SeriUtil.putShort(os, (short)").append(getValueStr).append(".size());");  // 写入长度
        sb.append("for (").append(actualTypeArgument.getTypeName()).append(" item : ").append(getValueStr).append(") {");
        sb.append(getField4WriteStr(actualTypeArgument, "item"));
        sb.append("}}");

        return sb.toString();
    }

    public static String getField4WriteStrArr(Class<?> componentType, String getValueStr) {

        //log.info(actualTypeArgument.getTypeName());
        //log.info(actualTypeArgument.getClass());

        StringBuilder sb = new StringBuilder();
        sb.append("if (").append(getValueStr).append(" == null) {").append(SeriUtilBuilder.putShort("0")).append("} else {");
        sb.append("SeriUtil.putShort(os, (short)").append(getValueStr).append(".length);");  // 写入长度
        sb.append("for (").append(componentType.getTypeName()).append(" item : ").append(getValueStr).append(") {");
        sb.append(getField4WriteStr(componentType, "item"));
        sb.append("}}");

        return sb.toString();
    }


}
