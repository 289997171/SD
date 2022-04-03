package com.vicking.util;

public class DeseriUtilBuilder {

    public static String getBoolean(String value) {
        return String.format("DeseriUtil.getBoolean(is, %s);", value);
    }

    public static  String getDate(String value) {
        return String.format("DeseriUtil.getDate(is, %s);", value);
    }

    public static String getDouble(String value) {
        return String.format("DeseriUtil.getDouble(is, %s);", value);
    }

    public static String getFloat(String value) {
        return String.format("DeseriUtil.getFloat(is, %s);", value);
    }

    public static String get(String value) {
        return String.format("DeseriUtil.get(is, %s);", value);
    }

    public static String getShort(String value) {
        return String.format("DeseriUtil.getShort(is, %s);", value);
    }

    public static String getInt(String value) {
        return String.format("DeseriUtil.getInt(is, %s);", value);
    }


    public static String getLong(String value) {
        return String.format("DeseriUtil.getLong(is, %s);", value);
    }

    public static String getString(String value) {
        return String.format("DeseriUtil.getString(is, %s);", value);
    }


}
