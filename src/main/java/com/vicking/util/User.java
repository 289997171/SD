package com.vicking.util;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import lombok.Getter;
import lombok.Setter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

@Getter @Setter
public class User {
    private final int msgId = 1;

    private int id;

    private String name;

    private List<String> list1 = new ArrayList<>();
    private Set<Integer> list2 = new HashSet<>();


    private Player player;

    private Set<Player> players = new HashSet<>();


    public static void main(String[] args) throws IOException {
        User o = new User();
        o.setId(1001);
        o.setName("12345");

        o.getList1().add("l1");
        o.getList1().add("l2");
        o.getList1().add("l3");
        o.getList1().add("l4");

        o.getList2().add(1);
        o.getList2().add(2);
        o.getList2().add(3);
        o.getList2().add(4);

        ByteArrayOutputStream os = new ByteArrayOutputStream(1024);
        UserWriter.write(os, o);
        System.out.println(os.size());

        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        User read = UserReader.read(is);
        System.out.println(read);

//        ByteArrayOutputStream os = new ByteArrayOutputStream(1024);
//        SeriUtil.putInt(os, o.getId());
//        SeriUtil.putString(os, o.getName());
//        SeriUtil.putStringCol(os, o.getList1());
//        SeriUtil.putIntCol(os, o.getList2());
//
//        System.out.println("-----------");
//
//        User user1 = new User();
//        ByteInputStream is = new ByteInputStream(os.toByteArray(), 0, os.size());
//        System.out.println(DeseriUtil.getInt(is));
//        System.out.println(DeseriUtil.getString(is));
//
//        for (String s : DeseriUtil.getStringCol(is)) {
//            System.out.println(s);
//        }
//
//        for (Integer s : DeseriUtil.getIntCol(is)) {
//            System.out.println(s);
//        }


    }


}
