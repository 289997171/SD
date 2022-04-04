package com.vicking.util.tools;

import com.vicking.util.tools.d.SDFieldReadBuilder;
import com.vicking.util.tools.d.SDReaderBuilder;
import com.vicking.util.tools.s.SDFieldWriteBuilder;
import com.vicking.util.tools.s.SDWriterBuilder;

import java.beans.IntrospectionException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

public class SDBuilder {

    public static final String ENDTAG = "\r\n";

    public static void build(Class<?> clazz) throws IntrospectionException {
        String packageName = clazz.getPackage().getName();
        String classSimpleName = clazz.getSimpleName();

        String classWriter = SDWriterBuilder.classWriter(packageName, classSimpleName);
        String classReader = SDReaderBuilder.classReader(packageName, classSimpleName);

        StringBuilder sb4Writer = new StringBuilder();
        StringBuilder sb4Reader = new StringBuilder();

        {
            Field[] publicFields = clazz.getFields();
            boolean isPublic = true;
            for (Field declaredField : publicFields) {
                sb4Writer.append(SDFieldWriteBuilder.field4Write(clazz, declaredField, isPublic)).append(ENDTAG);
                sb4Reader.append(SDFieldReadBuilder.field4Read(clazz, declaredField, isPublic)).append(ENDTAG);
            }
        }

        {
            Field[] declaredFields = clazz.getDeclaredFields();
            boolean isPublic = false;
            for (Field declaredField : declaredFields) {
                sb4Writer.append(SDFieldWriteBuilder.field4Write(clazz, declaredField, isPublic)).append(ENDTAG);
                sb4Reader.append(SDFieldReadBuilder.field4Read(clazz, declaredField, isPublic)).append(ENDTAG);
            }
        }

        genFiles(packageName, classSimpleName, String.format(classWriter, sb4Writer), String.format(classReader, sb4Reader));
    }

    public static void genFiles(String packageName, String classSimpleName, String sb4Writer, String sb4Reader) {
        try {
            String packagePath = packageName.replace(".", "/");
            FileWriter fileWriter1 = new FileWriter("./src/main/java/" + packagePath + "/" + classSimpleName + "Writer.java");
            fileWriter1.write(sb4Writer.toString());
            fileWriter1.flush();
            FileWriter fileWriter2 = new FileWriter("./src/main/java/" + packagePath + "/" + classSimpleName + "Reader.java");
            fileWriter2.write(sb4Reader.toString());
            fileWriter2.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
