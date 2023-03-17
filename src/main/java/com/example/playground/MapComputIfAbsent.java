package com.example.playground;

import java.util.HashMap;
import java.util.Map;

public class MapComputIfAbsent {

    public static void main(String[] args) {
        Map<String, Integer> stringLength = new HashMap<>();
        stringLength.put("John", 5);
        long l1 = stringLength.computeIfAbsent("John", String::length);
        long l2 = stringLength.computeIfAbsent("Petr", String::length);
        System.out.println(l1);
        System.out.println(l2);
    }

}
