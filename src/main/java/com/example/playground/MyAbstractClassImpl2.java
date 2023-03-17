package com.example.playground;

public class MyAbstractClassImpl2 extends MyAbstractClass {
    @Override
    protected String hashSurname(String surname) {
        char[] chars = surname.toCharArray();
        int sum = 0;
        for (char c : chars)
            sum += c;
        return String.valueOf(sum);
    }


}
