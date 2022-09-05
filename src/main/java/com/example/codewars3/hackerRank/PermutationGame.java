package com.example.codewars3.hackerRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PermutationGame {

    private static HashMap<List<Integer>, Boolean> cache = new HashMap<>();

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        //System.out.println(isWinning(list));


        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(3);
        list1.add(2);
        list1.add(1);
        list1.add(4);
        System.out.println(isWinning(list1));

    }

    private static boolean isSorted(List<Integer> list) {
        int l = list.size();
        for (int i = 0; i < l - 1; i++) {
            if (list.get(i) > list.get(i + 1))
                return false;
        }
        return true;
    }


    private static boolean isWinning(List<Integer> list) {
        if (cache.containsKey(list)) {
            return (boolean) cache.get(list);
        }
        int length = list.size();
        int value;
        for (int i = 0; i < length; i++) {
            value = list.remove(i);
            if (isSorted(list)) {
                list.add(i, value);
                cache.put(list, Boolean.TRUE);
                return true;
            }
            if (!isWinning(list)) {
                list.add(i, value);
                cache.put(list, Boolean.TRUE);
                return true;
            }
            list.add(i, value);
        }
        cache.put(list, Boolean.FALSE);
        return false;
    }
}
