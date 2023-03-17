package com.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ComputeIfAbsent {

    public static void main(String[] args) {
        Map<String, Set<String>> hashMap = new HashMap<>();
        var set = new HashSet<String>();
        set.add("AA");
        set.add("BB");
        hashMap.put("A", set);
        hashMap.put("B", set);
        hashMap.put("main.java.C", set);
        hashMap.put("main.java.D", set);
        System.out.println("Before compute : " + hashMap);

        hashMap.computeIfAbsent("M", k -> set);
        System.out.println("After  compute : " + hashMap);
        System.out.println("------------------");

        hashMap = new HashMap<>();
        hashMap.put("A", set);
        hashMap.put("B", set);
        hashMap.put("main.java.C", set);
        hashMap.put("main.java.D", set);
        System.out.println("Before compute : " + hashMap);

        hashMap.computeIfAbsent("main.java.C", k -> set);
        System.out.println("After  compute : " + hashMap);
        System.out.println("------------------");

        hashMap = new HashMap<>();
        hashMap.put("A", set);
        hashMap.put("B", set);
        hashMap.put("main.java.C", set);
        hashMap.put("main.java.D", set);

        var strings = hashMap.computeIfAbsent("M", k -> set);
        hashMap.computeIfAbsent("Q", k -> new HashSet<>()).addAll(Set.of("BB", "CC"));

        System.out.println("Return Value : " + set);
        System.out.println(hashMap);
        System.out.println("------------------");

        /*hashMap = new HashMap<>();
        hashMap.put("A",1);
        hashMap.put("B",2);
        hashMap.put("main.java.C",3);
        hashMap.put("main.java.D",4);
        System.out.println("Before compute : " + hashMap);

        hashMap.computeIfAbsent("M", null);
        System.out.println("After  compute : " + hashMap);
        System.out.println("------------------");*/

        var intMap = new HashMap<Integer, Integer>();
        intMap.put(1, 1);
        Integer val = intMap.computeIfAbsent(10, k -> k + 5);
        System.out.println(intMap);
        System.out.println(val);

        System.out.println(intMap.computeIfAbsent(9, k -> k * 2));
        System.out.println(intMap);

        String h1 = "65353a";
        int highestPossiblePort = 65353;
        int lowestPossiblePort = 0;
        if (!h1.matches("\\d+") || //
                Integer.parseInt(h1) < lowestPossiblePort || //
                Integer.parseInt(h1) > highestPossiblePort)
            throw new IllegalArgumentException("messageQueue.active is true, but missing correct messageQueue.consumer.rabbit.port.mqttwss");
        System.out.println("huraa");

    }

}
