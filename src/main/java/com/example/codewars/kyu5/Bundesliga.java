package com.example.codewars.kyu5;//https://www.codewars.com/kata/57c178e16662d0d932000120/train/java

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Bundesliga {

    public static void main(String[] args) {
        System.out.println(table(new String[]
                {
                        "6:0 FC Bayern Muenchen - Werder Bremen",
                        "1:0 Eintracht Frankfurt - Schalke 04",
                        "0:2 FC Augsburg - VfL Wolfsburg",
                        "1:1 Hamburger SV - FC Ingolstadt",
                        "2:0 1. FC Koeln - SV Darmstadt",
                        "2:1 Borussia Dortmund - FSV Mainz 05",
                        "2:1 Borussia Moenchengladbach - Bayer Leverkusen",
                        "2:1 Hertha BSC Berlin - SC Freiburg",
                        "2:2 TSG 1899 Hoffenheim - RasenBall Leipzig"
                }));
    }

    public static String table(String[] results) {
        Set<Team> teamSet = new HashSet<>();

        for (String match : results) {
            teamSet.add(new Team(match.substring(match.indexOf(" ") + 1, match.indexOf(" - "))));
            teamSet.add(new Team(match.substring(match.lastIndexOf(" - ") + 3)));
        }


        for (int i = 0; i < results.length; i++) {
            String match = results[i];

            Team team1 = findTeamByName(match.substring(match.indexOf(" ") + 1, match.indexOf(" - ")), teamSet);
            Team team2 = findTeamByName(match.substring(match.lastIndexOf(" - ") + 3), teamSet);

            int scored1, scored2;
            if (match.charAt(0) == '-') {
                continue;
            } else {
                scored1 = Integer.parseInt(match.substring(0, match.indexOf(":")));
                scored2 = Integer.parseInt(match.substring(match.indexOf(":") + 1, match.indexOf(" ")));
            }

            team1.setScored(scored1);
            team2.setScored(scored2);

            team1.setGotten(scored2);
            team2.setGotten(scored1);

            team1.setPlayedMatches(team1.getPlayedMatches() + 1);
            team2.setPlayedMatches(team2.getPlayedMatches() + 1);

            if (scored1 > scored2) {
                team1.setWonMatches(team1.getWonMatches() + 1);
                team2.setLostMatches(team2.getLostMatches() + 1);
                team1.setPoints(team1.getPoints() + 3);
            } else if (scored1 < scored2) {
                team2.setWonMatches(team2.getWonMatches() + 1);
                team1.setLostMatches(team1.getLostMatches() + 1);
                team2.setPoints(team2.getPoints() + 3);
            } else {
                team1.setTieMatches(team1.getTieMatches() + 1);
                team2.setTieMatches(team2.getTieMatches() + 1);
                team2.setPoints(team2.getPoints() + 1);
                team1.setPoints(team1.getPoints() + 1);
            }
        }

        List<Team> teamList = new ArrayList<>(teamSet);
        compareResultsAndOrderTeams(teamList);
        assignRanking(teamList);

        StringBuilder result = new StringBuilder();

        for (Team team : teamList) {
            int ranking = team.getRanking();

            if (ranking <= 9) {
                result.append(" ").append(ranking).append(". ").append(team).append("\n");
            } else {
                result.append(ranking).append(". ").append(team).append("\n");
            }
        }

        return result.substring(0, result.lastIndexOf("\n"));
    }

    private static void assignRanking(List<Team> teamList) {

        teamList.get(0).setRanking(1);

        for (int i = 1; i < teamList.size(); i++) {
            Team current = teamList.get(i);
            Team previous = teamList.get(i - 1);

            if (current.getPoints() == previous.getPoints() &&
                    current.getScored() == previous.getScored() &&
                    current.getGotten() == previous.getGotten()) {
                current.setRanking(previous.getRanking());
            } else {
                current.setRanking(i + 1);
            }
        }
    }

    private static void compareResultsAndOrderTeams(List<Team> teamList) {
        teamList.sort((o1, o2) -> {
            if (o1.getPoints() != o2.getPoints()) {
                return o2.getPoints() - o1.getPoints();
            } else if (o1.plusMinus() != o2.plusMinus()) {
                return o2.plusMinus() - o1.plusMinus();
            } else if (o1.getScored() != o2.getScored()) {
                return o2.getScored() - o1.getScored();
            } else {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }

    private static Team findTeamByName(String input, Set<Team> teamList) {
        return teamList.stream().filter(team -> team.getName().equals(input)).findFirst().orElse(null);
    }

    static class Team {
        private int ranking;
        private String name;
        private int playedMatches;
        private int wonMatches;
        private int tieMatches;
        private int lostMatches;
        private int scored;
        private int gotten;
        private int points;

        public Team(String name) {
            this.name = name;
        }

        public int plusMinus() {
            return this.getScored() - this.getGotten();
        }

        public int getRanking() {
            return ranking;
        }

        public void setRanking(int ranking) {
            this.ranking = ranking;
        }

        public String getName() {
            return name;
        }

        public int getPlayedMatches() {
            return playedMatches;
        }

        public void setPlayedMatches(int playedMatches) {
            this.playedMatches = playedMatches;
        }

        public int getWonMatches() {
            return wonMatches;
        }

        public void setWonMatches(int wonMatches) {
            this.wonMatches = wonMatches;
        }

        public int getTieMatches() {
            return tieMatches;
        }

        public void setTieMatches(int tieMatches) {
            this.tieMatches = tieMatches;
        }

        public int getLostMatches() {
            return lostMatches;
        }

        public void setLostMatches(int lostMatches) {
            this.lostMatches = lostMatches;
        }

        public int getScored() {
            return scored;
        }

        public void setScored(int scored) {
            this.scored = scored;
        }

        public int getGotten() {
            return gotten;
        }

        public void setGotten(int gotten) {
            this.gotten = gotten;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Team team = (Team) o;
            return Objects.equals(name, team.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {

            String replaceName = name;
            if (replaceName.length() < 30) replaceName = replaceName + "                              ";
            if (replaceName.length() > 30) replaceName = replaceName.substring(0, 30);

            return replaceName +
                    playedMatches + "  " +
                    wonMatches + "  " +
                    tieMatches + "  " +
                    lostMatches + "  " +
                    scored + ":" + gotten + "  " +
                    points;
        }
    }
}