package com.example.codewars.kyu6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NbaRanking {

    public static void main(String[] args) {
        String resultSheet1 = "Boston Celtics 112 Philadelphia 76ers 95,Los Angeles Clippers 104 Dallas Mavericks 88,New York Knicks 101 Atlanta Hawks 112,Indiana Pacers 103 Memphis Grizzlies 112,"
                + "Los Angeles Lakers 111 Minnesota Timberwolves 112,Phoenix Suns 95 Dallas Mavericks 111,Portland Trail Blazers 112 New Orleans Pelicans 94,"
                + "Sacramento Kings 104 Los Angeles Clippers 111,Houston Rockets 85 Denver Nuggets 105,Memphis Grizzlies 76 Cleveland Cavaliers 106,"
                + "Milwaukee Bucks 97 New York Knicks 122,Oklahoma City Thunder 112 San Antonio Spurs 106,"
                + "Brooklyn Nets 100 Chicago Bulls 115,Detroit Pistons 92 Utah Jazz 87,Miami Heat 104 Charlotte Hornets 94,"
                + "Toronto Raptors 106 Indiana Pacers 99,Orlando Magic 87 Washington Wizards 88,Golden State Warriors 111 New Orleans Pelicans 95,"
                + "Atlanta Hawks 94 Detroit Pistons 106,Chicago Bulls 97 Cleveland Cavaliers 95,";

        String teams = "Los Angeles Clippers,Dallas Mavericks,New York Knicks,NYK,Atlanta Hawks,Indiana Pacers,Memphis Grizzlies,"
                + "Los Angeles Lakers,Minnesota Timberwolves,Phoenix Suns,Portland Trail Blazers,New Orleans Pelicans,"
                + "Sacramento Kings,Los Angeles Clippers,Houston Rockets,Denver Nuggets,Cleveland Cavaliers,Milwaukee Bucks,"
                + "Oklahoma City Thunder,San Antonio Spurs,Boston Celtics,Philadelphia 76ers,Brooklyn Nets,Chicago Bulls,"
                + "Detroit Pistons,Utah Jazz,Miami Heat,Charlotte Hornets,Toronto Raptors,Orlando Magic,Washington Wizards,"
                + "Golden State Warriors,Dallas Maver";

        System.out.println(nbaCup(resultSheet1, teams));
    }

    public static String nbaCup(String resultSheet, String toFind) {
        Set<String> teamNames = new HashSet<>(Arrays.asList(toFind.split(",")));
        Set<Team> teamSet = teamNames.stream().map(Team::new).collect(Collectors.toSet());

        String[] matches = resultSheet.split(",");
        for (int i = 0; i < matches.length; i++) {

            String withoutNrs = matches[i].replaceAll("[0-9]", "");
            String leftName = findName(withoutNrs.substring(0, withoutNrs.indexOf("  ")), teamSet);
            String rightName = findName(withoutNrs.substring(withoutNrs.indexOf("  ")), teamSet);

            Team left = findTeam(teamSet, leftName);
            Team right = findTeam(teamSet, rightName);

            String scores = matches[i].replaceAll(left.name + " ", "").replaceAll(right.name, "");
            int scoredLeft = Integer.parseInt(scores.substring(0, scores.indexOf(" ")));
            int scoredRight = Integer.parseInt(scores.substring(scores.lastIndexOf(" ") + 1));

            left.conceded += scoredRight;
            right.conceded += scoredLeft;
            left.scored += scoredLeft;
            right.scored += scoredRight;

            if (scoredLeft > scoredRight) {
                left.points += 3;
            } else if (scoredLeft < scoredRight) {
                right.points += 3;
            } else {
                left.points += 1;
                right.points += 1;
            }
        }

        teamSet = teamSet.stream().map(NbaRanking::didNotPlay).collect(Collectors.toSet());

        return teamSet.stream().map(Team::toString).collect(Collectors.joining());
    }

    private static String findName(String substring, Set<Team> teamSet) {
        String changedSubString = substring.trim().stripLeading();
        if (changedSubString.equals("Philadelphia ers")) return "Philadelphia 76ers";
        String result = teamSet.stream().filter(x -> x.name.contains(changedSubString)).map(x -> x.name).collect(Collectors.joining());
        return result;
    }

    private static Team findTeam(Set<Team> teamSet, String name) {
        return teamSet.stream().filter(team -> team.name.equals(name)).findFirst().get();
    }

    private static Team didNotPlay(Team team) {
        if (team.scored == 0 && team.conceded == 0 && team.points == 0 && team.draws == 0) {
            team.name = team.name + ":This team didn't play!";
            return team;
        }
        return team;
    }

    static class Team {
        public String name;
        public int wins;
        public int draws;
        public int losses;
        public int scored;
        public int conceded;
        public int points;

        public Team() {
        }

        public Team(String name) {
            this.name = name;
        }

        public Team(String name, int wins, int draws, int losses, int scored, int conceded, int points) {
            this.name = name;
            this.wins = wins;
            this.draws = draws;
            this.losses = losses;
            this.scored = scored;
            this.conceded = conceded;
            this.points = points;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            if (this.name.contains("This team didn't play!")) {
                return this.name;
            }

            result.append(name).append(":W=").append(wins)
                    .append(":main.java.D=").append(draws).append(";L=")
                    .append(losses).append(";Scored").append(scored)
                    .append(";Conceded=").append(conceded).append(";Points=").append(points);
            return result.toString();
        }
    }
}
