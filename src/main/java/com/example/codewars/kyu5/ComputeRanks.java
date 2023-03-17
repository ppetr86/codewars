package com.example.codewars.kyu5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComputeRanks {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(computeRanks(6, new int[][]
                {{0, 5, 2, 2},
                        {1, 4, 0, 2},
                        {2, 3, 1, 2},
                        {1, 5, 2, 2},
                        {2, 0, 1, 1},
                        {3, 4, 1, 1},
                        {2, 5, 0, 2},
                        {3, 1, 1, 1},
                        {4, 0, 2, 0}})));
    }

    public static int[] computeRanks(int number, int[][] games) {

        if (games.length == 0) {
            return Arrays.stream(new int[number]).map(each -> each + 1).toArray();
        }

        List<TeamStats> statsList = createTeams(number);

        IntStream
                .range(0, games.length)
                .forEach(index -> addScoreForGame(statsList, games[index], games[index][0], games[index][1], games[index][2], games[index][3]));

        compareTeamResulsAndOrderTeams(statsList);
        setTeamRanks(statsList);
        System.out.println("\n" + statsList);
        return createFinalArray(statsList);
    }

    private static List<TeamStats> createTeams(int number) {
        return IntStream.range(0, number)
                .mapToObj(index -> new TeamStats(index))
                .collect(Collectors.toList())
                ;
    }

    private static int[] createFinalArray(List<TeamStats> statsList) {
        statsList.sort(Comparator.comparingInt(TeamStats::getTeamName));
        return statsList.stream().mapToInt(TeamStats::getRank).toArray();
    }

    private static void setTeamRanks(List<TeamStats> statsList) {
        // optimize this one
        for (int i = 0; i < statsList.size(); i++) {
            TeamStats team = statsList.get(i);
            TeamStats previous = new TeamStats();
            if (i > 0) previous = statsList.get(i - 1);
            if (teamsSameStats(team, previous)) {
                team.setRank(previous.getRank());
            } else {
                team.setRank(i + 1);
                if (i < statsList.size() - 1) {
                    TeamStats nextTeam = statsList.get(i + 1);
                    if (teamsSameStats(team, nextTeam)) {
                        nextTeam.setRank(i + 1);
                        i++;
                    }
                }
            }
        }
    }

    private static boolean teamsSameStats(TeamStats team, TeamStats nextTeam) {
        return team.getPoints() == nextTeam.getPoints() &&
                team.getBalance() == nextTeam.getBalance() &&
                team.getAgainstScore() == nextTeam.getAgainstScore();
    }

    private static void compareTeamResulsAndOrderTeams(List<TeamStats> statsList) {
        statsList.sort((o1, o2) -> {
            if (o1.points != o2.points) {
                return o2.points - o1.points;
            } else if (o1.balance != o2.balance) {
                return o2.balance - o1.balance;
            } else {
                return o2.againstScore - o1.againstScore;
            }
        });
    }

    private static void addScoreForGame(List<TeamStats> statsList, int[] currentGame,
                                        int firstTeam, int secondTeam, int scoredByFirst, int scoredBySecond) {

        TeamStats team1 = statsList.stream().filter(each -> each.getTeamName() == firstTeam).findFirst().orElse(null);
        TeamStats team2 = statsList.stream().filter(each -> each.getTeamName() == secondTeam).findFirst().orElse(null);

        int team1IndexInList = statsList.indexOf(team1);
        team1.setForScore(team1.getForScore() + currentGame[2]);
        team1.setAgainstScore(team1.getAgainstScore() + currentGame[3]);
        team1.setBalance(team1.getForScore() - team1.getAgainstScore());

        setTeamPoints(scoredByFirst, scoredBySecond, team1);
        statsList.set(team1IndexInList, team1);

        int team2IndexInList = statsList.indexOf(team2);
        team2.setForScore(currentGame[3] + team2.getForScore());
        team2.setAgainstScore(currentGame[2] + team2.getAgainstScore());
        team2.setBalance(team2.getForScore() - team2.getAgainstScore());

        setTeamPoints(scoredBySecond, scoredByFirst, team2);
        statsList.set(team2IndexInList, team2);
    }

    private static void setTeamPoints(int scoreFor, int scoreAgainst, TeamStats team) {
        if (scoreFor == scoreAgainst) {
            team.setPoints(team.getPoints() + 1);
        } else if (scoreFor > scoreAgainst) {
            team.setPoints(team.getPoints() + 2);
        }
    }

    public static class TeamStats {
        private int teamName;
        private int forScore = 0;
        private int againstScore = 0;
        private int balance = 0;
        private int points = 0;
        private int rank;

        public TeamStats() {
        }

        public TeamStats(int teamName) {
            this.teamName = teamName;
        }


        @Override
        public String toString() {
            return "teamName= " + teamName +
                    " ,forScore= " + forScore +
                    " ,againstScore= " + againstScore +
                    " ,balance= " + balance +
                    " ,points= " + points +
                    " ,rank " + rank + "\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TeamStats teamStats = (TeamStats) o;
            return teamName == teamStats.teamName;
        }

        @Override
        public int hashCode() {
            return Objects.hash(teamName);
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getTeamName() {
            return teamName;
        }

        public int getForScore() {
            return forScore;
        }

        public void setForScore(int forScore) {
            this.forScore = forScore;
        }

        public int getAgainstScore() {
            return againstScore;
        }

        public void setAgainstScore(int againstScore) {
            this.againstScore = againstScore;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }
}