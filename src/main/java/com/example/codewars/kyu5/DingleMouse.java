package com.example.codewars.kyu5;

public class DingleMouse {

    public static void main(String[] args) {
        char[][] house = {
                "#################             ".toCharArray(),
                "#     o         #   o         ".toCharArray(),
                "#          ######        o    ".toCharArray(),
                "####       #                  ".toCharArray(),
                "   #       ###################".toCharArray(),
                "   #                         #".toCharArray(),
                "   #                  X      #".toCharArray(),
                "   ###########################".toCharArray()
        };
        System.out.println(allAlone(house));
    }

    public static boolean allAlone(char[][] house) {
        boolean isHeAtHome = false;
        boolean isPotusHome = false;
        for (int i = 0; i < house.length; i++) {
            String str = new String(house[i]).replaceAll(" ", "");
            if (str.contains("#oX#")) return false;
            if (str.contains("#Xo#")) return false;
            if (str.contains("#X#")) isHeAtHome = true;
            if (str.contains("#o#")) isPotusHome = true;
        }
        if (!isHeAtHome) return false;
        if (isHeAtHome && isPotusHome) return false;
        return true;
    }
}
