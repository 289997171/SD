package com.vicking.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {

//    @Getter @Setter @ToString
//    public static class Obj1 {
//        private boolean b1;
//        private boolean b2;
//
//        private Date date1;
//        private Date date2;
//
//        private double d1;
//        private double d2;
//
//        private byte bs1;
//        private byte bs2;
//
//        private float f1;
//        private float f2;
//
//        private short s1;
//        private short s2;
//
//        private int i1;
//        private int i2;
//
//        private long l1;
//        private long l2;
//
//        private String str1;
//        private String str2;
//
//    }


    @Test
    public void testBoolean() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriUtil.putBoolean(os, true);
        SeriUtil.putBoolean(os, false);

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        System.out.println(DeseriUtil.getBoolean(is));
        System.out.println(DeseriUtil.getBoolean(is));
    }

    @Test
    public void testDate() throws IOException, ParseException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriUtil.putDate(os, new Date());
        SeriUtil.putDate(os, new SimpleDateFormat("yyyy-MM-dd").parse("3199-03-03"));

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        System.out.println(DeseriUtil.getDate(is));
        System.out.println(DeseriUtil.getDate(is));
    }

    @Test
    public void testByte() throws IOException, ParseException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriUtil.put(os, (byte)123);
        SeriUtil.put(os, Byte.MAX_VALUE);
        SeriUtil.put(os, Byte.MIN_VALUE);

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        System.out.println(DeseriUtil.get(is));
        System.out.println(DeseriUtil.get(is));
        System.out.println(DeseriUtil.get(is));
    }

    @Test
    public void testDouble() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriUtil.putDouble(os, Double.MIN_VALUE);
        SeriUtil.putDouble(os, Double.MAX_VALUE);
        SeriUtil.putDouble(os, 123.456);

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        assert (DeseriUtil.getDouble(is) == Double.MIN_VALUE);
        assert (DeseriUtil.getDouble(is) == Double.MAX_VALUE);
        System.out.println(DeseriUtil.getDouble(is));
    }

    @Test
    public void testFloat() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriUtil.putFloat(os, 123321.456654f);
        SeriUtil.putFloat(os, -123321.456654f);

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        System.out.println(DeseriUtil.getFloat(is));
        System.out.println(DeseriUtil.getFloat(is));
    }

    @Test
    public void testShort() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriUtil.putShort(os, Short.MIN_VALUE);
        SeriUtil.putShort(os, Short.MAX_VALUE);
        SeriUtil.putShort(os, Short.MAX_VALUE);
        SeriUtil.putShort(os, 1234);

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        assert (DeseriUtil.getShort(is) == Short.MIN_VALUE);
        assert (DeseriUtil.getShort(is) == Short.MAX_VALUE);
        System.out.println(DeseriUtil.getShort(is));
        System.out.println(DeseriUtil.getShort(is));
    }

    @Test
    public void testInt() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriUtil.putInt(os, Integer.MIN_VALUE);
        SeriUtil.putInt(os, Integer.MAX_VALUE);
        SeriUtil.putInt(os, Integer.MAX_VALUE);
        SeriUtil.putInt(os, 12345678);

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        assert (DeseriUtil.getInt(is) == Integer.MIN_VALUE);
        assert (DeseriUtil.getInt(is) == Integer.MAX_VALUE);
        System.out.println(DeseriUtil.getInt(is));
        System.out.println(DeseriUtil.getInt(is));
    }

    @Test
    public void testLong() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriUtil.putLong(os, Long.MIN_VALUE);
        SeriUtil.putLong(os, Long.MAX_VALUE);
        SeriUtil.putLong(os, Long.MAX_VALUE);
        SeriUtil.putLong(os, 12345678);

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        assert (DeseriUtil.getLong(is) == Long.MIN_VALUE);
        assert (DeseriUtil.getLong(is) == Long.MAX_VALUE);
        System.out.println(DeseriUtil.getLong(is));
        System.out.println(DeseriUtil.getLong(is));
    }

    @Test
    public void testString() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriUtil.putString(os, "12345678");
        SeriUtil.putString(os, "asdasdas");
        SeriUtil.putString(os, "@$%##@");
        SeriUtil.putString(os, "中国中文");

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        System.out.println(DeseriUtil.getString(is));
        System.out.println(DeseriUtil.getString(is));
        System.out.println(DeseriUtil.getString(is));
        System.out.println(DeseriUtil.getString(is));
    }

}
