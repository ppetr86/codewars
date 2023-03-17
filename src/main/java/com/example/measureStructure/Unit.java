package com.example.measureStructure;

public enum Unit {

    MM("mm", 0.001, UnitType.LENGTH),
    CM("cm", 0.01, UnitType.LENGTH),
    DM("dm", 0.1, UnitType.LENGTH),
    M("m", 1, UnitType.LENGTH),
    KM("km", 1000, UnitType.LENGTH),

    MG("mm", 0.001, UnitType.WEIGHT),
    G("mm", 1, UnitType.WEIGHT),
    DKG("mm", 10, UnitType.WEIGHT),
    KG("mm", 100, UnitType.WEIGHT),
    T("mm", 1000000, UnitType.WEIGHT);

    public final String unit;
    public final double conversionToBase;
    public final UnitType baseType;

    Unit(String unit, double conversionToBase, UnitType baseType) {
        this.unit = unit;
        this.conversionToBase = conversionToBase;
        this.baseType = baseType;
    }
}