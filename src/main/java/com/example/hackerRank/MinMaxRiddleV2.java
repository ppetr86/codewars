package com.example.hackerRank;
//https://www.hackerrank.com/challenges/min-max-riddle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=stacks-queues
//is not passing all tests based on speed

import java.util.ArrayDeque;
import java.util.Arrays;

public class MinMaxRiddleV2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(riddle(new long[]{3, 5, 4, 7, 6, 2})));
    }

    static long[] riddle(long[] arr) {
        long[] result = new long[arr.length];
        int length = 1;

        while (length <= arr.length) {
            ArrayDeque<Long> myQ = new ArrayDeque<>(length);
            long myQmin = 0;

            for (int i = 0; i < arr.length; i++) {
                if (myQ.size() < length - 1) {
                    myQ.add(arr[i]);
                    continue;
                }
                if (myQ.size() == length - 1) {
                    myQ.add(arr[i]);
                    long holderMin = myQ.stream().min(Long::compare).get();
                    myQmin = Math.max(holderMin, myQmin);
                    myQ.poll();
                    result[length - 1] = myQmin;
                }
            }
            length++;
        }
        return result;
    }
}
