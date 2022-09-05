package com.example.codewars3.codewars.kyu6;

//https://www.codewars.com/kata/585d7d5adb20cf33cb000235/train/java
public class FindTheUniqueNumber {

    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{0, 0, 0, 0, 0, 7}));
    }

    public static double findUniq(double arr[]) {

        double first = arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (first != arr[i]) {
                if (first != arr[i + 1])
                    return first;
                return arr[i];
            }
        }
        return arr[arr.length - 1];
    }
}
