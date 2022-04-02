package com.vicking.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

public class SeriUtil {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        putFloat(os, 123.456f);
        putDouble(os, 12355.45677);
        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        System.out.println(DeseriUtil.getFloat(is));
        System.out.println(DeseriUtil.getDouble(is));
//        ByteBuffer buffer = null;
//        buffer.getFloat();
    }

    public static void putDouble(OutputStream os, double x) throws IOException {
        long v = Double.doubleToRawLongBits(x);
        os.write((byte) (v >> 56));
        os.write((byte) (v >> 48));
        os.write((byte) (v >> 40));
        os.write((byte) (v >> 32));
        os.write((byte) (v >> 24));
        os.write((byte) (v >> 16));
        os.write((byte) (v >> 8));
        os.write((byte) v);
    }

    public static void putFloat(OutputStream os, float x) throws IOException {
        int v = Float.floatToRawIntBits(x);
        os.write((byte) (v >> 24));
        os.write((byte) (v >> 16));
        os.write((byte) (v >> 8));
        os.write((byte) v);
    }

    public static void put(OutputStream os, byte x) throws IOException {
        os.write(x);
    }

    public static void putShort(OutputStream os, short x) throws IOException {
        os.write((byte) (x >> 8));
        os.write((byte) x);
    }

    public static void putShort(OutputStream os, int x) throws IOException {
        os.write((byte) (x >> 8));
        os.write((byte) x);
    }

    public static void putInt(OutputStream os, int x) throws IOException {
        os.write((byte) (x >> 24));
        os.write((byte) (x >> 16));
        os.write((byte) (x >> 8));
        os.write((byte) x);
    }

    public static void putLong(OutputStream os, long x) throws IOException {
        os.write((byte) (x >> 56));
        os.write((byte) (x >> 48));
        os.write((byte) (x >> 40));
        os.write((byte) (x >> 32));
        os.write((byte) (x >> 24));
        os.write((byte) (x >> 16));
        os.write((byte) (x >> 8));
        os.write((byte) x);
    }

    public static void putString(OutputStream os, String s) throws IOException {
        if (s == null || s.equalsIgnoreCase("")) {
            putShort(os, (short) 0);
        } else {
            byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
            putShort(os, (short)bytes.length);
            //buffer.putInt(bytes.length);
            os.write(bytes);
        }
    }

    public static void putShortCol(OutputStream os, Collection<Short> collection) throws IOException {
        if (collection == null || collection.isEmpty()) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.size());
            for (Short o : collection) {
                putShort(os, o);
            }
        }
    }

    public static void putIntCol(OutputStream os, Collection<Integer> collection) throws IOException {
        if (collection == null || collection.isEmpty()) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.size());
            for (Integer o : collection) {
                putInt(os, o);
            }
        }
    }

    public static void putLongCol(OutputStream os, Collection<Long> collection) throws IOException {
        if (collection == null || collection.isEmpty()) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.size());
            for (Long o : collection) {
                putLong(os, o);
            }
        }
    }

    public static void putStringCol(OutputStream os, Collection<String> collection) throws IOException {
        if (collection == null || collection.isEmpty()) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.size());
            for (String o : collection) {
                putString(os, o);
            }
        }
    }

}
