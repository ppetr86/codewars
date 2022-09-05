package com.example.codewars3;

import java.util.Arrays;

public class Expleo {

    public static boolean isInWeightLimit(int weight) {
        return weight >= 10 && weight <= 200;
    }

    public static void main(String[] args) {

    }

    public static int solve(int weight0, int weight1, int weight2) {

        int[] weightArr = new int[]{weight0, weight1, weight2};
        int maxSoFar = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < weightArr.length; i++) {
            int weight = weightArr[i];
            if (isInWeightLimit(weight) && weight > maxSoFar) {
                maxSoFar = weight;
                index = i;
            }

        }
        return index;

    }

    public static String solve(int width, int height, int length, int mass) {

        boolean isBulky = isBulky(width, height, length);
        boolean isHeavy = isHeavy(mass);
        String result = null;

        if (isBulky && isHeavy)
            result = "REJECTED";
        if (!isBulky && !isHeavy)
            result = "STANDARD";
        if (isBulky || isHeavy)
            result = "SPECIAL";

        return result;
    }

    static boolean exists(int[] ints, int k) {
        if (ints.length == 0)
            return false;

        Arrays.sort(ints);

        int left = 0;
        int right = ints.length - 1;

        while (left <= right) {
            int midpoint = left + (right - left) / 2;
            if (ints[midpoint] == k) {
                return true;
            } else if (ints[midpoint] > k) {
                right = midpoint - 1;
            } else {
                left = midpoint + 1;
            }
        }
        return false;
    }

    static boolean exists2(int[] ints, int k) {
        if (ints.length == 0)
            return false;

        return Arrays.stream(ints).parallel().anyMatch(element -> element == k);
    }

    private static boolean isBulky(int width, int height, int length) {
        if (width < 0)
            width = 1;
        if (height < 0)
            height = 1;
        if (length < 0)
            length = 1;

        if (width > 150 || height > 150 || length > 150)
            return true;

        return width * height * length >= 1000000;
    }

    private static boolean isHeavy(int mass) {
        return mass >= 20;
    }

    private static boolean isValid(int width, int height, int length, int mass) {
        boolean result = false;
        if (width >= 20 && width <= 200 && height >= 20 && height <= 200 && length >= 20 && length <= 200)
            result = true;

        if (!result)
            return result;

        if (mass >= 10 && mass <= 1000)
            return true;
        return false;
    }
}
