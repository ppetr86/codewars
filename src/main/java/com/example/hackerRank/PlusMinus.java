package com.example.hackerRank;

public class PlusMinus {

    public static void main(String[] args) {
        plusMinus(new int[]{-4, 3, -9, 0, 4, 1});
    }

    static void plusMinus(int[] arr) {

        int pos = 0;
        int neg = 0;
        int neu = 0;

        for (int each : arr) {
            if (each == 0) neu++;
            if (each > 0) pos++;
            if (each < 0) neg++;
        }

        int sum = pos + neg + neu;
        float posRatio = (float) pos / sum;
        float negRatio = (float) neg / sum;
        float neuRatio = (float) neu / sum;

        System.out.println(posRatio + "\n" + negRatio + "\n" + neuRatio);
    }
}
