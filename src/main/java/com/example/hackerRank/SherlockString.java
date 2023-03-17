package com.example.hackerRank;

import java.util.Arrays;

public class SherlockString {
    public static void main(String[] args) {
        System.out.println(isValid("aaaabbcc"));
        /*ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd*/
        //should YES
        /*abcdefghhgfedecba*/ //SHOULD YES
        /*aaaabbcc*/  //SHOULD NO
    }

    static String isValid(String s) {

        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }

        int[] letters2 = Arrays.stream(letters).filter(each -> each > 0).toArray();
        int max = Arrays.stream(letters2).max().getAsInt();
        int min = Arrays.stream(letters2).min().getAsInt();
        int maxCount = (int) Arrays.stream(letters2).filter(each -> each == max).count();
        int minCount = (int) Arrays.stream(letters2).filter(each -> each == min).count();
        int dist = (int) Arrays.stream(letters2).distinct().count();
        System.out.println(Arrays.toString(letters2));
        System.out.println(max + " max");
        System.out.println(min + " min");
        System.out.println(maxCount + " maxcount");
        System.out.println(minCount + " mincount");
        System.out.println(dist + " dist");

        if (max == min) return "YES";//keep
        if (max - min == 1 && (maxCount == 1 || minCount == 1)) return "YES";
        if (dist < 3 && (maxCount == 1 || minCount == 1 && letters2.length < 3)) return "YES";

        return "NO";
    }
}

/*if (max-min >1) return "NO";
        if (max == min) return "YES";
        if (minCount == 1) return "YES";
        if (maxCount == 1) return "YES"*/;