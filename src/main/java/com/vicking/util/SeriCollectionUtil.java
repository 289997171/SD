package com.vicking.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Date;

import static com.vicking.util.SeriUtil.*;

public class SeriCollectionUtil {

    public static void putBooleans(OutputStream os, boolean... collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.length);
            for (boolean o : collection) {
                putBoolean(os, o);
            }
        }
    }

    public static void putBooleans(OutputStream os, Collection<Boolean> collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.size());
            for (boolean o : collection) {
                putBoolean(os, o);
            }
        }
    }

    public static void putDates(OutputStream os, Date... collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.length);
            for (Date o : collection) {
                putDate(os, o);
            }
        }
    }

    public static void putDates(OutputStream os, Collection<Date> collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.size());
            for (Date o : collection) {
                putDate(os, o);
            }
        }
    }

    public static void putDoubles(OutputStream os, double... collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.length);
            for (double o : collection) {
                putDouble(os, o);
            }
        }
    }

    public static void putDoubles(OutputStream os, Collection<Double> collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.size());
            for (double o : collection) {
                putDouble(os, o);
            }
        }
    }

    public static void putFloats(OutputStream os, float... collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.length);
            for (float o : collection) {
                putFloat(os, o);
            }
        }
    }

    public static void putFloats(OutputStream os, Collection<Float> collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.size());
            for (Float o : collection) {
                putFloat(os, o);
            }
        }
    }

    public static void putBytes(OutputStream os, byte... collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.length);
            for (byte o : collection) {
                putByte(os, o);
            }
        }
    }

    public static void putBytes(OutputStream os, Collection<Byte> collection) throws IOException {
        if (collection == null) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)collection.size());
            for (byte o : collection) {
                putByte(os, o);
            }
        }
    }

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
