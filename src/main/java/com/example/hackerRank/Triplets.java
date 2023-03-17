package com.example.hackerRank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Triplets {

    public static void main(String[] args) {
        System.out.println(triplets(new int[]{1, 4, 5}, new int[]{2, 3, 3}, new int[]{1, 2, 3}));
    }

    static long triplets(int[] a, int[] b, int[] c) {
        Set<List<Integer>> triples = new HashSet<>();

    /*int bMin = MyArrays.stream(b).min().orElse(0);
    int bMax = MyArrays.stream(b).max().orElse(0);
    int cMax = MyArrays.stream(c).max().orElse(0);
    a = MyArrays.stream(a).filter(x->x>=bMax).toArray();
    c = MyArrays.stream(c).filter(x->x>=bMax).toArray();*/

        for (int i = 0; i < a.length; i++) {
            int p = a[i];
            for (int j = 0; j < b.length; j++) {
                int q = b[j];
                if (p <= q) {
                    for (int k = 0; k < c.length; k++) {
                        int r = c[k];
                        if (q >= r) triples.add(Arrays.asList(p, q, r));
                    }
                }
            }
        }
        System.out.println(triples);
        return triples.size();
    }
}
