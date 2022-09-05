package com.example.codewars3.codewars.kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class HungerGames {

    static Map<String, Set<String>> eaterEats = new HashMap<>();
    static Map<String, Set<String>> eatenBy = new HashMap<>();

    static {
        eaterEats.put("antelope", Set.of("grass"));
        eaterEats.put("big-fish", Set.of("little-fish"));
        eaterEats.put("bug", Set.of("leaves"));
        eaterEats.put("bear", Set.of("big-fish", "bug", "chicken", "cow", "leaves", "sheep"));
        eaterEats.put("chicken", Set.of("bug"));
        eaterEats.put("cow", Set.of("grass"));
        eaterEats.put("fox", Set.of("chicken", "sheep"));
        eaterEats.put("giraffe", Set.of("leaves"));
        eaterEats.put("lion", Set.of("antelope", "cow"));
        eaterEats.put("panda", Set.of("leaves"));
        eaterEats.put("sheep", Set.of("grass"));

        eaterEats.keySet().forEach(i -> eaterEats.get(i)
                .forEach(j -> {
                    Set<String> current = new HashSet<>();
                    if (eatenBy.containsKey(j)) {
                        current = eatenBy.get(j);
                        current.add(i);
                        eatenBy.put(j, current);
                    } else {
                        current.add(i);
                        eatenBy.put(j, current);
                    }
                }));
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(whoEatsWho("fox,bug,chicken,grass,sheep")));
        //System.out.println(Arrays.toString(whoEatsWho("bear,big-fish,lion,cow,bug,leaves")));
        System.out.println(Arrays.toString(whoEatsWho("bear,grass,grass,grass,grass,sheep,bug,chicken,little-fish,little-fish,little-fish,little-fish,big-fish,big-fish,big-fish")));
        //System.out.println(Arrays.toString(whoEatsWho("giraffe,leaves,leaves,leaves,bear,bug,leaves,leaves,panda")));
    }

    public static String[] whoEatsWho(final String zoo) {
        List<String> result = new ArrayList<>();
        result.add(Arrays.stream(zoo.split(",")).collect(Collectors.joining(",")));
        List<String> zooList = Arrays.stream(zoo.split(",")).collect(Collectors.toList());

        for (int i = 0; i < zooList.size(); i++) {
            if (zooList.size() == 1) break;
            String current = zooList.get(i);
            String previous = null;
            String next = null;

            // if current is not among eaters, continue
            if (!eaterEats.containsKey(current))
                continue;

            // define previous and next
            if (i > 0)
                previous = zooList.get(i - 1);
            if (i < zooList.size() - 1)
                next = zooList.get(i + 1);

            // look to the right first on i==0
            if (i == 0 && eaterEats.get(current).contains(next)) {
                zooList.remove(i + 1);
                result.add(String.format("%s eats %s", current, next));
                i = -1;
            } else if (i > 0 && eaterEats.get(current).contains(previous)) {
                // eat left, then right
                zooList.remove(i - 1);
                result.add(String.format("%s eats %s", current, previous));
                i = -1;
            } else if (i < zooList.size() - 1 && eaterEats.get(current).contains(next)) {
                // eat right
                zooList.remove(i + 1);
                result.add(String.format("%s eats %s", current, next));
                i = -1;
            }
        }
        result.add(String.join(",", zooList));

        String[] arr = new String[result.size()];
        arr = result.toArray(arr);
        return arr;
    }
}