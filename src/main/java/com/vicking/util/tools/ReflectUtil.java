package com.vicking.util.tools;

import com.vicking.util.ann.SD_NO;
import com.vicking.util.others.SeriWriterUtil;
import lombok.extern.slf4j.Slf4j;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class ReflectUtil {
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

    public static List<SeriWriterUtil.FieldInfo> getFieldInfos(Class<?> clazz, boolean withSuperClassFields) {

        Object instance;
        try {
            Constructor<?> constructor = clazz.getConstructor();
            instance = constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(clazz.getName() + " 没有默认构造函数");
        }


        List<SeriWriterUtil.FieldInfo> needSD = new ArrayList<>();

        ArrayList<Field> pubFields = new ArrayList<>(); // public  属性
        ArrayList<Field> allFields = new ArrayList<>(); // private 属性

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
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(allField.getName(), clazz);
                    //获得get方法
                    Method readMethod = propertyDescriptor.getReadMethod();
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    if (readMethod != null && writeMethod != null) {
                        //System.out.println("readMethod ; " + readMethod);
                        SeriWriterUtil.FieldInfo fieldInfo = getFieldInfo(allField, readMethod, writeMethod, instance);
                        fieldInfo.propertyDescriptor = propertyDescriptor;
                        needSD.add(fieldInfo);
                    } else {
                        log.error(allField.getName() + " 没有read write函数1");
                    }
                } catch (IntrospectionException e) {
                    log.error(allField.getName() + " 没有read write函数2");
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

    public static SeriWriterUtil.FieldInfo getFieldInfo(Field field, Method readMethod, Method writeMethod, Object instance) {
        SeriWriterUtil.FieldInfo fieldInfo = new SeriWriterUtil.FieldInfo();
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
}
