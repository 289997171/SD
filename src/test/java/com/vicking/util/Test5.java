package com.vicking.util;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.HashSet;
import com.vicking.util.Obj4;

import com.vicking.util.tools.SDBuilder;
import org.junit.jupiter.api.Test;

import java.beans.IntrospectionException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class Test5 {

    @Test
    void test1() throws IntrospectionException {
        SDBuilder.build(Obj3.class);
//        SDBuilder.build(Obj4.class);
    }

    @Test
    void test2() throws IOException {
        long begin = System.currentTimeMillis();
        Obj3 o = new Obj3();
        o.setIv(1);
        o.setIv2(2);
        o.setIv3(3);
        o.setIv4(4);
        o.setBs1(Lists.newArrayList(true, false, true, false));
        o.setBs2(Lists.newArrayList(true, false, true, false));
        o.setBs3(Sets.newHashSet(true, false, true, false));
        o.setBs4(Sets.newHashSet(true, false, true, false));
        o.setBs5(new boolean[]{true, false, true, false});
        o.setBs6(new boolean[]{true, false, true, false});
        Obj4 obj4 = new Obj4();
        obj4.setId(123);
        obj4.setName("my name is xxx");
        o.setObj4(obj4);
        o.setObj41(Lists.newArrayList(obj4,obj4,obj4));
        o.setObj42(Lists.newArrayList(obj4,obj4,obj4));
        o.setObj43(Sets.newHashSet(obj4,obj4,obj4));
        o.setObj44(Sets.newHashSet(obj4,obj4,obj4));
        o.setObj45(new Obj4[]{obj4,obj4,obj4});
        o.setObj46(new Obj4[]{obj4,obj4,obj4});
//        o.setMap1(new HashMap<Integer,String>());
//        o.setMap2(new HashMap<Integer,String>>());
//        o.setMap3(new HashMap<Integer,String>>());
//        o.setMap4(new HashMap<Integer,String[]>());
//        o.setMap5(new HashMap<Integer,boolean[]>());
//        o.setMap6(new HashMap<Integer,Integer,Integer,Float>>>());

        HashMap<Integer, Float> map = new HashMap<Integer, Float>();
        map.put(1, 1f);
        map.put(2, 2f);
        map.put(3, 3f);
        map.put(4, 4f);
        map.put(5, 5f);

        HashMap<Integer, HashMap<Integer, Float>> map1 = new HashMap<>();
        map1.put(1, map);
        map1.put(2, map);
        map1.put(3, map);
        map1.put(4, map);

        o.setMap6(new HashMap<>());

        o.getMap6().put(1, map1);
        o.getMap6().put(2, map1);
        o.getMap6().put(3, map1);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Obj3Writer.write(os, o);
        System.out.println(os.size());

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        Obj3 read = Obj3Reader.read(is);
        System.out.println(o);
        System.out.println(read);

        System.out.println("Cost " + (System.currentTimeMillis() - begin));
    }
}
