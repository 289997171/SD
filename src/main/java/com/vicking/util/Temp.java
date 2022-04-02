package com.vicking.util;

import java.util.HashMap;
import java.util.Map;

public class Temp {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<Float, Integer> map2 = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            entry.getKey();
            entry.getValue();
        }
    }
}
