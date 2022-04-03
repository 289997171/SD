package com.vicking.util.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.util.*;

@ToString
@Getter @Setter
public class User {
//    private final int msgId = 1;
//
//    private int id;
//
//    private String name;
//
//    private List<String> list1 = new ArrayList<>();
//    private Set<Integer> list2 = new HashSet<>();
//    private List<Short> list3 = new ArrayList<>();
//    private Set<Long> list4 = new HashSet<>();
//
//
//    private Player player;
//
//    private Set<Player> players = new HashSet<>();
//
//    private byte b = 110;
//    private short s = 123;
//    private float f = 123.456f;
//    private double d = 1232456.182377897;
//    private Date date = new Date();
//
//    private Map<Integer, Integer> map1 = new HashMap<>();
//    private Map<Integer, String > map2 = new HashMap<>();
//    private Map<Integer, Short  > map3 = new HashMap<>();
//    private Map<Integer, Byte   > map4 = new HashMap<>();
//    private Map<Integer, Float  > map5 = new HashMap<>();
//    private Map<Integer, Double > map6 = new HashMap<>();
//    private Map<Integer, Date   > map7 = new HashMap<>();
//
//
//    private Map<Integer, Integer> map11 = new HashMap<>();
//    private Map<String , String > map12 = new HashMap<>();
//    private Map<Short  , Short  > map13 = new HashMap<>();
//    private Map<Byte   , Byte   > map14 = new HashMap<>();
//    private Map<Float  , Float  > map15 = new HashMap<>();
//    private Map<Double , Double > map16 = new HashMap<>();
//    private Map<Date   , Date   > map17 = new HashMap<>();

    private Map<String, Integer> map20 = new HashMap<>();

//    private Map<String, Map<Integer, String>> map20 = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Date date = new Date();
        User o = new User();
//
//        o.setId(1001);
//        o.setName("12345");
//
//        o.getList1().add("l1");
//        o.getList1().add("l2");
//        o.getList1().add("l3");
//        o.getList1().add("l4");
//
//        o.getList2().add(1);
//        o.getList2().add(2);
//        o.getList2().add(3);
//        o.getList2().add(4);
//
//        Player player = new Player();
//        player.setId(110);
//        player.setName("P110");
//        o.setPlayer(player);
//
//        for(int i =0; i < 3; i++){
//            Player item = new Player();
//            item.setId(111 + i);
//            item.setName("P" + item.getId());
//            o.getPlayers().add(item);
//        }
//
//
//        o.getMap1().put(1, 1            );
//        o.getMap2().put(2, "s1"         );
//        o.getMap3().put(3, (short)12    );
//        o.getMap4().put(4, (byte)12     );
//        o.getMap5().put(5, 123.456f     );
//        o.getMap6().put(6, 123.456      );
//        o.getMap7().put(6, date   );
//
//        o.getMap11().put(1         , 1         );
//        o.getMap12().put("s1"      , "s1"      );
//        o.getMap13().put((short)12 , (short)12 );
//        o.getMap14().put((byte)12  , (byte)12  );
//        o.getMap15().put(123.456f  , 123.456f  );
//        o.getMap16().put(123.456   , 123.456   );
//        o.getMap17().put(date   , date   );

//        ByteArrayOutputStream os = new ByteArrayOutputStream(1024);
//        UserWriter.write(os, o);
//        System.out.println(os.size());
//
//        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
//        User read = UserReader.read(is);
//        System.out.println(read);
//        System.out.println(o);
//
//        System.out.println(o.toString().equalsIgnoreCase(read.toString()));
    }


//    public static void main(String[] args) throws IOException {
//        User o = new User();
//        o.setId(1001);
//        o.setName("12345");
//
//        o.getList1().add("l1");
//        o.getList1().add("l2");
//        o.getList1().add("l3");
//        o.getList1().add("l4");
//
//        o.getList2().add(1);
//        o.getList2().add(2);
//        o.getList2().add(3);
//        o.getList2().add(4);
//
//        Player player = new Player();
//        player.setId(110);
//        player.setName("P110");
//        o.setPlayer(player);
//
//        for(int i =0; i < 3; i++){
//            Player item = new Player();
//            item.setId(111 + i);
//            item.setName("P" + item.getId());
//            o.getPlayers().add(item);
//        }
//
//        ByteArrayOutputStream os = new ByteArrayOutputStream(1024);
//        UserWriter.write(os, o);
//        System.out.println(os.size());
//
//        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
//        User read = UserReader.read(is);
//        System.out.println(read);
//
////        ByteArrayOutputStream os = new ByteArrayOutputStream(1024);
////        SeriUtil.putInt(os, o.getId());
////        SeriUtil.putString(os, o.getName());
////        SeriUtil.putStringCol(os, o.getList1());
////        SeriUtil.putIntCol(os, o.getList2());
////
////        System.out.println("-----------");
////
////        User user1 = new User();
////        ByteInputStream is = new ByteInputStream(os.toByteArray(), 0, os.size());
////        System.out.println(DeseriUtil.getInt(is));
////        System.out.println(DeseriUtil.getString(is));
////
////        for (String s : DeseriUtil.getStringCol(is)) {
////            System.out.println(s);
////        }
////
////        for (Integer s : DeseriUtil.getIntCol(is)) {
////            System.out.println(s);
////        }
//
//
//    }


}
