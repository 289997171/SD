package com.vicking.util.tools.d;

public class DeseriUtilBuilder {

    public static String getBoolean(String value) {
        return String.format(value, "DeseriUtil.getBoolean(is)");
    }

    public static  String getDate(String value) {
        return String.format(value, "DeseriUtil.getDate(is)");
    }

    public static String getDouble(String value) {
        return String.format(value, "DeseriUtil.getDouble(is)");
    }

    public static String getFloat(String value) {
        return String.format(value, "DeseriUtil.getFloat(is)");
    }

    public static String getByte(String value) {
        return String.format(value, "DeseriUtil.getByte(is)");
    }

    public static String getShort(String value) {
        return String.format(value, "(short)DeseriUtil.getVarInt(is, 3)");
    }

    public static String getInt(String value) {
        return String.format(value, "(int)DeseriUtil.getVarInt(is, 5)");
    }


    public static String getLong(String value) {
        return String.format(value, "DeseriUtil.getVarInt(is, 10)");
    }

    public static String getString(String value) {
        return String.format(value, "DeseriUtil.getString(is)");
    }


}
