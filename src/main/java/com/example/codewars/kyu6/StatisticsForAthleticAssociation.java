package com.example.codewars.kyu6;
//https://www.codewars.com/kata/55b3425df71c1201a800009c/solutions/java

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticsForAthleticAssociation {

    public static void main(String[] args) {
        System.out.println(stat2("01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17"));
    }

    public static String stat2(String strg) {

        List<Integer> stats = Arrays.stream(strg.split(", "))
                .map(StatisticsForAthleticAssociation::stringsToSeconds)
                .collect(Collectors.toList());

        IntSummaryStatistics summaryStatistics = stats.stream().mapToInt(Integer::intValue).summaryStatistics();

        return String.format("Range: %s Average: %s Median: %s",
                secondsToString(summaryStatistics.getMax() - summaryStatistics.getMin()),
                secondsToString((int) summaryStatistics.getAverage()),
                secondsToString(getMedian(stats)));
    }

    public static int getMedian(List<Integer> integers) {
        Collections.sort(integers);
        int median;
        if (integers.size() % 2 == 0)
            median = (integers.get(integers.size() / 2) + integers.get(integers.size() / 2 - 1)) / 2;
        else
            median = integers.get(integers.size() / 2);
        return median;
    }

    public static int stringsToSeconds(String str) {
        String[] strings = str.split("\\|");
        return Integer.parseInt(strings[0]) * 3600 + Integer.parseInt(strings[1]) * 60 + Integer.parseInt(strings[2]);
    }

    public static String secondsToString(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds - hours * 3600) / 60;
        int secs = seconds - hours * 3600 - minutes * 60;

        return String.format("%s|%s|%s", hours < 10 ? "0" + hours : hours, minutes < 10 ? "0" + minutes : minutes, secs < 10 ? "0" + secs : secs);
    }
}
