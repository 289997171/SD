package com.vicking.util.tools;

import com.vicking.util.DeseriUtilBuilder;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class SDFieldReadBuilder {

    /**
     * public 的属性
     * @param clazz
     * @param field
     * @return
     * @throws IntrospectionException
     */
    public static String field4ReadPub(Class<?> clazz, Field field) {
        Class<?> propertyType = field.getType();
        // o.xxx
        String getValueStr = "o." + field.getName() + "= %s;";

        return getField4ReadStr(propertyType, getValueStr);
    }

    /**
     * get set 属性
     * @param clazz
     * @param field
     * @return
     * @throws IntrospectionException
     */
    public static String field4Read(Class<?> clazz, Field field) throws IntrospectionException {
        // 通过具有 getFoo 和 setFoo 访问器方法
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), clazz);
        //Method readMethod = propertyDescriptor.getReadMethod(); // getter
        Method writeMethod = propertyDescriptor.getWriteMethod(); // setter
        Class<?> propertyType = propertyDescriptor.getPropertyType(); // 属性类型
        // o.getXXX()
        String getValueStr = "o." + writeMethod.getName() + "(%s);";

        return getField4ReadStr(propertyType, getValueStr);
    }

    public static String getField4ReadStr(Class<?> propertyType, String getValueStr) {
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
        }else if (propertyType == int.class || propertyType == Integer.class) {
            return DeseriUtilBuilder.getInt(getValueStr);
        } else if (propertyType == long.class || propertyType == Long.class) {
            return DeseriUtilBuilder.getLong(getValueStr);
        } else if (propertyType == String.class) {
            return DeseriUtilBuilder.getString(getValueStr);
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
