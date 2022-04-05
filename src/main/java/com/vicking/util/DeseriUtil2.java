package com.vicking.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class DeseriUtil2 {

    public static boolean getBoolean(InputStream is) throws IOException {
        return is.read() == (byte)1;
    }

    public static Date getDate(InputStream is) throws IOException {
        long v = getVarInt(is, 10);
        return new Date(v);
    }

    public static double getDouble(InputStream is) throws IOException {
        long x = getVarInt(is, 10);
        return Double.longBitsToDouble(x);
    }

    public static float getFloat(InputStream is) throws IOException {
        int x = (int) getVarInt(is, 5);
        return Float.intBitsToFloat(x);
    }

    public static byte getByte(InputStream is) throws IOException {
        return (byte)is.read();
    }

    public static short getShort(InputStream is) throws IOException {
        return (short) getVarInt(is, 3);
    }

    /**
     * 读取变长整数
     *
     * @param maxBytes 最多读几个字节，short:3，int:5，long:10
     */
    public static long getVarInt(InputStream is, int maxBytes) throws IOException {
        long temp = 0;
        int shift = 0;
        int count = 0;

        while (count < maxBytes) {
            final int b = is.read();
            temp |= (b & 0x7FL) << shift;
            shift += 7;
            count++;

            if ((b & 0x80) == 0) { // 128
                //ZigZag解码
                return (temp >>> 1) ^ -(temp & 1);
            }
        }
        throw new RuntimeException("读数据出错");
    }

    public static int getInt(InputStream is) throws IOException {
        return (int) getVarInt(is, 5);
    }


    public static long getLong(InputStream is) throws IOException {
        return  getVarInt(is, 10);
    }

    public static String getString(InputStream is) throws IOException {
        int len = getInt(is);
        if (len == 0) {
            return "";
        } else {
            byte[] bytes = new byte[len];
            is.read(bytes);
            return new String(bytes, StandardCharsets.UTF_8);
        }
    }


}
