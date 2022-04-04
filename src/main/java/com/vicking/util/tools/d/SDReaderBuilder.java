package com.vicking.util.tools.d;

import com.vicking.util.pojo.User;

public class SDReaderBuilder {

    private static final String ENDWORD = "\r\n";

    /**
     * 类的Reader
     * @param packageName clazz.getPackage().getName()
     * @param classSimpleName clazz.getSimpleName()
     * @return
     */
    public static String classReader(String packageName, String classSimpleName) {
        return new StringBuilder()
        .append("package ").append(packageName).append(";").append(ENDWORD)
        .append("import java.io.IOException;").append(ENDWORD)
        .append("import java.io.InputStream;").append(ENDWORD)
        .append("import java.util.*;").append(ENDWORD)
        .append("public class ").append(classSimpleName).append("Reader {").append(ENDWORD)
        .append("\tpublic static ").append(classSimpleName).append(" read(InputStream is) throws IOException {").append(ENDWORD)
        .append("\t\tif(is.read() == 0) return null;").append(ENDWORD)
        .append("\t\t").append(classSimpleName).append(" o = new ").append(classSimpleName).append("();").append(ENDWORD)

                .append("\t\t%s").append(ENDWORD) // 需要补全的内容

        .append("\t\treturn o;").append(ENDWORD)
        .append("\t}").append(ENDWORD)
        .append("}")
        .toString();
    }

    public static void main(String[] args) {
        Class<?> clazz = User.class;
        String packageName = clazz.getPackage().getName();
        String classSimpleName = clazz.getSimpleName();
        String classReaderStr = classReader(packageName, classSimpleName);
        System.out.println(classReaderStr);
    }
}
