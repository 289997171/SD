package com.vicking.util;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;

public class Test2 {

    @Test
    public void testBoolean() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        SeriCollectionUtil.putBooleans(os, true, false, true, false);
        SeriCollectionUtil.putBooleans(os, Lists.newArrayList(false, true, false, true));

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        DeseriCollectionUtil.getBooleans(is).forEach(System.out::println);
        DeseriCollectionUtil.getBooleans(is).forEach(System.out::println);
    }

    @Test
    public void testDate() throws IOException, ParseException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        long now = System.currentTimeMillis();
        Random random = new Random();
        SeriCollectionUtil.putDates(os, new Date(now), new Date(now + random.nextInt()), new Date(now + random.nextInt()));
        SeriCollectionUtil.putDates(os, Lists.newArrayList(new Date(now), new Date(now + random.nextInt()), new Date(now + random.nextInt())));

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        DeseriCollectionUtil.getDates(is).forEach(System.out::println);
        DeseriCollectionUtil.getDates(is).forEach(System.out::println);
    }

    @Test
    public void testByte() throws IOException, ParseException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriCollectionUtil.putBytes(os, (byte) 123, (byte) 123, (byte) 123, (byte) 123);
        SeriCollectionUtil.putBytes(os, Lists.newArrayList((byte) 123, (byte) 123, (byte) 123, (byte) 123));

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        DeseriCollectionUtil.getBytes(is).forEach(System.out::println);
        DeseriCollectionUtil.getBytes(is).forEach(System.out::println);
    }

    @Test
    public void testDouble() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriCollectionUtil.putDoubles(os, 3.14);
        SeriCollectionUtil.putDoubles(os, 314.159);
        SeriCollectionUtil.putDoubles(os, 123.456,123.456,123.456,123.456);
        SeriCollectionUtil.putDoubles(os, Lists.newArrayList(456.456,456.456,456.456,456.456));

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        DeseriCollectionUtil.getDoubles(is).forEach(System.out::println);
        DeseriCollectionUtil.getDoubles(is).forEach(System.out::println);
        DeseriCollectionUtil.getDoubles(is).forEach(System.out::println);
        DeseriCollectionUtil.getDoubles(is).forEach(System.out::println);
    }

    @Test
    public void testFloat() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriCollectionUtil.putFloats(os, 123321.456654f);
        SeriCollectionUtil.putFloats(os, -123321.456654f);

        SeriCollectionUtil.putFloats(os, 123.456f,123.456f,123.456f,123.456f);
        SeriCollectionUtil.putFloats(os, Lists.newArrayList(456.456f,456.456f,456.456f,456.456f));

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        DeseriCollectionUtil.getFloats(is).forEach(System.out::println);
        DeseriCollectionUtil.getFloats(is).forEach(System.out::println);
        DeseriCollectionUtil.getFloats(is).forEach(System.out::println);
        DeseriCollectionUtil.getFloats(is).forEach(System.out::println);
    }

    @Test
    public void testShort() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriCollectionUtil.putShorts(os, Short.MIN_VALUE);
        SeriCollectionUtil.putShorts(os, Short.MAX_VALUE);
        SeriCollectionUtil.putShorts(os, (short)1234,(short)1234,(short)1234,(short)1234);
        SeriCollectionUtil.putShorts(os, Lists.newArrayList((short)1234,(short)1234,(short)1234,(short)1234));

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        DeseriCollectionUtil.getShorts(is).forEach(System.out::println);
        DeseriCollectionUtil.getShorts(is).forEach(System.out::println);
        DeseriCollectionUtil.getShorts(is).forEach(System.out::println);
        DeseriCollectionUtil.getShorts(is).forEach(System.out::println);
    }

    @Test
    public void testInt() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriCollectionUtil.putInts(os, Integer.MIN_VALUE);
        SeriCollectionUtil.putInts(os, Integer.MAX_VALUE);
        SeriCollectionUtil.putInts(os, Integer.MAX_VALUE);
        SeriCollectionUtil.putInts(os, 12345678,12345678,12345678,12345678);
        SeriCollectionUtil.putInts(os, Lists.newArrayList(12345678,12345678,12345678,12345678));

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        DeseriCollectionUtil.getInts(is).forEach(System.out::println);
        DeseriCollectionUtil.getInts(is).forEach(System.out::println);
        DeseriCollectionUtil.getInts(is).forEach(System.out::println);
        DeseriCollectionUtil.getInts(is).forEach(System.out::println);
        DeseriCollectionUtil.getInts(is).forEach(System.out::println);
    }

    @Test
    public void testLong() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriCollectionUtil.putLongs(os, Long.MIN_VALUE);
        SeriCollectionUtil.putLongs(os, Long.MAX_VALUE);
        SeriCollectionUtil.putLongs(os, 12345678,12345678,12345678,12345678);
        SeriCollectionUtil.putLongs(os, Lists.newArrayList(12345678L,12345678L,12345678L,12345678L));

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        DeseriCollectionUtil.getLongs(is).forEach(System.out::println);
        DeseriCollectionUtil.getLongs(is).forEach(System.out::println);
        DeseriCollectionUtil.getLongs(is).forEach(System.out::println);
        DeseriCollectionUtil.getLongs(is).forEach(System.out::println);
    }

    @Test
    public void testString() throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriCollectionUtil.putStrings(os, "12345678");
        SeriCollectionUtil.putStrings(os, "asdasdas");
        SeriCollectionUtil.putStrings(os, "@$%##@");
        SeriCollectionUtil.putStrings(os, "中国中文");
        SeriCollectionUtil.putStrings(os, "12345678","asdasdas","@$%##@", "中国中文");
        SeriCollectionUtil.putStrings(os, Lists.newArrayList("12345678","asdasdas","@$%##@", "中国中文"));

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        DeseriCollectionUtil.getStrings(is).forEach(System.out::println);
        DeseriCollectionUtil.getStrings(is).forEach(System.out::println);
        DeseriCollectionUtil.getStrings(is).forEach(System.out::println);
        DeseriCollectionUtil.getStrings(is).forEach(System.out::println);
        DeseriCollectionUtil.getStrings(is).forEach(System.out::println);
        DeseriCollectionUtil.getStrings(is).forEach(System.out::println);
    }

}
