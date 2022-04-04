package com.vicking.util.tools.s;

import java.io.OutputStream;

public class SeriCollectionUtilBuilder {

    public static String putShorts(OutputStream os, String values) {
        return String.format("SeriCollectionUtil.putShorts(os, %s);", values);
    }

    public static String putInts(OutputStream os, String values) {
        return String.format("SeriCollectionUtil.putInts(os, %s);", values);
    }

    public static String putLongs(OutputStream os, String values) {
        return String.format("SeriCollectionUtil.putLongs(os, %s);", values);
    }

    public static String putStrings(OutputStream os, String values) {
        return String.format("SeriCollectionUtil.putStrings(os, %s);", values);
    }

}
