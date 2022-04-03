package com.vicking.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import static com.vicking.util.DeseriUtil.*;

public class DeseriCollectionUtil {

    public static ArrayList<Boolean> getBooleans(InputStream is) throws IOException {
        int len = getShort(is);
        if (len == 0) {
            return null;
        } else {
            ArrayList<Boolean> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list.add(getBoolean(is));
            }
            return list;
        }
    }

    public static ArrayList<Date> getDates(InputStream is) throws IOException {
        int len = getShort(is);
        if (len == 0) {
            return null;
        } else {
            ArrayList<Date> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list.add(getDate(is));
            }
            return list;
        }
    }

    public static ArrayList<Double> getDoubles(InputStream is) throws IOException {
        int len = getShort(is);
        if (len == 0) {
            return null;
        } else {
            ArrayList<Double> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list.add(getDouble(is));
            }
            return list;
        }
    }

    public static ArrayList<Float> getFloats(InputStream is) throws IOException {
        int len = getShort(is);
        if (len == 0) {
            return null;
        } else {
            ArrayList<Float> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list.add(getFloat(is));
            }
            return list;
        }
    }

    public static ArrayList<Byte> getBytes(InputStream is) throws IOException {
        int len = getShort(is);
        if (len == 0) {
            return null;
        } else {
            ArrayList<Byte> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list.add(getByte(is));
            }
            return list;
        }
    }


    public static ArrayList<Short> getShorts(InputStream is) throws IOException {
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

    public static ArrayList<Integer> getInts(InputStream is) throws IOException {
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

    public static ArrayList<Long> getLongs(InputStream is) throws IOException {
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

    public static ArrayList<String> getStrings(InputStream is) throws IOException {
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
