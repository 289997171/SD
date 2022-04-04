package com.vicking.util.tools.d;

import java.util.Collection;

import static com.vicking.util.tools.SDBuilder.ENDTAG;

public class DeseriCollectionUtilBuilder {

    public static String getBooleans(String value) {
        String s = "{Collection<Boolean> __list = DeseriUtil.getBooleans(is);" +
                   "if(__list != null) " +
                    "%s.addAll(__list);}";
        return String.format(s, value);
    }

    public static String getDate(String value) {
        return String.format(value, "DeseriCollectionUtil.getDates(is)");
    }

    public static String getDouble(String value) {
        return String.format(value, "DeseriCollectionUtil.getDoubles(is)");
    }

    public static String getFloat(String value) {
        return String.format(value, "DeseriCollectionUtil.getFloats(is)");
    }

    public static String getByte(String value) {
        return String.format(value, "DeseriCollectionUtil.getBytes(is)");
    }

    public static String getShort(String value) {
        return String.format(value, "DeseriCollectionUtil.getShorts(is)");
    }

    public static String getInt(String value) {
        return String.format(value, "DeseriCollectionUtil.getInts(is)");
    }


    public static String getLong(String value) {
        return String.format(value, "DeseriCollectionUtil.getLongs(is)");
    }

    public static String getString(String value) {
        return String.format(value, "DeseriCollectionUtil.getStrings(is)");
    }


}
