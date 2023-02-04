package ru.job4j.map;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.*;

public class MostUsedCharacter {
    public static char getMaxCount(String str) {
        char rsl = ' ';
        int max = 0;
        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
        for (char sym : str.replaceAll("\\s", "").toLowerCase().toCharArray()) {
            if (!map.containsKey(sym)) {
                map.putIfAbsent(sym, 1);
            } else {
                map.computeIfPresent(sym, (k, v) -> v + 1);
            }


        }


        return rsl;
    }
}
