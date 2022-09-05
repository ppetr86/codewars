package com.example.codewars3.hackerRank;

import java.util.Comparator;

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        if (a.getScore() == b.getScore())
            return a.getName().compareTo(b.getName());
        else
            return b.getScore() - a.getScore();
    }
}

class Player {
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
