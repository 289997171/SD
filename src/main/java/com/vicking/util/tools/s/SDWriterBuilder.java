package com.vicking.util.tools.s;

public class SDWriterBuilder {

    private static final String ENDWORD = "\r\n";

    /**
     * 类的Builder
     * @param packageName clazz.getPackage().getName()
     * @param classSimpleName clazz.getSimpleName()
     * @return
     */
    public static String classWriter(String groupName, String packageName, String classSimpleName) {
        return new StringBuilder()
            .append("package ").append(packageName).append(";").append(ENDWORD)
            .append("import java.io.IOException;").append(ENDWORD)
            .append("import java.io.OutputStream;").append(ENDWORD)
            .append("import java.util.*;").append(ENDWORD)
            .append("public class ").append(classSimpleName).append(groupName == null ? "" : groupName).append("Writer {").append(ENDWORD)
            .append("\tpublic static void write(OutputStream os,").append(classSimpleName).append(" o) throws IOException {").append(ENDWORD)
            .append("\t\tif (o == null) {").append(ENDWORD)
            .append("\t\t\tos.write(0);").append(ENDWORD)
            .append("\t\t\treturn;").append(ENDWORD)
            .append("\t\t}").append(ENDWORD)
            .append("\t\tos.write(1);").append(ENDWORD)

                .append("\t\t%s").append(ENDWORD) // 需要补全的内容

            .append("\t}").append(ENDWORD)
            .append("}")
            .toString();
    }

}
