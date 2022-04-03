package com.vicking.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class DeseriUtil {

    public static boolean getBoolean(InputStream is) throws IOException {
        return is.read() == (byte)1;
    }

    public static Date getDate(InputStream is) throws IOException {
        long v = (
                //(((long) is.read()) << 56) |
                //(((long) is.read() & 0xff) << 48) |
                (((long) is.read() & 0xff) << 40) |
                (((long) is.read() & 0xff) << 32) |
                (((long) is.read() & 0xff) << 24) |
                (((long) is.read() & 0xff) << 16) |
                (((long) is.read() & 0xff) << 8) |
                (((long) is.read() & 0xff)));
        return new Date(v);
    }

    public static double getDouble(InputStream is) throws IOException {
        long v =((((long) is.read()) << 56) |
                (((long) is.read() & 0xff) << 48) |
                (((long) is.read() & 0xff) << 40) |
                (((long) is.read() & 0xff) << 32) |
                (((long) is.read() & 0xff) << 24) |
                (((long) is.read() & 0xff) << 16) |
                (((long) is.read() & 0xff) << 8) |
                (((long) is.read() & 0xff)));
        return Double.longBitsToDouble(v);
    }

    public static float getFloat(InputStream is) throws IOException {
        int v =(((is.read()) << 24) |
                ((is.read() & 0xff) << 16) |
                ((is.read() & 0xff) << 8) |
                ((is.read() & 0xff)));
        return Float.intBitsToFloat(v);
    }

    public static byte get(InputStream is) throws IOException {
        return (byte)is.read();
    }

    public static short getShort(InputStream is) throws IOException {
        return (short) (((is.read() & 0xff) << 8) |
                ((is.read() & 0xff)));
    }

    public static int getInt(InputStream is) throws IOException {
        return (((is.read()) << 24) |
                ((is.read() & 0xff) << 16) |
                ((is.read() & 0xff) << 8) |
                ((is.read() & 0xff)));
    }


    public static long getLong(InputStream is) throws IOException {
        return ((((long) is.read()) << 56) |
                (((long) is.read() & 0xff) << 48) |
                (((long) is.read() & 0xff) << 40) |
                (((long) is.read() & 0xff) << 32) |
                (((long) is.read() & 0xff) << 24) |
                (((long) is.read() & 0xff) << 16) |
                (((long) is.read() & 0xff) << 8) |
                (((long) is.read() & 0xff)));
    }

    public static String getString(InputStream is) throws IOException {
        int len = getShort(is);
        if (len == 0) {
            return "";
        } else {
            byte[] bytes = new byte[len];
            is.read(bytes);
            return new String(bytes, StandardCharsets.UTF_8);
        }
    }


}
