package com.example.hackerRank;

public class CommonChild {

    public static void main(String[] args) {
        System.out.println(commonChild("SHINCHAN", "NOHARAAA"));
        //AWHYFCCMQX, OUDFRMYMAW
    }

    static int commonChild(String s1, String s2) {

        int result = recursiveCall(s1, s2);
        return result;
    }

    private static int recursiveCall(String s1, String s2) {

        return 0;
    }
}
