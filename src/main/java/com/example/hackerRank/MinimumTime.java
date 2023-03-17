package com.example.hackerRank;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumTime {

    public static void main(String[] args) {
        System.out.println(minTime(new long[]{2, 3, 2}, 10));
    }

    static long minTime(long[] machines, long goal) {
        int done = 0;
        int maxDays = (int) Arrays.stream(machines).max().orElse(0);
        int dayCount = 1;

        Map<Long, Long> map = Arrays.stream(machines).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

        Arrays.sort(machines);
        while (done < goal) {
            for (int i = 1; i <= maxDays; i++) {
                if (dayCount % machines[i - 1] == 0) {
                    done += map.get(machines[i - 1]);
                    dayCount++;
                }
            }
            if (done >= goal) break;
        }
        return dayCount;
    }
}
