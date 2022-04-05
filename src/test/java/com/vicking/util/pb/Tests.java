package com.vicking.util.pb;

import com.vicking.util.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

public class Tests {

    @Test
    void test1() throws IOException {
        long value = 123;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        SeriUtil.putDate(os, new Date());
//        SeriUtil.putLong(os, Long.MAX_VALUE);
//        SeriUtil.putLong(os, Long.MIN_VALUE);
//        SeriUtil.putInt(os, Integer.MAX_VALUE);
//        SeriUtil.putInt(os, Integer.MIN_VALUE);
//        SeriUtil.putShort(os, Short.MAX_VALUE);
//        SeriUtil.putShort(os, Short.MIN_VALUE);
//        SeriUtil.putFloat(os, Float.MAX_VALUE);
//        SeriUtil.putFloat(os, Float.MIN_VALUE);
//        SeriUtil.putDouble(os, Double.MAX_VALUE);
//        SeriUtil.putDouble(os, Double.MIN_VALUE);
        System.out.println(os.size());

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        System.out.println(DeseriUtil.getDate(is));
//        System.out.println(DeseriUtil.getLong(is));
//        System.out.println(DeseriUtil.getLong(is));
//        System.out.println(DeseriUtil.getInt(is));
//        System.out.println(DeseriUtil.getInt(is));
//        System.out.println(DeseriUtil.getShort(is));
//        System.out.println(DeseriUtil.getShort(is));
//        System.out.println(DeseriUtil.getFloat(is));
//        System.out.println(DeseriUtil.getFloat(is));
//        System.out.println(DeseriUtil.getDouble(is));
//        System.out.println(DeseriUtil.getDouble(is));
    }

//    @Test
//    void test11() throws IOException {
//        ByteArrayOutputStream os = new ByteArrayOutputStream();
//        SeriUtil2.putLong(os, Long.MAX_VALUE);
//        SeriUtil2.putLong(os, Long.MIN_VALUE);
//        SeriUtil2.putInt(os, Integer.MAX_VALUE);
//        SeriUtil2.putInt(os, Integer.MIN_VALUE);
//        SeriUtil2.putShort(os, Short.MAX_VALUE);
//        SeriUtil2.putShort(os, Short.MIN_VALUE);
//        SeriUtil2.putFloat(os, Float.MAX_VALUE);
//        SeriUtil2.putFloat(os, Float.MIN_VALUE);
//        SeriUtil2.putDouble(os, Double.MAX_VALUE);
//        SeriUtil2.putDouble(os, Double.MIN_VALUE);
//        System.out.println(os.size());
//
//        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
//        System.out.println(DeseriUtil2.getLong(is));
//        System.out.println(DeseriUtil2.getLong(is));
//        System.out.println(DeseriUtil2.getInt(is));
//        System.out.println(DeseriUtil2.getInt(is));
//        System.out.println(DeseriUtil2.getShort(is));
//        System.out.println(DeseriUtil2.getShort(is));
//        System.out.println(DeseriUtil2.getFloat(is));
//        System.out.println(DeseriUtil2.getFloat(is));
//        System.out.println(DeseriUtil2.getDouble(is));
//        System.out.println(DeseriUtil2.getDouble(is));
//    }

}
