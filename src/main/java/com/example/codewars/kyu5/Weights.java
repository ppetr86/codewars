package com.example.codewars.kyu5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Weights {
    public static void main(String[] args) {
        System.out.println(orderWeight("59544965313"));
    }

    public static String orderWeight(String strng) {

        if (strng.isBlank()) return "";
        List<Weight> list = Arrays
                .stream(strng.split(" "))
                .map(x -> x.replaceAll(" ", ""))
                .mapToLong(Long::valueOf)
                .mapToObj(Weight::new)
                .collect(Collectors.toList());

        compareAndOrder(list);
        return list.stream().map(Weight::getOriginalWeight).map(String::valueOf).collect(Collectors.joining(" "));
    }

    private static void compareAndOrder(List<Weight> list) {
        list.sort((w1, w2) -> {
            if (w1.recalculated != w2.recalculated) {
                return (int) (w1.recalculated - w2.recalculated);
            } else {
                return String.valueOf(w1.originalWeight).compareTo(String.valueOf(w2.originalWeight));
            }
        });
    }

    static class Weight {
        public long originalWeight;
        public long recalculated;

        public Weight(long nr) {
            this.originalWeight = nr;
            this.recalculated = Arrays.stream(String.valueOf(nr).split("")).mapToLong(Long::valueOf).sum();
        }

        public long getOriginalWeight() {
            return originalWeight;
        }

        @Override
        public String toString() {
            return String.valueOf(recalculated);
        }
    }
}
