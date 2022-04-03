package com.vicking.util;

import org.junit.jupiter.api.Test;

public class Test3 {

    private String getValue1 = "o.getXXX()";
    private String getValue2 = "o.xxx";

    private String setValue1 = "o.setXXX(%s);";
    private String setValue2 = "o.xxx = %s;";

    @Test
    public void testBoolean() {
        System.out.println(SeriUtilBuilder.putBoolean(getValue1));
        System.out.println(SeriUtilBuilder.putBoolean(getValue2));

        System.out.println(DeseriUtilBuilder.getBoolean(setValue1));
        System.out.println(DeseriUtilBuilder.getBoolean(setValue2));
    }

    @Test
    public void testDate() {
        System.out.println(SeriUtilBuilder.putDate(getValue1));
        System.out.println(SeriUtilBuilder.putDate(getValue2));

        System.out.println(DeseriUtilBuilder.getDate(setValue1));
        System.out.println(DeseriUtilBuilder.getDate(setValue2));
    }

    @Test
    public void testByte() {
        System.out.println(SeriUtilBuilder.putByte(getValue1));
        System.out.println(SeriUtilBuilder.putByte(getValue2));

        System.out.println(DeseriUtilBuilder.getByte(setValue1));
        System.out.println(DeseriUtilBuilder.getByte(setValue2));
    }

    @Test
    public void testDouble() {
        System.out.println(SeriUtilBuilder.putDouble(getValue1));
        System.out.println(SeriUtilBuilder.putDouble(getValue2));

        System.out.println(DeseriUtilBuilder.getDouble(setValue1));
        System.out.println(DeseriUtilBuilder.getDouble(setValue2));
    }

    @Test
    public void testFloat() {
        System.out.println(SeriUtilBuilder.putFloat(getValue1));
        System.out.println(SeriUtilBuilder.putFloat(getValue2));

        System.out.println(DeseriUtilBuilder.getFloat(setValue1));
        System.out.println(DeseriUtilBuilder.getFloat(setValue2));
    }

    @Test
    public void testShort() {
        System.out.println(SeriUtilBuilder.putFloat(getValue1));
        System.out.println(SeriUtilBuilder.putFloat(getValue2));

        System.out.println(DeseriUtilBuilder.getFloat(setValue1));
        System.out.println(DeseriUtilBuilder.getFloat(setValue2));
    }

    @Test
    public void testInt() {
        System.out.println(SeriUtilBuilder.putInt(getValue1));
        System.out.println(SeriUtilBuilder.putInt(getValue2));

        System.out.println(DeseriUtilBuilder.getInt(setValue1));
        System.out.println(DeseriUtilBuilder.getInt(setValue2));
    }

    @Test
    public void testLong() {
        System.out.println(SeriUtilBuilder.putLong(getValue1));
        System.out.println(SeriUtilBuilder.putLong(getValue2));

        System.out.println(DeseriUtilBuilder.getLong(setValue1));
        System.out.println(DeseriUtilBuilder.getLong(setValue2));
    }

    @Test
    public void testString() {
        System.out.println(SeriUtilBuilder.putString(getValue1));
        System.out.println(SeriUtilBuilder.putString(getValue2));

        System.out.println(DeseriUtilBuilder.getString(setValue1));
        System.out.println(DeseriUtilBuilder.getString(setValue2));
    }

}
