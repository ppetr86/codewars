package com.example.entwicklerheld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScaleHard {

    public static void main(String[] args) {
        System.out.println(346 + " " + getMasses(346, Arrays.asList(1, 3, 9, 27, 81, 243)));
        System.out.println(291 + " " + getMasses(291, Arrays.asList(1, 3, 9, 27, 81, 243)));
        System.out.println(1 + " " + getMasses(1, Arrays.asList(1, 3, 9, 27, 81, 243)));
        System.out.println(2 + " " + getMasses(2, Arrays.asList(1, 3, 9, 27, 81, 243)));
        System.out.println(4 + " " + getMasses(4, Arrays.asList(1, 3, 9, 27, 81, 243)));
        System.out.println(5 + " " + getMasses(5, Arrays.asList(1, 3, 9, 27, 81, 243)));
        System.out.println(10 + " " + getMasses(10, Arrays.asList(1, 3, 9, 27, 81, 243)));
        System.out.println(11 + " " + getMasses(11, Arrays.asList(1, 3, 9, 27, 81, 243)));

    }

    static List<List<Integer>> getMasses(int slowLorisWeight, List<Integer> allMasses) {
        List<Integer> left = new ArrayList<>();
        int index = firstHigherOrEqualIndex(allMasses, slowLorisWeight);
        int sum = sumList(allMasses, 1 + index);
        List<Integer> right = new ArrayList<>(allMasses.subList(0, 1 + index));
        recursiveCall(slowLorisWeight, allMasses, right, index, sum, left);
        return Arrays.asList(left.isEmpty() ? Arrays.asList() : left, right);
    }

    private static void recursiveCall(int weight, List<Integer> allMasses, List<Integer> right,
                                      int index, int sum, List<Integer> left) {

        if (index == -1) {
            left.clear();
            right.clear();
            return;
        } else if (sum == weight)
            return;
        else if (sum == allMasses.get(index))
            right.add(allMasses.get(index));


        if (sum - 2 * allMasses.get(index) >= weight) {
            sum -= 2 * allMasses.get(index);
            left.add(allMasses.get(index));
            right.remove(index);
        } else if (sum - 2 * allMasses.get(index) < weight) {
            if (sum - allMasses.get(index) >= weight) {
                sum -= allMasses.get(index);
                right.remove(index);
            }
        }
        if (index == 0) return;
        recursiveCall(weight, allMasses, right, --index, sum, left);
    }

    private static int sumList(List<Integer> list, int index) {
        return list.stream().mapToInt(Integer::intValue).limit(index).sum();
    }

    private static int firstHigherOrEqualIndex(List<Integer> allMasses, int slowLorisWeight) {
        int result = allMasses.size() - 1;
        int integer;
        for (int i = 0; i < allMasses.size(); i++) {
            integer = allMasses.get(i);
            if (integer >= slowLorisWeight) {
                result = i;
                break;
            }
        }
        return result;
    }


}
