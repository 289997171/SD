package com.vicking.util.tools;

import com.vicking.util.SeriUtilBuilder;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class SDFieldWriteBuilder {

    /**
     * public 的属性
     * @param clazz
     * @param field
     * @return
     * @throws IntrospectionException
     */
    public static String field4WritePub(Class<?> clazz, Field field) {
        Class<?> propertyType = field.getType();
        // o.xxx
        String getValueStr = "o." + field.getName();

        return getField4WriteStr(propertyType, getValueStr);
    }

    /**
     * get set 属性
     * @param clazz
     * @param field
     * @return
     * @throws IntrospectionException
     */
    public static String field4Write(Class<?> clazz, Field field) throws IntrospectionException {
        // 通过具有 getFoo 和 setFoo 访问器方法
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), clazz);
        Method readMethod = propertyDescriptor.getReadMethod(); // getter
        //Method writeMethod = propertyDescriptor.getWriteMethod(); // setter
        Class<?> propertyType = propertyDescriptor.getPropertyType(); // 属性类型
        // o.getXXX()
        String getValueStr = "o." + readMethod.getName() + "()";

        return getField4WriteStr(propertyType, getValueStr);
    }

    public static String getField4WriteStr(Class<?> propertyType, String getValueStr) {
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
        }else if (propertyType == int.class || propertyType == Integer.class) {
            return SeriUtilBuilder.putInt(getValueStr);
        } else if (propertyType == long.class || propertyType == Long.class) {
            return SeriUtilBuilder.putLong(getValueStr);
        } else if (propertyType == String.class) {
            return SeriUtilBuilder.putString(getValueStr);
        } else if (propertyType == boolean.class || propertyType == Boolean.class) {
            return SeriUtilBuilder.putBoolean(getValueStr);
        } else if (Collection.class.isAssignableFrom(propertyType)) {

            throw new RuntimeException("尚未实现");
        } else if (Map.class.isAssignableFrom(propertyType)) {
            throw new RuntimeException("尚未实现");
        }
        // TODO 暂时不考虑数组情况,所有数组用List代替
        else if (propertyType.isArray()) {
            throw new RuntimeException("尚未实现");
        }
        else {
            throw new RuntimeException("尚未实现");
        }
    }


}
