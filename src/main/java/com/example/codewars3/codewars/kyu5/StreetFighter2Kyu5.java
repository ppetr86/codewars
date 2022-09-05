package com.example.codewars3.codewars.kyu5;
//codewars.com/kata/58583922c1d5b415b00000ff/solutions/java
// https://www.codewars.com/kata/58583922c1d5b415b00000ff/train/java

import java.util.Arrays;

public class StreetFighter2Kyu5 {

    public static void main(String[] args) {
        String[][] fighters = new String[][]{
                new String[]{"", "Ryu", "E.Honda", "Cammy", "Blanka", "Guile", "", "Chun Li"},
                new String[]{"Balrog", "Ken", "Chun Li", "", "M.Bison", "Zangief", "Dhalsim", "Sagat"},
                new String[]{"Vega", "", "Fei Long", "Balrog", "Deejay", "Cammy", "", "T.Hawk"},
        };

        String[] moves = new String[]{"down", "right", "right", "right", "down", "left", "left", "down", "right", "right", "right", "up"};
        System.out.println(Arrays.toString(superStreetFighterize(fighters, new int[]{0, 3}, moves)));
    }

    //rows,cols in the 2dArray || y x

    public static String[] superStreetFighterize(String[][] fighters, int[] position, String[] moves) {
        if (moves.length == 0) return new String[]{};
        String[] highlightedFighters = new String[moves.length];
        int horizontalLen = fighters[0].length;

        for (int i = 0; i < moves.length; i++) {
            String nextSelected = "";
            if (moves[i].equals("up")) {
                if (position[0] == 0) {
                    nextSelected = fighters[position[0]][position[1]];
                } else if (position[0] > 0) {
                    nextSelected = nextUpOrStop(position, fighters);
                }
            } else if (moves[i].equals("down")) {
                if (position[0] == fighters.length - 1) nextSelected = fighters[position[0]][position[1]];
                else if (position[0] < fighters.length - 1) {
                    nextSelected = nextDownOrStop(position, fighters);
                }
            } else if (moves[i].equals("left")) {

                int holderX = (position[1] + horizontalLen - 1) % horizontalLen;
                if (!fighters[position[0]][holderX].equals("")) {
                    position[1] = holderX;
                    nextSelected = fighters[position[0]][position[1]];
                }
                if (fighters[position[0]][holderX].equals("")) {
                    while (fighters[position[0]][holderX].equals("")) {
                        holderX = (holderX + horizontalLen - 1) % horizontalLen;
                    }
                    position[1] = holderX;
                    nextSelected = fighters[position[0]][holderX];
                }
            } else if (moves[i].equals("right")) {
                int holderX = (position[1] + 1) % horizontalLen;
                if (!fighters[position[0]][holderX].equals("")) {
                    position[1] = holderX;
                    nextSelected = fighters[position[0]][position[1]];
                }
                if (fighters[position[0]][holderX].equals("")) {
                    while (fighters[position[0]][holderX].equals("")) {
                        holderX = (holderX + 1) % horizontalLen;
                    }
                    position[1] = holderX;
                    nextSelected = fighters[position[0]][holderX];
                }
            }

            highlightedFighters[i] = nextSelected;
        }

        return highlightedFighters;
    }

    private static String nextDownOrStop(int[] position, String[][] fighters) {
        if (fighters[position[0] + 1][position[1]].equals(""))
            return fighters[position[0]][position[1]];
        position[0] += 1;
        return fighters[position[0]][position[1]];
    }

    private static String nextUpOrStop(int[] position, String[][] fighters) {
        if (fighters[position[0] - 1][position[1]].equals(""))
            return fighters[position[0]][position[1]];
        position[0] -= 1;
        return fighters[position[0]][position[1]];
    }
}
