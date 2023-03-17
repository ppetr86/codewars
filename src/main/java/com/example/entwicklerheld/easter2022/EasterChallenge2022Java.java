package com.example.entwicklerheld.easter2022;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class EasterChallenge2022Java {


    public static List<Calendar> calculateEasterDays(int year) {
        Calendar sunday = calculateEasterSunday(year);
        Calendar friday = new GregorianCalendar(sunday.get(Calendar.YEAR), sunday.get(Calendar.MONTH), sunday.get(Calendar.DAY_OF_MONTH) - 2);
        Calendar monday = new GregorianCalendar(sunday.get(Calendar.YEAR), sunday.get(Calendar.MONTH), sunday.get(Calendar.DAY_OF_MONTH) + 1);
        return Arrays.asList(friday, sunday, monday);
    }

    public static Calendar calculateEasterSunday(int year) {
        int a = year % 19,
                b = year / 100,
                c = year % 100,
                d = b / 4,
                e = b % 4,
                g = (8 * b + 13) / 25,
                h = (19 * a + b - d - g + 15) % 30,
                j = c / 4,
                k = c % 4,
                m = (a + 11 * h) / 319,
                r = (2 * e + 2 * j - k - h + m + 32) % 7,
                month = (h - m + r + 90) / 25,
                day = (h - m + r + month + 19) % 32;

        Calendar result = new GregorianCalendar(year, month, day);
        return result;
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");


        calculateEasterDays(2022).forEach(each -> System.out.println(each.get(Calendar.YEAR) + " " + each.get(Calendar.MONTH) + " " + each.get(Calendar.DAY_OF_MONTH)));
    }
}