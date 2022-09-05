package com.example.codewars3.hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeaderBoardV2 {

    public static void main(String[] args) {
        System.out.println(climbingLeaderboard(Arrays.asList(100, 100, 50, 40, 40, 20, 10), Arrays.asList(5, 25, 50, 120)));
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> ranks = new ArrayList<>(player.size());
        ranked = ranked.stream().distinct().collect(Collectors.toList());

        for (int i = 0; i < player.size(); i++) {
            int currentPoints = player.get(i);
            int ranking = calculateRanking(currentPoints, ranked);
            ranks.add(ranking);
        }
        return ranks;
    }

    private static int calculateRanking(int currentPoints, List<Integer> ranked) {

        int position = 1;
        for (int i = 0; i < ranked.size() - 1; i++) {
            if (currentPoints >= ranked.get(i)) break;
            if (ranked.get(i) > ranked.get(i + 1)) position++;
        }
        if (ranked.get(ranked.size() - 1) > currentPoints) position++;
        return position;
    }
}
