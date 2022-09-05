package com.example.codewars3.playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Delete {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " Ahoj kamarade");
            i++;
        }

        Army a = new Army();
        a.setTroops(List.of(1, 2, 4, 5));
        System.out.println(a.getTroops());

        removeDeadTroopsFromArmy(a);
        System.out.println("after Zdenek removal");
        System.out.println(a.getTroops());

        Integer in1 = 0;
        Integer in2 = 0;
        updateInts(in1, in2);
        System.out.println("ints " + in1 + " " + in2);

        List<String> first = new ArrayList<>();
        List<String> sec = new ArrayList<>();

        updateLists(first, sec);
        System.out.println("-------------");
        System.out.println(first);
        System.out.println(sec);
        int[] team1 = new int[]{11, 1, 1};
        int team0_sum = Arrays.stream(team1).sum();
        System.out.println(Arrays.stream(team1).sum());

        System.out.println(Arrays.toString(givePoints(team0_sum, 1)));
        System.out.println(Arrays.toString(givePoints(team0_sum, 2)));
        System.out.println(Arrays.toString(givePoints(team0_sum, 3)));
        System.out.println(Arrays.toString(givePoints(team0_sum, 4)));
        System.out.println(Arrays.toString(givePoints(team0_sum, 5)));
        System.out.println(Arrays.toString(givePoints(team0_sum, 6)));
    }

    private static void updateInts(Integer in1, Integer in2) {

    }

    static class Army {
        private int attackPoints = 0;
        private int defencePoints = 0;
        private int healthPoints = 0;
        private List<Integer> troops;

        public Army() {
        }

        public List<Integer> getTroops() {
            return troops;
        }

        public void setTroops(List<Integer> troops) {
            this.troops = troops;
        }
    }


    private static int[] givePoints(int team0_sum, int team2_length) {
        int max_bound = (int) (team0_sum * 1.25);
        int min_boud = (int) (team0_sum * 0.9);
        int random_sum = Math.max(0, new Random().nextInt(max_bound - min_boud) + min_boud);

        int[] team2_job_levels = new int[team2_length];

        for (int i = 0; i < random_sum; i++) {
            int holder = (int) (Math.random() * team2_length);
            team2_job_levels[holder]++;
        }

        for (int i = 0; i < team2_length; i++) {
            if (team2_job_levels[i] == 0) team2_job_levels[i] = 1;
        }

        System.out.print(Arrays.stream(team2_job_levels).sum());
        return team2_job_levels;
    }

    private static List<Integer> removeDeadTroopsFromArmy(Army a) {
        List<Integer> smallerThan2 = a.getTroops().stream().filter(x -> x < 3).collect(Collectors.toList());
        a.getTroops().removeAll(smallerThan2);
        return a.getTroops();
    }

    private static void updateLists(List<String> first, List<String> sec) {
        first.add("ahoj");
        sec.add("nazdar");
    }

}