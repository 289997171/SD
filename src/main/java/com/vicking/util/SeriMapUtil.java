package com.vicking.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import static com.vicking.util.SeriUtil.*;

public class SeriMapUtil {

    public static void putMapSS(OutputStream os, Map<String, String> map) throws IOException {
        if (map == null || map.isEmpty()) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                putString(os, entry.getKey());
                putString(os, entry.getKey());
            }
        }
    }

    public static void putMap(OutputStream os, Map<String, Integer> map) throws IOException {
        if (map == null || map.isEmpty()) {
            putShort(os, (short)0);
        } else {
            putShort(os, (short)map.size());
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                putString(os, entry.getKey());
                putString(os, entry.getKey());
            }
        }
    }
}
