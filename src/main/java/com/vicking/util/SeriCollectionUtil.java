package com.vicking.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

import static com.vicking.util.SeriUtil.*;

public class SeriCollectionUtil {

    public static void putShorts(OutputStream os, short... collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.length);
            for (short o : collection) {
                putShort(os, o);
            }
        }
    }

    public static void putShorts(OutputStream os, Collection<Short> collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.size());
            for (short o : collection) {
                putShort(os, o);
            }
        }
    }

    public static void putInts(OutputStream os, int... collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.length);
            for (int o : collection) {
                putInt(os, o);
            }
        }
    }

    public static void putInts(OutputStream os, Collection<Integer> collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.size());
            for (int o : collection) {
                putInt(os, o);
            }
        }
    }

    public static void putLongs(OutputStream os, long... collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.length);
            for (long o : collection) {
                putLong(os, o);
            }
        }
    }

    public static void putLongs(OutputStream os, Collection<Long> collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.size());
            for (long o : collection) {
                putLong(os, o);
            }
        }
    }

    public static void putStrings(OutputStream os, String... collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.length);
            for (String o : collection) {
                putString(os, o);
            }
        }
    }

    public static void putStrings(OutputStream os, Collection<String> collection) throws IOException {
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
