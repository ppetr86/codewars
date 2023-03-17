package com.example.codewars;

import java.text.ParseException;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://www.codewars.com/kata/55b3425df71c1201a800009c/train/java
public class Stat {

    public static void main(String[] args) throws ParseException {
        System.out.println(stat("01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17"));
    }

    public static String stat(String strg) throws ParseException {
        if (strg.isEmpty()) return "";
        List<Long> secondsList = Stream.of(strg.split(", ")).map(Stat::toSeconds).sorted().collect(Collectors.toList());

        long range = Collections.max(secondsList) - Collections.min(secondsList);
        double average = secondsList.stream().mapToLong(Long::longValue).average().getAsDouble();
        double median;
        if (secondsList.size() % 2 == 0) {
            median = secondsList.stream().skip(secondsList.size() / 2 - 1).limit(2).mapToLong(Long::longValue).average().getAsDouble();
        } else {
            median = secondsList.stream().skip(secondsList.size() / 2).limit(1).mapToLong(Long::longValue).average().getAsDouble();
        }

        return String.format("Range: %1$s Average: %2$s Median: %3$s",
                formatSeconds(range),
                formatSeconds((long) average),
                formatSeconds((long) median));
    }

    private static String formatSeconds(long input) {
        long seconds = input % 60;
        long minutes = input / 60 % 60;
        long hours = input / 3600;
        return String.format("%02d|%02d|%02d", hours, minutes, seconds);
    }

    private static long toSeconds(String result) {
        int[] time = Stream.of(result.trim().split("\\|")).mapToInt(Integer::parseInt).toArray();
        Duration hours = Duration.ofHours(time[0]);
        Duration minutes = Duration.ofMinutes(time[1]);
        Duration seconds = Duration.ofSeconds(time[2]);
        return hours.plus(minutes).plus(seconds).getSeconds();
    }
}