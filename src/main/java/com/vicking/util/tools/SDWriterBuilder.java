package com.vicking.util.tools;

import com.vicking.util.pojo.User;

public class SDWriterBuilder {

    private static final String ENDWORD = "\r\n";

    /**
     * 类的Builder
     * @param packageName clazz.getPackage().getName()
     * @param classSimpleName clazz.getSimpleName()
     * @return
     */
    public static String classWriter(String packageName, String classSimpleName) {
        return new StringBuilder()
            .append("package ").append(packageName).append(";").append(ENDWORD)
            .append("import java.io.IOException;").append(ENDWORD)
            .append("import java.io.OutputStream;").append(ENDWORD)
            .append("import java.util.Map;").append(ENDWORD)
            .append("public class ").append(classSimpleName).append("Writer {").append(ENDWORD)
            .append("\tpublic static void write(OutputStream os,").append(classSimpleName).append(" o) throws IOException {").append(ENDWORD)
            .append("\t\tif (o == null) {").append(ENDWORD)
            .append("\t\t\tSeriUtil.put(os, (byte)0);").append(ENDWORD)
            .append("\t\t\treturn;").append(ENDWORD)
            .append("\t\t}").append(ENDWORD)
            .append("\t\tSeriUtil.put(os, (byte)1);").append(ENDWORD)

                .append("\t\t%s").append(ENDWORD) // 需要补全的内容

            .append("\t}").append(ENDWORD)
            .append("}")
            .toString();
    }





    public static void main(String[] args) {
        Class<?> clazz = User.class;
        String packageName = clazz.getPackage().getName();
        String classSimpleName = clazz.getSimpleName();
        String classWriterStr = classWriter(packageName, classSimpleName);
        System.out.println(classWriterStr);
    }
}
