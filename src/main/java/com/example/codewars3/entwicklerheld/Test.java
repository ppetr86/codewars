package com.example.codewars3.entwicklerheld;

import java.util.Iterator;

public class Test {
    //https://www.innoq.com/de/blog/statemachine/
    public static void main(String[] args) {
        /*PolicyRequest pr = new PolicyRequest("INCOMPLETE", "DE80500105175408332501");
        System.out.println(pr.getLeadState());
        System.out.println(pr.getPossibleNextStates());
        System.out.println(pr.transitionState("NEW"));
        System.out.println();

        PolicyRequest pr2 = new PolicyRequest("NEW", "DE80500105175408332501");
        System.out.println(pr2.transitionState("IN_REVIEW"));
        System.out.println();

        PolicyRequest pr3 = new PolicyRequest("NEW", "DE80500105175408332501");
        System.out.println(pr3.transitionState("DUPLICATE_FAKE"));
        System.out.println();

        PolicyRequest pr4 = new PolicyRequest("NEW", "DE80500105175408332501");
        System.out.println(pr4.transitionState("ERROR"));
        System.out.println();

        PolicyRequest pr5 = new PolicyRequest("NEW", "DE80500105175408332501");
        System.out.println(pr5.transitionState("ERROR"));
        System.out.println();*/
       /* System.out.println(pr.isIbanValid("DE80500105175408332501"));
        System.out.println(pr.isIbanValid("DE02370100500001651503"));*/

        char[][] arr = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };

        /*char[][] arr = new char[][]{
                {'1', '1'},
                {'1', '1'},
                {'1', '1'}};*/

        NumberOfIslandsRefactored.Map mapParts = new NumberOfIslandsRefactored.Map(arr);

        Iterator<MapPart> iterator = mapParts.iterator();
        while (iterator.hasNext()) {
            MapPart next = iterator.next();
            //System.out.println(next.value);
        }

        char[][] arr2 = new char[][]{{}};
        //mapParts = new Map(null);

        iterator = mapParts.iterator();
        while (iterator.hasNext()) {
            MapPart next = iterator.next();
        }

        MapPart p = new MapPart(2, 2, '1');
        System.out.println(mapParts.getTopMapPart(p));

        /*MapPart p2 = new MapPart(3, 8, '1');
        System.out.println(mapParts.getRightMapPart(p2));

        MapPart p3 = new MapPart(3, 2, '1');
        System.out.println(mapParts.getLeftMapPart(p3));

        MapPart p4 = new MapPart(4, 0, '1');
        System.out.println(mapParts.getLeftMapPart(p4));

        MapPart p5 = new MapPart(4, 4, '1');
        System.out.println(mapParts.getRightMapPart(p5));*/
    }
}
