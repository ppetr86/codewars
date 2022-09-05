package com.example.codewars3.codewars;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

//https://www.codewars.com/kata/56eb16655250549e4b0013f4/train/java

public class MostFrequentDays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mostFrequentDays(2000)));
    }

    public static String[] mostFrequentDays(int year) {
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        long count = ChronoUnit.DAYS.between(start, end) + 1;

        HashMap<String, Integer> daysCount = new HashMap<>();
        daysCount.put("Sunday", 0);
        daysCount.put("Monday", 0);
        daysCount.put("Tuesday", 0);
        daysCount.put("Wednesday", 0);
        daysCount.put("Thursday", 0);
        daysCount.put("Friday", 0);
        daysCount.put("Saturday", 0);

        // fill the map with day count in the year
        for (int i = 0; i < count; i++) {
            String day = start.plusDays(i).getDayOfWeek().toString();
            day = day.charAt(0) + day.substring(1).toLowerCase();
            daysCount.put(day, daysCount.get(day) + 1);
        }

        // get frequencies
        Collection<Integer> frequencies = daysCount.values();

        int highestFrequency = frequencies.stream().mapToInt(each -> each).max().orElse(0);

        List<String> days = new ArrayList<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        daysCount.entrySet().stream().forEach(each -> {
            if (!each.getValue().equals(highestFrequency)) days.remove(each.getKey());
        });

        String[] result = new String[days.size()];
        return days.toArray(result);
    }
}
