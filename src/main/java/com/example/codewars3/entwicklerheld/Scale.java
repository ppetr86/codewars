package com.example.codewars3.entwicklerheld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scale {

    public static void main(String[] args) {
        //System.out.println(getMasses(100, Arrays.asList(110, 99, 80, 70, 60, 50, 40, 30, 20, 10)));
        //System.out.println(getMasses(250, Arrays.asList(1, 2, 4, 8, 16, 32, 64, 128)));
        //System.out.println(getMasses(355, Arrays.asList(1, 3, 9, 27, 81, 243)));
        //System.out.println(getMasses2(100, Arrays.asList(110, 99, 80, 70, 60, 50, 40, 30, 20, 10)));
        System.out.println(getMasses2(250, Arrays.asList(1, 2, 4, 8, 16, 32, 59, 64, 128)));
        System.out.println(getMasses2(355, Arrays.asList(1, 3, 9, 27, 81, 243)));
        System.out.println(getMasses2(0, Arrays.asList(1, 2, 4, 8, 16, 32, 59, 64, 128)));

    }

    private static List<Integer> getMasses2(int weight, List<Integer> allMasses) {
        List<Integer> result = new ArrayList<>();
        recursiveCall(weight, allMasses, result, allMasses.size() - 1);
        return result;
    }

    private static void recursiveCall(int weight, List<Integer> allMasses, List<Integer> result,
                                      int index) {
        if (weight == 0) {
            return;
        } else if (weight >= allMasses.get(index)) {
            weight -= allMasses.get(index);
            result.add(allMasses.get(index));
        }
        recursiveCall(weight, allMasses, result, --index);
    }

    static List<Integer> getMasses(Integer weight, List<Integer> allMasses) {

        List<Integer> result = new ArrayList<>();
        if (weight <= 0 || allMasses.isEmpty()) {
            return result;
        }

        for (int i = allMasses.size() - 1; i >= 0; i--) {
            result = new ArrayList<>();
            int weight2 = weight;
            int curI = allMasses.get(i);
            if (curI < 1 || result.contains(curI)) {
                continue;
            }
            if (weight2 - curI >= 0) {
                result.add(curI);
                weight2 -= curI;

                for (int j = i - 1; j >= 0; j--) {
                    int curj = allMasses.get(j);
                    if (curj < 1 || result.contains(curj)) {
                        continue;
                    }
                    if (weight2 - curj >= 0) {
                        result.add(curj);
                        weight2 -= curj;
                        if (weight2 == 0) {
                            break;
                        }
                    }
                }
                if (weight2 == 0) {
                    break;
                }
            }

        }
        return result;
    }

}
