package com.example.codewars3.hackerRank;

public class NewYearChaos {

    public static void main(String[] args) {
        minimumBribes(new int[]{5, 1, 2, 3, 7, 8, 6, 4});
    }

    static void minimumBribes(int[] arr) {

        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {

                if ((i - 1) >= 0 && arr[i - 1] == i + 1) {
                    counter++;
                    swap(arr, i, i - 1);
                } else if ((i - 2) >= 0 && arr[i - 2] == i + 1) {
                    counter += 2;
                    swap(arr, i - 2, i - 1);
                    swap(arr, i - 1, i);
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }

        System.out.println(counter);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
