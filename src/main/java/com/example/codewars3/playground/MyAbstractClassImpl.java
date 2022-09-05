package com.example.codewars3.playground;

public class MyAbstractClassImpl extends MyAbstractClass {

    @Override
    protected String hashSurname(String surname) {
        return String.valueOf(surname.length());
    }
}
