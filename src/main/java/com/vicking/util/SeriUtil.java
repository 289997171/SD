package com.vicking.util;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class SeriUtil {

    public static void putBoolean(OutputStream os, boolean x) throws IOException {
        if (x) {
            os.write((byte)1);
        } else {
            os.write((byte)0);
        }
    }

    public static void putDate(OutputStream os, Date x) throws IOException {
        long v = x.getTime();
        //os.write((byte) (v >> 56));
        //os.write((byte) (v >> 48));
        os.write((byte) (v >> 40));
        os.write((byte) (v >> 32));
        os.write((byte) (v >> 24));
        os.write((byte) (v >> 16));
        os.write((byte) (v >> 8));
        os.write((byte) v);
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

    public static void putByte(OutputStream os, byte x) throws IOException {
        os.write(x);
    }

    public static void putFloat(OutputStream os, float x) throws IOException {
        int v = Float.floatToRawIntBits(x);
        os.write((byte) (v >> 24));
        os.write((byte) (v >> 16));
        os.write((byte) (v >> 8));
        os.write((byte) v);
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
            os.write(bytes);
        }
    }

}
