package com.example.codewars3.codewars.kyu5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TourGranny {

    public static void main(String[] args) {
        String[] friends = new String[]{"A1", "A2", "A3", "A4", "A5"};

        String[][] towns = {
                new String[]{"A1", "X1"},
                new String[]{"A2", "X2"},
                new String[]{"A3", "X3"},
                new String[]{"A4", "X4"}};

        Map<String, Double> distTable = new HashMap<>();
        distTable.put("X1", 100.0);
        distTable.put("X2", 200.0);
        distTable.put("X3", 250.0);
        distTable.put("X4", 300.0);

        System.out.println(tour(friends, towns, distTable));
        System.out.println(tourV2(friends, towns, distTable));
    }

    public static int tour(String[] friends, String[][] towns, Map<String, Double> distances) {
        double totalDistance = 0d;

        String previousTown = "X0";

        for (int i = 0; i < friends.length; i++) {
            String currentFriend = friends[i];
            String currentTown = findCurrentTown(currentFriend, towns);
            if (i == 0) totalDistance += distances.get(currentTown);
            double distanceToAdd = calculateDistance(distances, currentTown, previousTown);
            if (i > 0) totalDistance += distanceToAdd;
            previousTown = currentTown;
        }

        totalDistance += getLastTownDistance(towns, distances);

        return (int) totalDistance;
    }

    private static double getLastTownDistance(String[][] towns, Map<String, Double> distances) {
        String lastTown = towns[towns.length - 1][1];
        return distances.getOrDefault(lastTown, 0d);
    }

    private static double calculateDistance(Map<String, Double> distances, String currentTown, String previousTown) {
        // c is the longest
        double c = Math.pow(distances.getOrDefault(currentTown, 0d), 2);
        double b = Math.pow(distances.getOrDefault(previousTown, 0d), 2);
        if (c == 0d || b == 0d) return 0d;
        return Math.sqrt(c - b);
    }

    private static String findCurrentTown(String currentFriend, String[][] towns) {

        return Arrays.stream(towns).filter(each -> each[0].equals(currentFriend)).map(match -> match[1]).collect(Collectors.joining());
    }

    public static int tourV2(String[] arrFriends, String[][] ftwns, Map<String, Double> h) {
        double result = 0;
        double[][] route = new double[arrFriends.length + 1][2];
        int prevTown = 0;
        for (int friendIdx = 0; friendIdx < arrFriends.length; friendIdx++) {
            for (int townIdx = 0; townIdx < ftwns.length; townIdx++) {
                if (arrFriends[friendIdx].equals(ftwns[townIdx][0])) {
                    if (friendIdx == 0) {
                        route[friendIdx][0] = h.get(ftwns[townIdx][1]);
                    } else {
                        route[friendIdx][0] = h.get(ftwns[townIdx][1]);
                        route[friendIdx][1] = h.get(ftwns[prevTown][1]);
                    }
                    prevTown = townIdx;
                }
            }
        }
        route[route.length - 1][0] = h.get(ftwns[prevTown][1]);
        for (int i = 0; i < route.length; i++) {
            double fir = Math.pow(route[i][0], 2);
            double sec = Math.pow(route[i][1], 2);
            double holdr = Math.sqrt(Math.pow(route[i][0], 2) - Math.pow(route[i][1], 2));
            result += Math.sqrt(Math.pow(route[i][0], 2) - Math.pow(route[i][1], 2));
        }
        return (int) Math.floor(result);
    }

}
