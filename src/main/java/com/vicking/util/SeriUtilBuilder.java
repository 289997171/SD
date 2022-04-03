package com.vicking.util;

public class SeriUtilBuilder {

    public static String putDate(String value) {
        return String.format("SeriUtil.putDate(os, %s);", value);
    }

    public static String putDouble(String value) {
        return String.format("SeriUtil.putDouble(os, %s);", value);
    }

    public static String putFloat(String value) {
        return String.format("SeriUtil.putFloat(os, %s);", value);
    }

    public static String put(String value) {
        return String.format("SeriUtil.put(os, %s);", value);
    }

    public static String putShort(String value) {
        return String.format("SeriUtil.putShort(os, %s);", value);
    }

    public static String putInt(String value) {
        return String.format("SeriUtil.putInt(os, %s);", value);
    }

    public static String putLong(String value) {
        return String.format("SeriUtil.putLong(os, %s);", value);
    }

    public static String putString(String value) {
        return String.format("SeriUtil.putString(os, %s);", value);
    }

}
