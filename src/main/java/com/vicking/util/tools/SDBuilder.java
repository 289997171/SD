package com.vicking.util.tools;

import com.vicking.util.ann.SD_Group;
import com.vicking.util.ann.SD_NO;
import com.vicking.util.tools.d.SDFieldReadBuilder;
import com.vicking.util.tools.d.SDReaderBuilder;
import com.vicking.util.tools.s.SDFieldWriteBuilder;
import com.vicking.util.tools.s.SDWriterBuilder;

import java.beans.IntrospectionException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class SDBuilder {

    public static final String ENDTAG = "\r\n";

    public static void build(Class<?> clazz, String groupName) throws IntrospectionException {
        String packageName = clazz.getPackage().getName();
        String classSimpleName = clazz.getSimpleName();

        String classWriter = SDWriterBuilder.classWriter(groupName,packageName, classSimpleName);
        String classReader = SDReaderBuilder.classReader(groupName, packageName, classSimpleName);

        StringBuilder sb4Writer = new StringBuilder();
        StringBuilder sb4Reader = new StringBuilder();

        Set<Field> publicFields = new HashSet<>();
        {
            boolean isPublic = true;
            for (Field pubField : clazz.getFields()) {
                SD_NO sd_no = pubField.getAnnotation(SD_NO.class);
                if (sd_no != null) continue;

                boolean isCurGroup = true;

                if (groupName != null && !groupName.trim().equalsIgnoreCase("")) {
                    SD_Group[] sd_groups = pubField.getAnnotationsByType(SD_Group.class);
                    if (sd_groups.length > 0) isCurGroup = false;

                    for (SD_Group sd_group : sd_groups) {
                        if (sd_group != null && sd_group.value().equalsIgnoreCase(groupName)) {
                            isCurGroup = true;
                            break;
                        }
                    }
                }

                if (isCurGroup) {
                    sb4Writer.append(SDFieldWriteBuilder.field4Write(clazz, pubField, isPublic)).append(ENDTAG);
                    sb4Reader.append(SDFieldReadBuilder.field4Read(clazz, pubField, isPublic)).append(ENDTAG);
                    publicFields.add(pubField);
                }
            }
        }

        {
            boolean isPublic = false;
            for (Field declaredField : clazz.getDeclaredFields()) {
                SD_NO sd_no = declaredField.getAnnotation(SD_NO.class);
                if (sd_no != null) continue;
                if (publicFields.contains(declaredField)) continue;

                boolean isCurGroup = true;

                if (groupName != null && !groupName.trim().equalsIgnoreCase("")) {
                    SD_Group[] sd_groups = declaredField.getAnnotationsByType(SD_Group.class);
                    if (sd_groups.length > 0) isCurGroup = false;

                    for (SD_Group sd_group : sd_groups) {
                        if (sd_group != null && sd_group.value().equalsIgnoreCase(groupName)) {
                            isCurGroup = true;
                            break;
                        }
                    }
                }

                if (isCurGroup) {
                    sb4Writer.append(SDFieldWriteBuilder.field4Write(clazz, declaredField, isPublic)).append(ENDTAG);
                    sb4Reader.append(SDFieldReadBuilder.field4Read(clazz, declaredField, isPublic)).append(ENDTAG);
                }
            }
        }

        //System.out.println(String.format(classWriter, sb4Writer));
        //System.out.println(String.format(classReader, sb4Reader));
        genFiles(groupName, packageName, classSimpleName, String.format(classWriter, sb4Writer), String.format(classReader, sb4Reader));
    }


    public static void build(Class<?> clazz) throws IntrospectionException {
        Set<String> groupNames = new HashSet<>();

        {
            SD_Group[] sd_groups = clazz.getAnnotationsByType(SD_Group.class);
            for (SD_Group sd_group : sd_groups) groupNames.add(sd_group.value());
        }


        for (Field pubField : clazz.getFields()) {
            SD_Group[] sd_groups = pubField.getAnnotationsByType(SD_Group.class);
            for (SD_Group sd_group : sd_groups) groupNames.add(sd_group.value());
        }

        for (Field declaredField : clazz.getDeclaredFields()) {
            SD_Group[] sd_groups = declaredField.getAnnotationsByType(SD_Group.class);
            for (SD_Group sd_group : sd_groups) groupNames.add(sd_group.value());
        }

        if (groupNames.isEmpty()) {
            build(clazz, null);
        } else {
            for (String groupName : groupNames) {
                build(clazz, groupName);
            }
        }
    }

    public static void genFiles(String groupName, String packageName, String classSimpleName, String sb4Writer, String sb4Reader) {
        try {
            String packagePath = packageName.replace(".", "/");
            FileWriter fileWriter1 = new FileWriter("./src/main/java/" + packagePath + "/" + classSimpleName + (groupName == null ? "" : groupName) + "Writer.java");
            fileWriter1.write(sb4Writer.toString());
            fileWriter1.flush();
            FileWriter fileWriter2 = new FileWriter("./src/main/java/" + packagePath + "/" + classSimpleName + (groupName == null ? "" : groupName) + "Reader.java");
            fileWriter2.write(sb4Reader.toString());
            fileWriter2.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
