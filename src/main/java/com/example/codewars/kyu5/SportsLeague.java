package com.example.codewars.kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//https://www.codewars.com/kata/5e0e17220d5bc9002dc4e9c4
public class SportsLeague {


    public static void main(String[] args) {

        int[][] arr6 = new int[][]
                {{0, 5, 1, 1},
                        {1, 4, 3, 1},
                        {2, 3, 2, 2},
                        {1, 5, 1, 2},
                        {2, 0, 1, 1},
                        {3, 4, 3, 2},
                        {2, 5, 3, 1},
                        {3, 1, 0, 1},
                        {4, 0, 2, 1},
                        {3, 5, 0, 0},
                        {4, 2, 0, 1},
                        {0, 1, 1, 2},
                        {4, 5, 2, 0},
                        {0, 3, 3, 2},
                        {1, 2, 0, 0}};

        int[][] arr8 = new int[][]
                {{0, 7, 0, 0},
                        {1, 6, 2, 2},
                        {2, 5, 0, 0},
                        {3, 4, 0, 0},
                        {1, 7, 0, 0},
                        {2, 0, 0, 0},
                        {3, 6, 0, 0},
                        {4, 5, 0, 0},
                        {2, 7, 2, 2},
                        {3, 1, 0, 0},
                        {4, 0, 0, 0},
                        {5, 6, 0, 0},
                        {3, 7, 0, 0},
                        {4, 2, 0, 0},
                        {5, 1, 1, 1},
                        {6, 0, 0, 0},
                        {4, 7, 2, 2},
                        {5, 3, 1, 3},
                        {6, 2, 0, 0},
                        {0, 1, 1, 1},
                        {5, 7, 0, 0},
                        {6, 4, 2, 2},
                        {0, 3, 3, 1},
                        {1, 2, 0, 0},
                        {6, 7, 0, 0},
                        {0, 5, 0, 2},
                        {1, 4, 0, 0},
                        {2, 3, 0, 0}};

        int[][] arr4 = new int[][]
                {
                        {0, 3, 2, 1},
                        {1, 2, 3, 0},
                        {1, 3, 2, 0},
                        {2, 0, 2, 0},
                        {0, 1, 0, 1},
                        {2, 3, 0, 1}
                };
        System.out.println(Arrays.toString(computeRanks(6, arr6)));
    }

    public static int[] computeRanks(int number, int[][] games) {

        List<Team> teams = new ArrayList<>();

        //create team list
        for (int i = 0; i < number; i++) {
            teams.add(new Team(i));
        }
        //calculate scores
        Arrays.stream(games).forEach(game -> calculateGame(game, teams));

        //sort
        Collections.sort(teams);

        Map<Long, List<Team>> sublistsMap = getMapWithTeamsGroupedByIdenticalScores(teams);

        List<Team> secondSort = orderTeamsBySublists(sublistsMap, games);

        return secondSort.stream().sorted(Comparator.comparing(Team::getTeamNr)).mapToInt(Team::getRank)
                .toArray();
    }

    private static List<Team> orderTeamsBySublists(Map<Long, List<Team>> sublistsMap, int[][] games) {
        int rank = 1;
        List<Team> secondSort = new ArrayList<>();

        for (Long key : sublistsMap.keySet()) {
            List<Team> fromMap = sublistsMap.get(key);

            if (key == 1) {
                rank = 1;
            } else {
                rank += fromMap.size();
            }
            int finalRank = rank;
            fromMap.forEach(team -> team.setRank(finalRank));

            Collections.sort(fromMap);
            secondSort.addAll(fromMap);
        }
        return secondSort;
    }

    private static int[][] gamesFromReducedListTeams(int[][] game, List<Team> fromMap) {

        return null;
    }

    private static Map<Long, List<Team>> getMapWithTeamsGroupedByIdenticalScores(List<Team> teams) {
        Map<Long, List<Team>> sublistsMap = new HashMap<>();

        long start = 1;
        List<Team> firstList = new ArrayList<>();
        Team firstTeam = teams.get(0);
        firstTeam.rank = 1;
        firstList.add(firstTeam);
        sublistsMap.put(start, firstList);
        Team prev = teams.get(0);

        for (int i = 1; i < teams.size(); i++) {

            Team current = teams.get(i);
            List<Team> sublist;
            if (prev.equals(current)) {
                sublist = sublistsMap.get(start);
            } else {
                start++;
                sublist = new ArrayList<>();
            }
            sublist.add(current);
            sublistsMap.put(start, sublist);
            prev = current;
        }
        return sublistsMap;
    }

    private static void calculateGame(int[] game, List<Team> teams) {
        Team t1 = teams.get(game[0]);
        Team t2 = teams.get(game[1]);

        int t1Scored = game[2];
        int t2Scored = game[3];

        t1.setConceded(t1.getConceded() + t2Scored);
        t2.setConceded(t2.getConceded() + t1Scored);

        t1.setScored(t1.getScored() + t1Scored);
        t2.setScored(t2.getScored() + t2Scored);

        if (t1Scored < t2Scored) {
            t2.setPoints(t2.getPoints() + 2);
        } else if (t1Scored == t2Scored) {
            t1.setPoints(t1.getPoints() + 1);
            t2.setPoints(t2.getPoints() + 1);
        } else {
            t1.setPoints(t1.getPoints() + 2);
        }

        teams.set(t1.teamNr, t1);
        teams.set(t2.teamNr, t2);
    }

    static class Team implements Comparable<Team> {

        int teamNr;
        int points;
        int scored;
        int conceded;
        int rank;

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getTeamNr() {
            return teamNr;
        }


        public Team(int teamNr) {
            this.teamNr = teamNr;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public int getScored() {
            return scored;
        }

        public void setScored(int scored) {
            this.scored = scored;
        }

        public int getConceded() {
            return conceded;
        }

        public void setConceded(int conceded) {
            this.conceded = conceded;
        }

        public int scoringDiff() {
            return scored - conceded;
        }

        @Override
        public int compareTo(Team o) {
            return Comparator.comparing(Team::getPoints)
                    .thenComparing(Team::scoringDiff)
                    .thenComparing(Team::getScored)
                    .compare(o, this);
        }

        @Override
        public String toString() {
            return "T " +
                    "nr=" + teamNr +
                    ", points=" + points +
                    ", scored=" + scored +
                    ", conceded=" + conceded +
                    " rank=" + rank;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Team team = (Team) o;
            return points == team.points && (scored - conceded) == (team.scored - team.conceded) && (
                    scored == team.scored);
        }

        @Override
        public int hashCode() {
            return Objects.hash(points, scored, conceded);
        }
    }
}
