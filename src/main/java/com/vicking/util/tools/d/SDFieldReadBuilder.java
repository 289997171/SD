package com.vicking.util.tools.d;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

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
     *
     * @param clazz
     * @param field
     * @param isPublic
     * @return
     * @throws IntrospectionException
     */
    public static String field4Read(Class<?> clazz, Field field, boolean isPublic) throws IntrospectionException {
        Class<?> propertyClass;  // interface java.util.List
        Type propertyType; // java.util.List<java.lang.Boolean>
        String getValueStr;
        if (isPublic) {
            propertyClass = field.getType();
            propertyType = field.getGenericType();
            // o.xxx

            getValueStr = "o." + field.getName() + "= %s;";
        } else {
            // 通过具有 getFoo 和 setFoo 访问器方法
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), clazz);
            propertyClass = propertyDescriptor.getPropertyType();
            propertyType = field.getGenericType();

            //Method readMethod = propertyDescriptor.getReadMethod(); // getter
            Method writeMethod = propertyDescriptor.getWriteMethod(); // setter

            // o.getXXX()
            getValueStr = "o." + writeMethod.getName() + "(%s);";
        }

        if (List.class.isAssignableFrom(propertyClass)) {
            return getField4ReadStrList((ParameterizedType) propertyType, getValueStr);
        } else if (Set.class.isAssignableFrom(propertyClass)) {
            return getField4ReadStrSet((ParameterizedType) propertyType, getValueStr);
        } else if (propertyClass.isArray()) {
            Class<?> componentType = propertyClass.getComponentType();
            return getField4ReadStrArr(componentType, getValueStr);
        } else {
            return getField4ReadStr(propertyType, getValueStr);
        }

    }

    public static String getField4ReadStr(Type propertyType, String getValueStr) {
        if (propertyType == Date.class) {
            return DeseriUtilBuilder.getDate(getValueStr);
        } else if (propertyType == double.class || propertyType == Double.class) {
            return DeseriUtilBuilder.getDouble(getValueStr);
        } else if (propertyType == float.class || propertyType == Float.class) {
            return DeseriUtilBuilder.getFloat(getValueStr);
        } else if (propertyType == byte.class || propertyType == Byte.class) {
            return DeseriUtilBuilder.getByte(getValueStr);
        } else if (propertyType == short.class || propertyType == Short.class) {
            return DeseriUtilBuilder.getShort(getValueStr);
        } else if (propertyType == int.class || propertyType == Integer.class) {
            return DeseriUtilBuilder.getInt(getValueStr);
        } else if (propertyType == long.class || propertyType == Long.class) {
            return DeseriUtilBuilder.getLong(getValueStr);
        } else if (propertyType == String.class) {
            return DeseriUtilBuilder.getString(getValueStr);
        } else if (propertyType == boolean.class || propertyType == Boolean.class) {
            return DeseriUtilBuilder.getBoolean(getValueStr);
        }
//        else if (Collection.class.isAssignableFrom(propertyType)) {
//            throw new RuntimeException("尚未实现: " + propertyType);
//        } else if (Map.class.isAssignableFrom(propertyType)) {
//            throw new RuntimeException("尚未实现: " + propertyType);
//        }
//        // TODO 暂时不考虑数组情况,所有数组用List代替
//        else if (propertyType.isArray()) {
//            throw new RuntimeException("尚未实现: " + propertyType);
//        }
        else {
            throw new RuntimeException("尚未实现: " + propertyType);
        }
    }

    public static String getField4ReadStrList(ParameterizedType parameterizedType, String getValueStr){
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments(); /*字段泛型类型*/
        Type actualTypeArgument = actualTypeArguments[0];

        System.out.println(actualTypeArgument.getTypeName());
        System.out.println(actualTypeArgument.getClass());

        if (actualTypeArgument == Date.class) {
            return DeseriCollectionUtilBuilder.getDatesList(getValueStr);
        } else if (actualTypeArgument == double.class || actualTypeArgument == Double.class) {
            return DeseriCollectionUtilBuilder.getDoublesList(getValueStr);
        } else if (actualTypeArgument == float.class || actualTypeArgument == Float.class) {
            return DeseriCollectionUtilBuilder.getFloatsList(getValueStr);
        } else if (actualTypeArgument == byte.class || actualTypeArgument == Byte.class) {
            return DeseriCollectionUtilBuilder.getBytesList(getValueStr);
        } else if (actualTypeArgument == short.class || actualTypeArgument == Short.class) {
            return DeseriCollectionUtilBuilder.getShortsList(getValueStr);
        } else if (actualTypeArgument == int.class || actualTypeArgument == Integer.class) {
            return DeseriCollectionUtilBuilder.getIntsList(getValueStr);
        } else if (actualTypeArgument == long.class || actualTypeArgument == Long.class) {
            return DeseriCollectionUtilBuilder.getLongsList(getValueStr);
        } else if (actualTypeArgument == String.class) {
            return DeseriCollectionUtilBuilder.getStringsList(getValueStr);
        } else if (actualTypeArgument == boolean.class || actualTypeArgument == Boolean.class) {
            return DeseriCollectionUtilBuilder.getBooleansList(getValueStr);
        } else {
            throw new RuntimeException("尚未实现: " + actualTypeArgument);
        }

    }

    public static String getField4ReadStrSet(ParameterizedType parameterizedType, String getValueStr){
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments(); /*字段泛型类型*/
        Type actualTypeArgument = actualTypeArguments[0];

        //System.out.println(actualTypeArgument.getTypeName());
        //System.out.println(actualTypeArgument.getClass());\

        String type = actualTypeArgument.getTypeName();
        StringBuilder sb = new StringBuilder();
        sb.append("{int len = DeseriUtil.getShort(is);");
        sb.append("if (len > 0) {");
        sb.append("HashSet<").append(type).append("> set = new HashSet<>();");
        sb.append("for (int i = 0; i < len; i++) {");
        sb.append("set.add(").append(getField4ReadStr(actualTypeArgument, "%s"));
        sb.append(");");
        sb.append("}}}");
        return sb.toString();
    }

    public static String getField4ReadStrArr(Class<?> componentType, String getValueStr){
        String type = componentType.getTypeName();
        StringBuilder sb = new StringBuilder();
        sb.append("{int len = DeseriUtil.getShort(is);");
        sb.append("if (len > 0) {");
        sb.append(type).append("[] arr = new ").append(type).append("[len];");
        sb.append("for (int i = 0; i < len; i++) {");
        sb.append("arr[i] = ").append(getField4ReadStr(componentType, getValueStr));
        sb.append("}");
        sb.append("}");
        return sb.toString();
    }

}
