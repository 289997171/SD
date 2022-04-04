//package com.vicking.util;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
//
//import static com.vicking.util.DeseriUtil.*;
//
//public class DeseriCollectionUtil {
//
//    public static void getBooleans(InputStream is, boolean[] arr, int len) throws IOException {
//        for (int i = 0; i < len; i++) {
//            arr[i] = getBoolean(is);
//        }
//    }
//
//    public static void getBooleans(InputStream is, Set<Boolean> set) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                set.add(getBoolean(is));
//            }
//        }
//    }
//
//    public static void getBooleans(InputStream is, List<Boolean> list) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                list.add(getBoolean(is));
//            }
//        }
//    }
//
//
//    public static ArrayList<Boolean> getBooleans(InputStream is) throws IOException {
//        int len = getShort(is);
//        if (len == 0) {
//            return null;
//        } else {
//            ArrayList<Boolean> list = new ArrayList<>();
//            for (int i = 0; i < len; i++) {
//                list.add(getBoolean(is));
//            }
//            return list;
//        }
//    }
//
//
//    public static void getDates(InputStream is, Date[] arr, int len) throws IOException {
//        for (int i = 0; i < len; i++) {
//            arr[i] = getDate(is);
//        }
//    }
//
//    public static void getDates(InputStream is, Set<Date> set) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                set.add(getDate(is));
//            }
//        }
//    }
//
//    public static void getDates(InputStream is, List<Date> list) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                list.add(getDate(is));
//            }
//        }
//    }
//
//    public static ArrayList<Date> getDates(InputStream is) throws IOException {
//        int len = getShort(is);
//        if (len == 0) {
//            return null;
//        } else {
//            ArrayList<Date> list = new ArrayList<>();
//            for (int i = 0; i < len; i++) {
//                list.add(getDate(is));
//            }
//            return list;
//        }
//    }
//
//    public static void getDoubles(InputStream is, double[] arr, int len) throws IOException {
//        for (int i = 0; i < len; i++) {
//            arr[i] = getDouble(is);
//        }
//    }
//
//    public static void getDoubles(InputStream is, Set<Double> set) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                set.add(getDouble(is));
//            }
//        }
//    }
//
//    public static void getDoubles(InputStream is, List<Double> list) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                list.add(getDouble(is));
//            }
//        }
//    }
//
//    public static ArrayList<Double> getDoubles(InputStream is) throws IOException {
//        int len = getShort(is);
//        if (len == 0) {
//            return null;
//        } else {
//            ArrayList<Double> list = new ArrayList<>();
//            for (int i = 0; i < len; i++) {
//                list.add(getDouble(is));
//            }
//            return list;
//        }
//    }
//
//    public static void getFloats(InputStream is, float[] arr, int len) throws IOException {
//        for (int i = 0; i < len; i++) {
//            arr[i] = getFloat(is);
//        }
//    }
//
//    public static void getFloats(InputStream is, Set<Float> set) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                set.add(getFloat(is));
//            }
//        }
//    }
//
//    public static void getFloats(InputStream is, List<Float> list) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                list.add(getFloat(is));
//            }
//        }
//    }
//
//    public static ArrayList<Float> getFloats(InputStream is) throws IOException {
//        int len = getShort(is);
//        if (len == 0) {
//            return null;
//        } else {
//            ArrayList<Float> list = new ArrayList<>();
//            for (int i = 0; i < len; i++) {
//                list.add(getFloat(is));
//            }
//            return list;
//        }
//    }
//
//    public static void getBytes(InputStream is, byte[] arr, int len) throws IOException {
//        //for (int i = 0; i < len; i++) {
//        //    arr[i] = getByte(is);
//        //}
//        is.read(arr);
//    }
//
//    public static void getBytes(InputStream is, Set<Byte> set) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                set.add(getByte(is));
//            }
//        }
//    }
//
//    public static void getBytes(InputStream is, List<Byte> list) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                list.add(getByte(is));
//            }
//        }
//    }
//
//    public static ArrayList<Byte> getBytes(InputStream is) throws IOException {
//        int len = getShort(is);
//        if (len == 0) {
//            return null;
//        } else {
//            ArrayList<Byte> list = new ArrayList<>();
//            for (int i = 0; i < len; i++) {
//                list.add(getByte(is));
//            }
//            return list;
//        }
//    }
//
//    public static void getShorts(InputStream is, short[] arr, int len) throws IOException {
//        for (int i = 0; i < len; i++) {
//            arr[i] = getShort(is);
//        }
//    }
//
//    public static void getShorts(InputStream is, Set<Short> set) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                set.add(getShort(is));
//            }
//        }
//    }
//
//    public static void getShorts(InputStream is, List<Short> list) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                list.add(getShort(is));
//            }
//        }
//    }
//
//    public static ArrayList<Short> getShorts(InputStream is) throws IOException {
//        int len = getShort(is);
//        if (len == 0) {
//            return null;
//        } else {
//            ArrayList<Short> list = new ArrayList<>();
//            for (int i = 0; i < len; i++) {
//                list.add(getShort(is));
//            }
//            return list;
//        }
//    }
//
//    public static void getInts(InputStream is, int[] arr, int len) throws IOException {
//        for (int i = 0; i < len; i++) {
//            arr[i] = getInt(is);
//        }
//    }
//
//    public static void getInts(InputStream is, Set<Integer> set) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                set.add(getInt(is));
//            }
//        }
//    }
//
//    public static void getInts(InputStream is, List<Integer> list) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                list.add(getInt(is));
//            }
//        }
//    }
//
//    public static ArrayList<Integer> getInts(InputStream is) throws IOException {
//        int len = getShort(is);
//        if (len == 0) {
//            return null;
//        } else {
//            ArrayList<Integer> list = new ArrayList<>();
//            for (int i = 0; i < len; i++) {
//                list.add(getInt(is));
//            }
//            return list;
//        }
//    }
//
//    public static void getLongs(InputStream is, long[] arr, int len) throws IOException {
//        for (int i = 0; i < len; i++) {
//            arr[i] = getLong(is);
//        }
//    }
//
//    public static void getLongs(InputStream is, Set<Long> set) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                set.add(getLong(is));
//            }
//        }
//    }
//
//    public static void getLongs(InputStream is, List<Long> list) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                list.add(getLong(is));
//            }
//        }
//    }
//
//    public static ArrayList<Long> getLongs(InputStream is) throws IOException {
//        int len = getShort(is);
//        if (len == 0) {
//            return null;
//        } else {
//            ArrayList<Long> list = new ArrayList<>();
//            for (int i = 0; i < len; i++) {
//                list.add(getLong(is));
//            }
//            return list;
//        }
//    }
//
//    public static void getStrings(InputStream is, String[] arr, int len) throws IOException {
//        for (int i = 0; i < len; i++) {
//            arr[i] = getString(is);
//        }
//    }
//
//    public static void getStrings(InputStream is, Set<String> set) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                set.add(getString(is));
//            }
//        }
//    }
//
//    public static void getStrings(InputStream is, List<String> list) throws IOException {
//        int len = getShort(is);
//        if (len != 0) {
//            for (int i = 0; i < len; i++) {
//                list.add(getString(is));
//            }
//        }
//    }
//
//    public static ArrayList<String> getStrings(InputStream is) throws IOException {
//        int len = getShort(is);
//        if (len == 0) {
//            return null;
//        } else {
//            ArrayList<String> list = new ArrayList<>();
//            for (int i = 0; i < len; i++) {
//                list.add(getString(is));
//            }
//            return list;
//        }
//    }
//
//}
