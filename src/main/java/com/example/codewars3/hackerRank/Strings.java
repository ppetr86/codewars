package com.example.codewars3.hackerRank;

import java.util.Arrays;

public class Strings {
    public static void main(String[] args) {
        System.out.println(repeatedString("aab", 882787));
        //epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq
        //549382313570
        //aab
        //882787 expected 588525
    }

    private static long repeatedString(String str, long l) {
        long result = 0;
        long inWord = Arrays.stream(str.split("")).filter(x -> x.equals("a")).count();
        result += l / str.length() * inWord;

        int modulo = (int) (l % str.length());
        if (modulo == 0) return result;

        long inSubString = Arrays.stream(str.substring(0, modulo).split("")).filter(x -> x.equals("a")).count();
        return inSubString + result;
    }
}
