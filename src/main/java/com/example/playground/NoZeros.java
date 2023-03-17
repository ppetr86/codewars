package com.example.playground;

import java.util.ArrayList;
import java.util.List;

public class NoZeros {

    public static void main(String[] args) {
        int[] input3 = new int[]{1, 2, 0, 3, 4, 0, 6, 7, 8};
        System.out.println(noZeros(input3));
    }

    private static List<Integer> noZeros(int[] input3) {
        List<Integer> result = new ArrayList<>(input3.length);
        boolean isAcceptingNumbers = true;

        for (int each : input3) {
            if (each == 0 && isAcceptingNumbers) {
                isAcceptingNumbers = false;
            } else if (each == 0 && !isAcceptingNumbers) {
                isAcceptingNumbers = true;
            } else if (isAcceptingNumbers) {
                result.add(each);
            }
        }
        return result;
    }
}
