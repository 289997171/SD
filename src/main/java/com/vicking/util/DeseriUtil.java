package com.vicking.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

public class DeseriUtil {

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

    public static int get(InputStream is) throws IOException {
        return is.read();
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

    public static Collection<Short> getShortCol(InputStream is) throws IOException {
        int len = getShort(is);
        if (len == 0) {
            return null;
        } else {
            ArrayList<Short> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list.add(getShort(is));
            }
            return list;
        }
    }

    public static Collection<Integer> getIntCol(InputStream is) throws IOException {
        int len = getShort(is);
        if (len == 0) {
            return null;
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list.add(getInt(is));
            }
            return list;
        }
    }

    public static Collection<Long> getLongCol(InputStream is) throws IOException {
        int len = getShort(is);
        if (len == 0) {
            return null;
        } else {
            ArrayList<Long> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list.add(getLong(is));
            }
            return list;
        }
    }

    public static Collection<String> getStringCol(InputStream is) throws IOException {
        int len = getShort(is);
        if (len == 0) {
            return null;
        } else {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list.add(getString(is));
            }
            return list;
        }
    }

}
