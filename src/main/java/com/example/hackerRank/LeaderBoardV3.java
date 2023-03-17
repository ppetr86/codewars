package com.example.hackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeaderBoardV3 {

    public static void main(String[] args) {
        System.out.println(climbingLeaderboard(Arrays.asList(100, 100, 50, 40, 40, 20, 10), Arrays.asList(5, 25, 50, 120)));
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        ranked = ranked.stream().distinct().collect(Collectors.toList());

        int[] result = new int[player.size()];
        int left = 0, right = ranked.size() - 1;
        for (int i = 0; i < player.size(); i++) {
            boolean found = false;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (ranked.get(mid).equals(player.get(i))) {
                    found = true;
                    result[i] = mid + 1;
                    right = mid;
                    left = 0;
                    break;
                } else if (ranked.get(mid) < player.get(i)) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (!found && left > right) {
                ranked.add(left, player.get(i));
                result[i] = left + 1;
                right = left;
                left = 0;
            }
        }

        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }


}
