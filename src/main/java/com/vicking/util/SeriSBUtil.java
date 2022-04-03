package com.vicking.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class SeriSBUtil {

    public static String putDate(String value) throws IOException {
        return String.format("SeriUtil.putDate(os, %s);", value);
    }


    public static String putDouble(String value) throws IOException {
        return String.format("SeriUtil.putDouble(os, %s);", value);
    }

    public static String putFloat(String value) throws IOException {
        return String.format("SeriUtil.putFloat(os, %s);", value);
    }

    public static String put(String value) throws IOException {
        return String.format("SeriUtil.put(os, %s);", value);
    }

    public static String putShort(String value) throws IOException {
        return String.format("SeriUtil.putShort(os, %s);", value);
    }

    public static String putInt(String value) throws IOException {
        return String.format("SeriUtil.putInt(os, %s);", value);
    }

    public static String putLong(String value) throws IOException {
        return String.format("SeriUtil.putLong(os, %s);", value);
    }

    public static String putString(String value) throws IOException {
        return String.format("SeriUtil.putString(os, %s);", value);
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
