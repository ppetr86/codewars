package com.example.codewars3.codewars.kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTravel {

    public static void main(String[] args) {
        System.out.println(chooseBestSum(230, 3, new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87))));
    }

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {

        if (k > ls.size()) return null;
        int[] s = new int[k];
        List<int[]> subsets = new ArrayList<>();

        // first index sequence: 0, 1, 2, ...
        for (int i = 0; (s[i] = i) < k - 1; i++) ;
        subsets.add(getSubset(ls, s));
        while (true) {
            int i;
            // find position of item that can be incremented
            for (i = k - 1; i >= 0 && s[i] == ls.size() - k + i; i--) ;
            if (i < 0) {
                break;
            }
            s[i]++;                    // increment this item
            for (++i; i < k; i++) {    // fill up remaining items
                s[i] = s[i - 1] + 1;
            }
            subsets.add(getSubset(ls, s));
        }


        return subsets.stream().map(each -> Arrays.stream(each).sum()).filter(sum -> sum <= t).max(Integer::compare).get();
    }

    public static int[] getSubset(List<Integer> ls, int[] subset) {
        int[] result = new int[subset.length];
        for (int i = 0; i < subset.length; i++)
            result[i] = ls.get(subset[i]);
        return result;
    }
}


