package com.example.codewars.kyu6;

import java.util.Arrays;

public class StreetFighter2 {

    public static void main(String[] args) {
        String[][] fighters = new String[][]{
                new String[]{"Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"},
                new String[]{"Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"},
        };

        String[] moves = new String[]{"up", "left", "right", "left", "left"};
        System.out.println(Arrays.toString(streetFighterSelection(fighters, new int[]{0, 0}, moves)));
    }

    public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {
        String[] highlightedFighters = new String[moves.length];

        for (int i = 0; i < moves.length; i++) {
            String nexSelected = defineHighlighted(position, moves, i, fighters);
            if (nexSelected.equals("")) continue;
            highlightedFighters[i] = nexSelected;
        }

        return highlightedFighters;
    }

    private static String defineHighlighted(int[] position, String[] moves, int i, String[][] fighters) {
        if (moves[i].equals("up")) {
            position[0] = 0;
            return fighters[position[0]][position[1]];
        } else if (moves[i].equals("down")) {
            position[0] = 1;
            return fighters[position[0]][position[1]];
        } else if (moves[i].equals("left")) {
            if (position[1] == 0) {
                position[1] = fighters[0].length - 1;
                return fighters[position[0]][position[1]];
            }
            if (position[1] > 0) position[1] -= 1;
            return fighters[position[0]][position[1]];
        } else if (moves[i].equals("right")) {
            if (position[1] == fighters[0].length - 1) {
                position[1] = 0;
                return fighters[position[0]][position[1]];
            }
            if (position[1] < fighters[0].length - 1) position[1] += 1;
            return fighters[position[0]][position[1]];
        }
        return "";
    }
}
