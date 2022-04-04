package com.vicking.util;

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
        Obj3 o = new Obj3();
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
    }
}
