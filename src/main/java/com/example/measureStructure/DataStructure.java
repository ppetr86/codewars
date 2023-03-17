package com.example.measureStructure;

import java.util.ArrayList;
import java.util.List;

public class DataStructure {


    public static void main(String[] args) {
        List<UnitV2> unitV2s = new ArrayList<>(10);
        unitV2s.add(new UnitV2("mm", 0.001, UnitType.LENGTH));
        unitV2s.add(new UnitV2("cm", 0.01, UnitType.LENGTH));
        unitV2s.add(new UnitV2("dm", 0.1, UnitType.LENGTH));
        unitV2s.add(new UnitV2("m", 1, UnitType.LENGTH));
        unitV2s.add(new UnitV2("km", 1000, UnitType.LENGTH));

        unitV2s.add(new UnitV2("mm", 0.001, UnitType.WEIGHT));
        unitV2s.add(new UnitV2("mm", 1, UnitType.WEIGHT));
        unitV2s.add(new UnitV2("mm", 10, UnitType.WEIGHT));
        unitV2s.add(new UnitV2("mm", 100, UnitType.WEIGHT));
        unitV2s.add(new UnitV2("mm", 1000000, UnitType.WEIGHT));

        System.out.println(returnConvertedToBase("mmm", 188, unitV2s));
    }


    static public double returnConvertedToBase(String unit, double inputNumber, List<UnitV2> unitV2List) {
        if (inputNumber < 0) throw new RuntimeException("negative input. No possible conversion");
        return unitV2List
                .stream()
                .filter(x -> x.unit.equals(unit))
                .mapToDouble(x -> x.conversionToBase * inputNumber)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("unit not found in the list"));
    }

    static public double returnConvertedToBase(UnitV2 unit, double inputNumber, List<UnitV2> unitV2List) {
        if (inputNumber < 0) throw new RuntimeException("negative input. No possible conversion");
        return unitV2List
                .stream()
                .filter(x -> x.unit.equals(unit))
                .mapToDouble(x -> x.conversionToBase * inputNumber)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("unit not found in the list"));
    }
}
