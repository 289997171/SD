package com.vicking.util;

import com.vicking.util.tools.*;
import com.vicking.util.tools.d.SDFieldReadBuilder;
import com.vicking.util.tools.d.SDReaderBuilder;
import com.vicking.util.tools.s.SDFieldWriteBuilder;
import com.vicking.util.tools.s.SDWriterBuilder;
import org.junit.jupiter.api.Test;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;

public class Test4 {




    @Test
    public void testSDWriterBuilder() {
        System.out.println(SDWriterBuilder.classWriter(null, "com.xxx.xxx", "XXX"));
    }

    @Test
    public void testSDFieldWR() throws IntrospectionException, NoSuchFieldException {
        Class<?> clazz = Obj1.class;
        boolean isPublic = false;

//        Class<?> clazz = Obj2.class;
//        boolean isPublic = true;
        System.out.println(SDFieldWriteBuilder.field4Write(clazz, "b1", isPublic));
        System.out.println(SDFieldReadBuilder.field4Read(clazz, "b1", isPublic));

        System.out.println(SDFieldWriteBuilder.field4Write(clazz, "date1", isPublic));
        System.out.println(SDFieldReadBuilder.field4Read(clazz, "date1", isPublic));

        System.out.println(SDFieldWriteBuilder.field4Write(clazz, "d1", isPublic));
        System.out.println(SDFieldReadBuilder.field4Read(clazz, "d1", isPublic));

        System.out.println(SDFieldWriteBuilder.field4Write(clazz, "bs1", isPublic));
        System.out.println(SDFieldReadBuilder.field4Read(clazz, "bs1", isPublic));

        System.out.println(SDFieldWriteBuilder.field4Write(clazz, "f1", isPublic));
        System.out.println(SDFieldReadBuilder.field4Read(clazz, "f1", isPublic));

        System.out.println(SDFieldWriteBuilder.field4Write(clazz, "s1", isPublic));
        System.out.println(SDFieldReadBuilder.field4Read(clazz, "s1", isPublic));

        System.out.println(SDFieldWriteBuilder.field4Write(clazz, "i1", isPublic));
        System.out.println(SDFieldReadBuilder.field4Read(clazz, "i1", isPublic));

        System.out.println(SDFieldWriteBuilder.field4Write(clazz, "l1", isPublic));
        System.out.println(SDFieldReadBuilder.field4Read(clazz, "l1", isPublic));

        System.out.println(SDFieldWriteBuilder.field4Write(clazz, "str1", isPublic));
        System.out.println(SDFieldReadBuilder.field4Read(clazz, "str1", isPublic));
    }
    @Test
    public void test1() throws IntrospectionException {
        Class<?> clazz = Obj1.class;


        String classWriter = SDWriterBuilder.classWriter(null, clazz.getPackage().getName(), clazz.getSimpleName());
        String classReader = SDReaderBuilder.classReader(null, clazz.getPackage().getName(), clazz.getSimpleName());

        StringBuilder sb4Writer = new StringBuilder();
        StringBuilder sb4Reader = new StringBuilder();
        Field[] declaredFields = clazz.getDeclaredFields();
        boolean isPublic = false;
        for (Field declaredField : declaredFields) {
            sb4Writer.append(SDFieldWriteBuilder.field4Write(clazz, declaredField, isPublic)).append("\r\n");
            sb4Reader.append(SDFieldReadBuilder.field4Read(clazz, declaredField, isPublic)).append("\r\n");
        }

        System.out.println(String.format(classWriter, sb4Writer));
        System.out.println(String.format(classReader, sb4Reader));
    }

    @Test
    public void test2() throws IntrospectionException {
        Class<?> clazz = Obj1.class;
        SDBuilder.build(clazz);
    }

}
