package com.example.codewars3.codewars.kyu5;
//https://www.codewars.com/kata/5384df88aa6fc164bb000e7d/train/java
// aka last cake

public class Player {
    public Player(int cakes) {
    }

    // Decide who move first - player or opponent (true if player)
    public boolean firstMove(int cakes) {
        // I wish to move first
        return true;
    }

    // Decide your next move
    public int move(int cakes, int last) {
        // I'm not greedy
        return last == 1 ? 2 : 1;
    }
}
