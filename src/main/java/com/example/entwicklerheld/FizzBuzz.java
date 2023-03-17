package com.example.entwicklerheld;

public class FizzBuzz {


    public static void main(String[] args) {
        System.out.println(fizzbuzz(10));
    }

    static String fizzbuzz(int number) {
        String result = "";
        if (number % 5 == 0 && number % 3 == 0) {
            result = "fizzbuzz";
        } else if (number % 5 != 0 || number % 3 != 0) {
            result = String.valueOf(number);
        } else if (number % 3 == 0) {
            result = "fizz";
        } else if (number % 5 == 0) {
            result = "buzz";
        }
        return result;
    }
}
