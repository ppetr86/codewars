package com.example.codewars3.codewars.kyu5;

public class HumanReadableTime {

    public static void main(String[] args) {
        System.out.println(makeReadable(5));
    }

    public static String makeReadable(int seconds) {
        int hours = seconds / 3600;
        int remainderFromHours = seconds % 3600;
        int minutes = remainderFromHours / 60;
        int secs = seconds % 60;

        return (9 < hours ? hours : "0" + hours) + ":"
                + (9 < minutes ? minutes : "0" + minutes) + ":"
                + (9 < secs ? secs : "0" + secs);
    }

    public static String makeReadableV2(int seconds) {
        String sec = twoDigit(seconds % 60);
        String min = twoDigit((seconds / 60) % 60);
        String hour = twoDigit((seconds / 3600) % 100);
        return String.format("%s:%s:%s", hour, min, sec);
    }

    public static String twoDigit(int n) {
        return n < 10 ? "0" + n : String.valueOf(n);
    }
}
