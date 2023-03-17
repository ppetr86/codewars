package com.example.hackerRank;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Pairs {
    public static void main(String[] args) {
        System.out.println(pairs(10, new int[]{100, 20, 30, 50, 60, 90}));
    }

    static int pairs(int k, int[] arr) {
        int counter = 0;
        Arrays.sort(arr);
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] - arr[i - 1] > k) continue;
            int lookingFor = arr[i] - k;
            if (set.contains(lookingFor)) {
                counter++;
                set.remove(lookingFor);
            }
        }
        return counter;
    }
}
