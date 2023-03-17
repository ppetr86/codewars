package com.example.measureStructure;

import java.util.Objects;

public class UnitV2 {

    public final String unit;
    public final double conversionToBase;
    public final UnitType baseType;


    public UnitV2(String unit, double conversionToBase, UnitType baseType) {
        this.unit = unit;
        this.conversionToBase = conversionToBase;
        this.baseType = baseType;
    }

    public double getConversionToBase(UnitV2 unitV2) {
        return unitV2.conversionToBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitV2 unitV2 = (UnitV2) o;
        return Double.compare(unitV2.conversionToBase, conversionToBase) == 0 && unit.equals(unitV2.unit) && baseType == unitV2.baseType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, conversionToBase, baseType);
    }
}
