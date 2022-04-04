package com.vicking.util.tools.s;

public class SeriCollectionUtilBuilder {

    public static String putBooleans(String values) {
        return String.format("SeriCollectionUtil.putBooleans(os, %s);", values);
    }

    public static String putDates(String values) {
        return String.format("SeriCollectionUtil.putDates(os, %s);", values);
    }

    public static String putDoubles(String values) {
        return String.format("SeriCollectionUtil.putDoubles(os, %s);", values);
    }

    public static String putFloats(String values) {
        return String.format("SeriCollectionUtil.putFloats(os, %s);", values);
    }

    public static String putBytes(String values) {
        return String.format("SeriCollectionUtil.putBytes(os, %s);", values);
    }

    public static String putShorts(String values) {
        return String.format("SeriCollectionUtil.putShorts(os, %s);", values);
    }

    public static String putInts(String values) {
        return String.format("SeriCollectionUtil.putInts(os, %s);", values);
    }

    public static String putLongs(String values) {
        return String.format("SeriCollectionUtil.putLongs(os, %s);", values);
    }

    public static String putStrings(String values) {
        return String.format("SeriCollectionUtil.putStrings(os, %s);", values);
    }

}
