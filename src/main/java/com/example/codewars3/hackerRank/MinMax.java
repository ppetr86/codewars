package com.example.codewars3.hackerRank;

import java.util.Arrays;

public class MinMax {
    public static void main(String[] args) {
        //Easy: https://www.hackerrank.com/challenges/mini-max-sum/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
        int[] arr = {256741038, 623958417, 467905213, 714532089, 938071625}; //2063136757 2744467344
        miniMaxSum(arr);

    }

    static void miniMaxSum(int[] arr) {

        long max = Arrays.stream(arr).sorted().skip(1).mapToObj(x -> (long) x).reduce(0L, Long::sum);
        long min = Arrays.stream(arr).sorted().mapToObj(x -> (long) x).limit(4).reduce(0L, Long::sum);

        System.out.print(min + " " + max);
    }
}
