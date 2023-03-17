package com.example.entwicklerheld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleRow {
//https://platform.entwicklerheld.de/challenge/67f573af-4187-4982-a3d1-10daf73785f4/task/c3e25959-a38b-4905-b5b6-e98915532c54/edit

    public static void main(String[] args) {
        System.out.println(getPascalsTriangleRow(6));
    }

    public static List<Long> getPascalsTriangleRow(int rowNumber) {
        if (rowNumber < 0) {
            return Arrays.asList(0l);
        }

        ArrayList<Long> res = new ArrayList<>(rowNumber + 1);
        res.add(1L);
        for (int i = 1; i <= rowNumber; i++) {
            res.add(i, (res.get(i - 1) * (rowNumber - i + 1)) / (i));
        }

        return res;
    }

}
