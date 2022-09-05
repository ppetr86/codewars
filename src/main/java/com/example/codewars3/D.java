package com.example.codewars3;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class D {
    public static void main(String[] args) {
        Map<String, String> mymap = Map.of("1", "2");
        System.out.println(Optional.ofNullable(mymap.get("2")).filter(Objects::nonNull).map(key -> String.valueOf(key.length())).orElse("notFound"));
        System.out.println(mymap.get("123"));
    }

    static double approx(double[][] pts) {

        double x;
        double y;
        int result = 0;
        for (int i = 0; i < pts.length; i++) {
            x = pts[i][0];
            y = pts[i][1];
            if (isPointInsideOfQuarterDisk(x, y) && isValidPoint(x, y))
                result++;
        }
        return (double) result * 4 / pts.length;
    }

    private static boolean isPointInsideOfQuarterDisk(double x, double y) {
        return Math.pow(x, 2) + Math.pow(y, 2) <= 1;
    }

    private static boolean isValidPoint(double x, double y) {
        return x >= 0 && x <= 1 && y >= 0 && y <= 1;
    }
}
