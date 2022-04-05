package com.vicking.util;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class SeriUtil2 {

    public static void putBoolean(OutputStream os, boolean x) throws IOException {
        if (x) {
            os.write((byte)1);
        } else {
            os.write((byte)0);
        }
    }

    public static void putDate(OutputStream os, Date x) throws IOException {
        putVarInt(os, x.getTime());
    }

    public static void putDouble(OutputStream os, double x) throws IOException {
        long temp = Double.doubleToLongBits(x);
        putVarInt(os, temp);
    }

    public static void putByte(OutputStream os, byte x) throws IOException {
        os.write(x);
    }

    public static void putFloat(OutputStream os, float x) throws IOException {
        int temp = Float.floatToIntBits(x);
        putVarInt(os, temp);
    }

    public static void putVarInt(OutputStream os, long n) throws IOException {
        //ZigZag编码
        n = (n << 1) ^ (n >> 63);

        while (true) {
            if ((n & ~0x7F) == 0) {
                os.write((byte) (n & 0x7F));
                return;
            } else {
                os.write((byte) (n & 0x7F | 0x80));
                n >>>= 7;
            }
        }
    }

    public static void putShort(OutputStream os, short x) throws IOException {
        putVarInt(os, x);
    }

    public static void putShort(OutputStream os, int x) throws IOException {
        putVarInt(os, x);
    }

    public static void putInt(OutputStream os, int x) throws IOException {
        putVarInt(os, x);
    }

    public static void putLong(OutputStream os, long x) throws IOException {
        putVarInt(os, x);
    }

    public static void putString(OutputStream os, String s) throws IOException {
        if (s == null || s.equalsIgnoreCase("")) {
            putVarInt(os, 0);
        } else {
            byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
            putVarInt(os, bytes.length);
            os.write(bytes);
        }
    }

}
