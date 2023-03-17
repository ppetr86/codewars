package com.example.hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeaderBoard {

    public static void main(String[] args) {
        System.out.println(climbingLeaderboard(Arrays.asList(100, 100, 50, 40, 40, 20, 10), Arrays.asList(5, 25, 50, 120)));
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> ranks = new ArrayList<>(player.size());

        Map<Integer, Integer> rankingMap = calculateRankingMap(ranked);
        List<Integer> keySet = rankingMap.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for (int i = 0; i < player.size(); i++) {
            int currentPoints = player.get(i);
            int ranking = calculateRankingFromMap(rankingMap, currentPoints, keySet);
            ranks.add(ranking);
        }
        return ranks;
    }

    private static int calculateRankingFromMap(Map<Integer, Integer> rankingMap, int currentPoints, List<Integer> keySet) {

        if (keySet.get(0) < currentPoints) return 1;
        if (keySet.get(keySet.size() - 1) > currentPoints) return keySet.size() + 1;

        for (int i = 1; i < keySet.size(); i++) {
            if (keySet.get(i) == currentPoints) return rankingMap.get(currentPoints);
            if (currentPoints < keySet.get(i - 1) && currentPoints > keySet.get(i))
                return rankingMap.get(keySet.get(i - 1)) + 1;
        }

        return 0;
    }


    private static HashMap<Integer, Integer> calculateRankingMap(List<Integer> ranked) {
        HashMap<Integer, Integer> result = new HashMap<>();

        int position = 1;
        result.put(ranked.get(0), position);

        for (int i = 1; i < ranked.size(); i++) {
            if (ranked.get(i).equals(ranked.get(i - 1))) {
                continue;
            }
            if (ranked.get(i) < ranked.get(i - 1)) {
                position++;
            }
            result.put(ranked.get(i), position);
        }

        return result;
    }
}