package com.example.codewars3.measureStructure;

public enum UnitType {

    LENGTH("length"),
    WEIGHT("weight");

    public final String type;

    UnitType(String type) {
        this.type = type;
    }
}