package com.example.codewars3.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DifferenceOfTwo {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twosDifference(new int[]{4, 3, 1, 5, 6})));
    }

    public static int[][] twosDifference(int[] array) {

        array = Arrays.stream(array).sorted().toArray();
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length; j++) {
                if (-array[i] + array[j] == 2) {
                    List<Integer> dummy = new ArrayList<>();
                    dummy.add(array[i]);
                    dummy.add(array[j]);
                    lists.add(dummy);
                }
                if (-array[i] + array[j] > 2) break;
            }

        }
        int[][] result = new int[lists.size()][2];
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(0).size(); j++) {
                result[i][j] = lists.get(i).get(j);
            }
        }
    /*result = lists.stream()
            .map(x->x.toArray(new Integer[lists.size()]))
            .toArray(Integer[][]::new);*/
        return result;
    }
}

//var s = MyArrays.stream(a).boxed().collect(Collectors.toSet());
//    return MyArrays.stream(a).boxed().filter(x -> s.contains(x + 2)).sorted().map(x -> new int[]{x, x + 2}).toArray(int[][]::new);

//    return of(array).filter(i -> contains(array, i + 2)).sorted().mapToObj(i -> new int[]{i, i + 2}).toArray(int[][]::new);