package com.example.hackerRank.algosEasy;

import java.util.List;

//https://www.hackerrank.com/challenges/bon-appetit/problem?isFullScreen=true
public class BonApetit {

    public static void main(String[] args) {
        bonAppetit(List.of(2, 4, 6), 2, 3);
        bonAppetit(List.of(3, 10, 2, 9), 1, 12);
        //bill, item anna did not eat, amount of money anna paid
    }

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int sumMinusK = bill.stream().reduce(0, (first, sec) -> first + sec) - bill.get(k);
        int fairHalf = sumMinusK / 2;
        System.out.println(fairHalf >= b ? "Bon Appetit" : (b - fairHalf));
    }
}
