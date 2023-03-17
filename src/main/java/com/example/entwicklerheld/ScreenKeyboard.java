package com.example.entwicklerheld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class ScreenKeyboard {

    static class KeyboardGraph {
        public static final List<List> graph = new ArrayList<>();

        static {
            // ** LOWER PATHS **
            //1
            graph.add(Arrays.asList(Keyboards.lower[0][0], Keyboards.lower[0][1]));
            graph.add(Arrays.asList(Keyboards.lower[0][0], Keyboards.lower[1][0]));
            graph.add(Arrays.asList(Keyboards.lower[0][0], Keyboards.lower[0][10]));
            graph.add(Arrays.asList(Keyboards.lower[0][0], Keyboards.lower[5][0]));

            //2
            graph.add(Arrays.asList(Keyboards.lower[0][1], Keyboards.lower[0][2]));
            graph.add(Arrays.asList(Keyboards.lower[0][1], Keyboards.lower[1][1]));
            graph.add(Arrays.asList(Keyboards.lower[0][1], Keyboards.lower[0][0]));
            graph.add(Arrays.asList(Keyboards.lower[0][1], Keyboards.lower[5][1]));

            //3
            graph.add(Arrays.asList(Keyboards.lower[0][2], Keyboards.lower[0][3]));
            graph.add(Arrays.asList(Keyboards.lower[0][2], Keyboards.lower[1][2]));
            graph.add(Arrays.asList(Keyboards.lower[0][2], Keyboards.lower[0][1]));
            graph.add(Arrays.asList(Keyboards.lower[0][2], Keyboards.lower[5][2]));

            //4
            graph.add(Arrays.asList(Keyboards.lower[0][3], Keyboards.lower[0][4]));
            graph.add(Arrays.asList(Keyboards.lower[0][3], Keyboards.lower[1][3]));
            graph.add(Arrays.asList(Keyboards.lower[0][3], Keyboards.lower[0][2]));
            graph.add(Arrays.asList(Keyboards.lower[0][3], Keyboards.lower[5][3]));

            //5
            graph.add(Arrays.asList(Keyboards.lower[0][4], Keyboards.lower[0][5]));
            graph.add(Arrays.asList(Keyboards.lower[0][4], Keyboards.lower[1][4]));
            graph.add(Arrays.asList(Keyboards.lower[0][4], Keyboards.lower[0][3]));
            graph.add(Arrays.asList(Keyboards.lower[0][4], Keyboards.lower[5][4]));

            //6
            graph.add(Arrays.asList(Keyboards.lower[0][5], Keyboards.lower[0][6]));
            graph.add(Arrays.asList(Keyboards.lower[0][5], Keyboards.lower[1][5]));
            graph.add(Arrays.asList(Keyboards.lower[0][5], Keyboards.lower[0][4]));
            graph.add(Arrays.asList(Keyboards.lower[0][5], Keyboards.lower[5][5]));

            //7
            graph.add(Arrays.asList(Keyboards.lower[0][6], Keyboards.lower[0][7]));
            graph.add(Arrays.asList(Keyboards.lower[0][6], Keyboards.lower[1][6]));
            graph.add(Arrays.asList(Keyboards.lower[0][6], Keyboards.lower[0][5]));
            graph.add(Arrays.asList(Keyboards.lower[0][6], Keyboards.lower[5][6]));

            //8
            graph.add(Arrays.asList(Keyboards.lower[0][7], Keyboards.lower[0][8]));
            graph.add(Arrays.asList(Keyboards.lower[0][7], Keyboards.lower[1][7]));
            graph.add(Arrays.asList(Keyboards.lower[0][7], Keyboards.lower[0][6]));
            graph.add(Arrays.asList(Keyboards.lower[0][7], Keyboards.lower[5][7]));

            //9
            graph.add(Arrays.asList(Keyboards.lower[0][8], Keyboards.lower[0][9]));
            graph.add(Arrays.asList(Keyboards.lower[0][8], Keyboards.lower[1][8]));
            graph.add(Arrays.asList(Keyboards.lower[0][8], Keyboards.lower[0][7]));
            graph.add(Arrays.asList(Keyboards.lower[0][8], Keyboards.lower[5][8]));

            //0
            graph.add(Arrays.asList(Keyboards.lower[0][9], Keyboards.lower[0][10]));
            graph.add(Arrays.asList(Keyboards.lower[0][9], Keyboards.lower[1][9]));
            graph.add(Arrays.asList(Keyboards.lower[0][9], Keyboards.lower[0][8]));
            graph.add(Arrays.asList(Keyboards.lower[0][9], Keyboards.lower[5][9]));

            //ß
            graph.add(Arrays.asList(Keyboards.lower[0][10], Keyboards.lower[0][0]));
            graph.add(Arrays.asList(Keyboards.lower[0][10], Keyboards.lower[1][10]));
            graph.add(Arrays.asList(Keyboards.lower[0][10], Keyboards.lower[0][9]));
            graph.add(Arrays.asList(Keyboards.lower[0][10], Keyboards.lower[5][10]));

            //q
            graph.add(Arrays.asList(Keyboards.lower[1][0], Keyboards.lower[1][1]));
            graph.add(Arrays.asList(Keyboards.lower[1][0], Keyboards.lower[2][0]));
            graph.add(Arrays.asList(Keyboards.lower[1][0], Keyboards.lower[1][10]));
            graph.add(Arrays.asList(Keyboards.lower[1][0], Keyboards.lower[0][0]));

            //w
            graph.add(Arrays.asList(Keyboards.lower[1][1], Keyboards.lower[1][2]));
            graph.add(Arrays.asList(Keyboards.lower[1][1], Keyboards.lower[2][1]));
            graph.add(Arrays.asList(Keyboards.lower[1][1], Keyboards.lower[1][0]));
            graph.add(Arrays.asList(Keyboards.lower[1][1], Keyboards.lower[0][1]));

            //e
            graph.add(Arrays.asList(Keyboards.lower[1][2], Keyboards.lower[1][3]));
            graph.add(Arrays.asList(Keyboards.lower[1][2], Keyboards.lower[2][2]));
            graph.add(Arrays.asList(Keyboards.lower[1][2], Keyboards.lower[1][1]));
            graph.add(Arrays.asList(Keyboards.lower[1][2], Keyboards.lower[0][2]));

            //r
            graph.add(Arrays.asList(Keyboards.lower[1][3], Keyboards.lower[1][4]));
            graph.add(Arrays.asList(Keyboards.lower[1][3], Keyboards.lower[2][3]));
            graph.add(Arrays.asList(Keyboards.lower[1][3], Keyboards.lower[1][2]));
            graph.add(Arrays.asList(Keyboards.lower[1][3], Keyboards.lower[0][3]));

            //t
            graph.add(Arrays.asList(Keyboards.lower[1][4], Keyboards.lower[1][5]));
            graph.add(Arrays.asList(Keyboards.lower[1][4], Keyboards.lower[2][4]));
            graph.add(Arrays.asList(Keyboards.lower[1][4], Keyboards.lower[1][3]));
            graph.add(Arrays.asList(Keyboards.lower[1][4], Keyboards.lower[0][4]));

            //z
            graph.add(Arrays.asList(Keyboards.lower[1][5], Keyboards.lower[1][6]));
            graph.add(Arrays.asList(Keyboards.lower[1][5], Keyboards.lower[2][5]));
            graph.add(Arrays.asList(Keyboards.lower[1][5], Keyboards.lower[1][4]));
            graph.add(Arrays.asList(Keyboards.lower[1][5], Keyboards.lower[0][5]));

            //u
            graph.add(Arrays.asList(Keyboards.lower[1][6], Keyboards.lower[1][7]));
            graph.add(Arrays.asList(Keyboards.lower[1][6], Keyboards.lower[2][6]));
            graph.add(Arrays.asList(Keyboards.lower[1][6], Keyboards.lower[1][5]));
            graph.add(Arrays.asList(Keyboards.lower[1][6], Keyboards.lower[0][6]));

            //i
            graph.add(Arrays.asList(Keyboards.lower[1][7], Keyboards.lower[1][8]));
            graph.add(Arrays.asList(Keyboards.lower[1][7], Keyboards.lower[2][7]));
            graph.add(Arrays.asList(Keyboards.lower[1][7], Keyboards.lower[1][6]));
            graph.add(Arrays.asList(Keyboards.lower[1][7], Keyboards.lower[0][7]));

            //o
            graph.add(Arrays.asList(Keyboards.lower[1][8], Keyboards.lower[1][9]));
            graph.add(Arrays.asList(Keyboards.lower[1][8], Keyboards.lower[2][8]));
            graph.add(Arrays.asList(Keyboards.lower[1][8], Keyboards.lower[1][7]));
            graph.add(Arrays.asList(Keyboards.lower[1][8], Keyboards.lower[0][8]));

            //p
            graph.add(Arrays.asList(Keyboards.lower[1][9], Keyboards.lower[1][10]));
            graph.add(Arrays.asList(Keyboards.lower[1][9], Keyboards.lower[2][9]));
            graph.add(Arrays.asList(Keyboards.lower[1][9], Keyboards.lower[1][8]));
            graph.add(Arrays.asList(Keyboards.lower[1][9], Keyboards.lower[0][9]));

            //ü
            graph.add(Arrays.asList(Keyboards.lower[1][10], Keyboards.lower[1][0]));
            graph.add(Arrays.asList(Keyboards.lower[1][10], Keyboards.lower[2][10]));
            graph.add(Arrays.asList(Keyboards.lower[1][10], Keyboards.lower[1][9]));
            graph.add(Arrays.asList(Keyboards.lower[1][10], Keyboards.lower[0][10]));

            //a
            graph.add(Arrays.asList(Keyboards.lower[2][0], Keyboards.lower[2][1]));
            graph.add(Arrays.asList(Keyboards.lower[2][0], Keyboards.lower[3][0]));
            graph.add(Arrays.asList(Keyboards.lower[2][0], Keyboards.lower[2][10]));
            graph.add(Arrays.asList(Keyboards.lower[2][0], Keyboards.lower[1][0]));

            //s
            graph.add(Arrays.asList(Keyboards.lower[2][1], Keyboards.lower[2][2]));
            graph.add(Arrays.asList(Keyboards.lower[2][1], Keyboards.lower[3][1]));
            graph.add(Arrays.asList(Keyboards.lower[2][1], Keyboards.lower[2][0]));
            graph.add(Arrays.asList(Keyboards.lower[2][1], Keyboards.lower[1][1]));

            //d
            graph.add(Arrays.asList(Keyboards.lower[2][2], Keyboards.lower[2][3]));
            graph.add(Arrays.asList(Keyboards.lower[2][2], Keyboards.lower[3][2]));
            graph.add(Arrays.asList(Keyboards.lower[2][2], Keyboards.lower[2][1]));
            graph.add(Arrays.asList(Keyboards.lower[2][2], Keyboards.lower[1][2]));

            //f
            graph.add(Arrays.asList(Keyboards.lower[2][3], Keyboards.lower[2][4]));
            graph.add(Arrays.asList(Keyboards.lower[2][3], Keyboards.lower[3][3]));
            graph.add(Arrays.asList(Keyboards.lower[2][3], Keyboards.lower[2][2]));
            graph.add(Arrays.asList(Keyboards.lower[2][3], Keyboards.lower[1][3]));

            //g
            graph.add(Arrays.asList(Keyboards.lower[2][4], Keyboards.lower[2][5]));
            graph.add(Arrays.asList(Keyboards.lower[2][4], Keyboards.lower[3][4]));
            graph.add(Arrays.asList(Keyboards.lower[2][4], Keyboards.lower[2][3]));
            graph.add(Arrays.asList(Keyboards.lower[2][4], Keyboards.lower[1][4]));

            //h
            graph.add(Arrays.asList(Keyboards.lower[2][5], Keyboards.lower[2][6]));
            graph.add(Arrays.asList(Keyboards.lower[2][5], Keyboards.lower[3][5]));
            graph.add(Arrays.asList(Keyboards.lower[2][5], Keyboards.lower[2][4]));
            graph.add(Arrays.asList(Keyboards.lower[2][5], Keyboards.lower[1][5]));

            //j
            graph.add(Arrays.asList(Keyboards.lower[2][6], Keyboards.lower[2][7]));
            graph.add(Arrays.asList(Keyboards.lower[2][6], Keyboards.lower[3][6]));
            graph.add(Arrays.asList(Keyboards.lower[2][6], Keyboards.lower[2][5]));
            graph.add(Arrays.asList(Keyboards.lower[2][6], Keyboards.lower[1][6]));

            //k
            graph.add(Arrays.asList(Keyboards.lower[2][7], Keyboards.lower[2][8]));
            graph.add(Arrays.asList(Keyboards.lower[2][7], Keyboards.lower[3][7]));
            graph.add(Arrays.asList(Keyboards.lower[2][7], Keyboards.lower[2][6]));
            graph.add(Arrays.asList(Keyboards.lower[2][7], Keyboards.lower[1][7]));

            //l
            graph.add(Arrays.asList(Keyboards.lower[2][8], Keyboards.lower[2][9]));
            graph.add(Arrays.asList(Keyboards.lower[2][8], Keyboards.lower[3][8]));
            graph.add(Arrays.asList(Keyboards.lower[2][8], Keyboards.lower[2][7]));
            graph.add(Arrays.asList(Keyboards.lower[2][8], Keyboards.lower[1][8]));

            //ö
            graph.add(Arrays.asList(Keyboards.lower[2][9], Keyboards.lower[2][10]));
            graph.add(Arrays.asList(Keyboards.lower[2][9], Keyboards.lower[3][9]));
            graph.add(Arrays.asList(Keyboards.lower[2][9], Keyboards.lower[2][8]));
            graph.add(Arrays.asList(Keyboards.lower[2][9], Keyboards.lower[1][9]));

            //ä
            graph.add(Arrays.asList(Keyboards.lower[2][10], Keyboards.lower[2][0]));
            graph.add(Arrays.asList(Keyboards.lower[2][10], Keyboards.lower[3][10]));
            graph.add(Arrays.asList(Keyboards.lower[2][10], Keyboards.lower[2][9]));
            graph.add(Arrays.asList(Keyboards.lower[2][10], Keyboards.lower[1][10]));

            //shift
            graph.add(Arrays.asList(Keyboards.lower[3][0], Keyboards.upper[3][2]));
            graph.add(Arrays.asList(Keyboards.lower[3][0], Keyboards.upper[4][0]));
            graph.add(Arrays.asList(Keyboards.lower[3][0], Keyboards.upper[3][10]));
            graph.add(Arrays.asList(Keyboards.lower[3][0], Keyboards.upper[2][0]));

            graph.add(Arrays.asList(Keyboards.lower[3][1], Keyboards.upper[3][2]));
            graph.add(Arrays.asList(Keyboards.lower[3][1], Keyboards.upper[4][1]));
            graph.add(Arrays.asList(Keyboards.lower[3][1], Keyboards.upper[3][10]));
            graph.add(Arrays.asList(Keyboards.lower[3][1], Keyboards.upper[2][1]));

            graph.add(Arrays.asList(Keyboards.lower[3][0], Keyboards.lower[3][2]));
            graph.add(Arrays.asList(Keyboards.lower[3][0], Keyboards.lower[4][0]));
            graph.add(Arrays.asList(Keyboards.lower[3][0], Keyboards.lower[3][10]));
            graph.add(Arrays.asList(Keyboards.lower[3][0], Keyboards.lower[2][0]));

            graph.add(Arrays.asList(Keyboards.lower[3][1], Keyboards.lower[3][2]));
            graph.add(Arrays.asList(Keyboards.lower[3][1], Keyboards.lower[4][1]));
            graph.add(Arrays.asList(Keyboards.lower[3][1], Keyboards.lower[3][10]));
            graph.add(Arrays.asList(Keyboards.lower[3][1], Keyboards.lower[2][1]));

            //y
            graph.add(Arrays.asList(Keyboards.lower[3][2], Keyboards.lower[3][3]));
            graph.add(Arrays.asList(Keyboards.lower[3][2], Keyboards.lower[4][2]));
            graph.add(Arrays.asList(Keyboards.lower[3][2], Keyboards.lower[3][0]));
            graph.add(Arrays.asList(Keyboards.lower[3][2], Keyboards.lower[2][2]));

            //x
            graph.add(Arrays.asList(Keyboards.lower[3][3], Keyboards.lower[3][4]));
            graph.add(Arrays.asList(Keyboards.lower[3][3], Keyboards.lower[4][3]));
            graph.add(Arrays.asList(Keyboards.lower[3][3], Keyboards.lower[3][2]));
            graph.add(Arrays.asList(Keyboards.lower[3][3], Keyboards.lower[2][3]));

            //c
            graph.add(Arrays.asList(Keyboards.lower[3][4], Keyboards.lower[3][5]));
            graph.add(Arrays.asList(Keyboards.lower[3][4], Keyboards.lower[4][4]));
            graph.add(Arrays.asList(Keyboards.lower[3][4], Keyboards.lower[3][3]));
            graph.add(Arrays.asList(Keyboards.lower[3][4], Keyboards.lower[2][4]));

            //v
            graph.add(Arrays.asList(Keyboards.lower[3][5], Keyboards.lower[3][6]));
            graph.add(Arrays.asList(Keyboards.lower[3][5], Keyboards.lower[4][5]));
            graph.add(Arrays.asList(Keyboards.lower[3][5], Keyboards.lower[3][4]));
            graph.add(Arrays.asList(Keyboards.lower[3][5], Keyboards.lower[2][5]));

            //b
            graph.add(Arrays.asList(Keyboards.lower[3][6], Keyboards.lower[3][7]));
            graph.add(Arrays.asList(Keyboards.lower[3][6], Keyboards.lower[4][6]));
            graph.add(Arrays.asList(Keyboards.lower[3][6], Keyboards.lower[3][5]));
            graph.add(Arrays.asList(Keyboards.lower[3][6], Keyboards.lower[2][6]));

            //n
            graph.add(Arrays.asList(Keyboards.lower[3][7], Keyboards.lower[3][8]));
            graph.add(Arrays.asList(Keyboards.lower[3][7], Keyboards.lower[4][7]));
            graph.add(Arrays.asList(Keyboards.lower[3][7], Keyboards.lower[3][6]));
            graph.add(Arrays.asList(Keyboards.lower[3][7], Keyboards.lower[2][7]));

            //m
            graph.add(Arrays.asList(Keyboards.lower[3][8], Keyboards.lower[3][9]));
            graph.add(Arrays.asList(Keyboards.lower[3][8], Keyboards.lower[4][8]));
            graph.add(Arrays.asList(Keyboards.lower[3][8], Keyboards.lower[3][7]));
            graph.add(Arrays.asList(Keyboards.lower[3][8], Keyboards.lower[2][8]));

            //-
            graph.add(Arrays.asList(Keyboards.lower[3][9], Keyboards.lower[3][10]));
            graph.add(Arrays.asList(Keyboards.lower[3][9], Keyboards.lower[4][9]));
            graph.add(Arrays.asList(Keyboards.lower[3][9], Keyboards.lower[3][8]));
            graph.add(Arrays.asList(Keyboards.lower[3][9], Keyboards.lower[2][9]));

            //'
            graph.add(Arrays.asList(Keyboards.lower[3][10], Keyboards.lower[3][0]));
            graph.add(Arrays.asList(Keyboards.lower[3][10], Keyboards.lower[4][10]));
            graph.add(Arrays.asList(Keyboards.lower[3][10], Keyboards.lower[3][9]));
            graph.add(Arrays.asList(Keyboards.lower[3][10], Keyboards.lower[2][10]));

            //!#$
            graph.add(Arrays.asList(Keyboards.lower[4][0], Keyboards.lower[4][2]));
            graph.add(Arrays.asList(Keyboards.lower[4][0], Keyboards.lower[5][0]));
            graph.add(Arrays.asList(Keyboards.lower[4][0], Keyboards.lower[4][8]));
            graph.add(Arrays.asList(Keyboards.lower[4][0], Keyboards.lower[3][0]));

            graph.add(Arrays.asList(Keyboards.lower[4][1], Keyboards.lower[4][2]));
            graph.add(Arrays.asList(Keyboards.lower[4][1], Keyboards.lower[5][1]));
            graph.add(Arrays.asList(Keyboards.lower[4][1], Keyboards.lower[4][8]));
            graph.add(Arrays.asList(Keyboards.lower[4][1], Keyboards.lower[3][0]));

            //àáâ
            graph.add(Arrays.asList(Keyboards.lower[4][2], Keyboards.lower[4][4]));
            graph.add(Arrays.asList(Keyboards.lower[4][2], Keyboards.lower[5][2]));
            graph.add(Arrays.asList(Keyboards.lower[4][2], Keyboards.lower[4][0]));
            graph.add(Arrays.asList(Keyboards.lower[4][2], Keyboards.lower[3][2]));

            graph.add(Arrays.asList(Keyboards.lower[4][3], Keyboards.lower[4][4]));
            graph.add(Arrays.asList(Keyboards.lower[4][3], Keyboards.lower[5][3]));
            graph.add(Arrays.asList(Keyboards.lower[4][3], Keyboards.lower[4][0]));
            graph.add(Arrays.asList(Keyboards.lower[4][3], Keyboards.lower[3][3]));

            //space
            graph.add(Arrays.asList(Keyboards.lower[4][4], Keyboards.lower[4][8]));
            graph.add(Arrays.asList(Keyboards.lower[4][4], Keyboards.lower[5][4]));
            graph.add(Arrays.asList(Keyboards.lower[4][4], Keyboards.lower[4][2]));
            graph.add(Arrays.asList(Keyboards.lower[4][4], Keyboards.lower[3][4]));

            graph.add(Arrays.asList(Keyboards.lower[4][5], Keyboards.lower[4][8]));
            graph.add(Arrays.asList(Keyboards.lower[4][5], Keyboards.lower[5][5]));
            graph.add(Arrays.asList(Keyboards.lower[4][5], Keyboards.lower[4][2]));
            graph.add(Arrays.asList(Keyboards.lower[4][5], Keyboards.lower[3][5]));

            graph.add(Arrays.asList(Keyboards.lower[4][6], Keyboards.lower[4][8]));
            graph.add(Arrays.asList(Keyboards.lower[4][6], Keyboards.lower[5][6]));
            graph.add(Arrays.asList(Keyboards.lower[4][6], Keyboards.lower[4][2]));
            graph.add(Arrays.asList(Keyboards.lower[4][6], Keyboards.lower[3][6]));

            graph.add(Arrays.asList(Keyboards.lower[4][7], Keyboards.lower[4][8]));
            graph.add(Arrays.asList(Keyboards.lower[4][7], Keyboards.lower[5][7]));
            graph.add(Arrays.asList(Keyboards.lower[4][7], Keyboards.lower[4][2]));
            graph.add(Arrays.asList(Keyboards.lower[4][7], Keyboards.lower[3][7]));

            //delete
            graph.add(Arrays.asList(Keyboards.lower[4][8], Keyboards.lower[4][0]));
            graph.add(Arrays.asList(Keyboards.lower[4][8], Keyboards.lower[5][8]));
            graph.add(Arrays.asList(Keyboards.lower[4][8], Keyboards.lower[4][4]));
            graph.add(Arrays.asList(Keyboards.lower[4][8], Keyboards.lower[3][8]));

            graph.add(Arrays.asList(Keyboards.lower[4][9], Keyboards.lower[4][0]));
            graph.add(Arrays.asList(Keyboards.lower[4][9], Keyboards.lower[5][9]));
            graph.add(Arrays.asList(Keyboards.lower[4][9], Keyboards.lower[4][4]));
            graph.add(Arrays.asList(Keyboards.lower[4][9], Keyboards.lower[3][9]));

            graph.add(Arrays.asList(Keyboards.lower[4][10], Keyboards.lower[4][0]));
            graph.add(Arrays.asList(Keyboards.lower[4][10], Keyboards.lower[5][10]));
            graph.add(Arrays.asList(Keyboards.lower[4][10], Keyboards.lower[4][4]));
            graph.add(Arrays.asList(Keyboards.lower[4][10], Keyboards.lower[3][10]));

            //Abbrechen
            graph.add(Arrays.asList(Keyboards.lower[5][0], Keyboards.lower[5][5]));
            graph.add(Arrays.asList(Keyboards.lower[5][0], Keyboards.lower[0][0]));
            graph.add(Arrays.asList(Keyboards.lower[5][0], Keyboards.lower[5][5]));
            graph.add(Arrays.asList(Keyboards.lower[5][0], Keyboards.lower[4][0]));

            graph.add(Arrays.asList(Keyboards.lower[5][1], Keyboards.lower[5][5]));
            graph.add(Arrays.asList(Keyboards.lower[5][1], Keyboards.lower[0][1]));
            graph.add(Arrays.asList(Keyboards.lower[5][1], Keyboards.lower[5][5]));
            graph.add(Arrays.asList(Keyboards.lower[5][1], Keyboards.lower[4][1]));

            graph.add(Arrays.asList(Keyboards.lower[5][2], Keyboards.lower[5][5]));
            graph.add(Arrays.asList(Keyboards.lower[5][2], Keyboards.lower[0][2]));
            graph.add(Arrays.asList(Keyboards.lower[5][2], Keyboards.lower[5][5]));
            graph.add(Arrays.asList(Keyboards.lower[5][2], Keyboards.lower[4][2]));

            graph.add(Arrays.asList(Keyboards.lower[5][3], Keyboards.lower[5][5]));
            graph.add(Arrays.asList(Keyboards.lower[5][3], Keyboards.lower[0][3]));
            graph.add(Arrays.asList(Keyboards.lower[5][3], Keyboards.lower[5][5]));
            graph.add(Arrays.asList(Keyboards.lower[5][3], Keyboards.lower[4][3]));

            graph.add(Arrays.asList(Keyboards.lower[5][4], Keyboards.lower[5][5]));
            graph.add(Arrays.asList(Keyboards.lower[5][4], Keyboards.lower[0][4]));
            graph.add(Arrays.asList(Keyboards.lower[5][4], Keyboards.lower[5][5]));
            graph.add(Arrays.asList(Keyboards.lower[5][4], Keyboards.lower[4][4]));

            //Fertig
            graph.add(Arrays.asList(Keyboards.lower[5][5], Keyboards.lower[5][0]));
            graph.add(Arrays.asList(Keyboards.lower[5][5], Keyboards.lower[0][5]));
            graph.add(Arrays.asList(Keyboards.lower[5][5], Keyboards.lower[5][0]));
            graph.add(Arrays.asList(Keyboards.lower[5][5], Keyboards.lower[4][4]));

            graph.add(Arrays.asList(Keyboards.lower[5][6], Keyboards.lower[5][0]));
            graph.add(Arrays.asList(Keyboards.lower[5][6], Keyboards.lower[0][6]));
            graph.add(Arrays.asList(Keyboards.lower[5][6], Keyboards.lower[5][0]));
            graph.add(Arrays.asList(Keyboards.lower[5][6], Keyboards.lower[4][4]));

            graph.add(Arrays.asList(Keyboards.lower[5][7], Keyboards.lower[5][0]));
            graph.add(Arrays.asList(Keyboards.lower[5][7], Keyboards.lower[0][7]));
            graph.add(Arrays.asList(Keyboards.lower[5][7], Keyboards.lower[5][0]));
            graph.add(Arrays.asList(Keyboards.lower[5][7], Keyboards.lower[4][4]));

            graph.add(Arrays.asList(Keyboards.lower[5][8], Keyboards.lower[5][0]));
            graph.add(Arrays.asList(Keyboards.lower[5][8], Keyboards.lower[0][8]));
            graph.add(Arrays.asList(Keyboards.lower[5][8], Keyboards.lower[5][0]));
            graph.add(Arrays.asList(Keyboards.lower[5][8], Keyboards.lower[4][8]));

            graph.add(Arrays.asList(Keyboards.lower[5][9], Keyboards.lower[5][0]));
            graph.add(Arrays.asList(Keyboards.lower[5][9], Keyboards.lower[0][9]));
            graph.add(Arrays.asList(Keyboards.lower[5][9], Keyboards.lower[5][0]));
            graph.add(Arrays.asList(Keyboards.lower[5][9], Keyboards.lower[4][8]));

            graph.add(Arrays.asList(Keyboards.lower[5][10], Keyboards.lower[5][0]));
            graph.add(Arrays.asList(Keyboards.lower[5][10], Keyboards.lower[0][10]));
            graph.add(Arrays.asList(Keyboards.lower[5][10], Keyboards.lower[5][0]));
            graph.add(Arrays.asList(Keyboards.lower[5][10], Keyboards.lower[4][8]));

            // ** UPPER PATHS **
            //1
            graph.add(Arrays.asList(Keyboards.upper[0][0], Keyboards.upper[0][1]));
            graph.add(Arrays.asList(Keyboards.upper[0][0], Keyboards.upper[1][0]));
            graph.add(Arrays.asList(Keyboards.upper[0][0], Keyboards.upper[0][10]));
            graph.add(Arrays.asList(Keyboards.upper[0][0], Keyboards.upper[5][0]));

            //2
            graph.add(Arrays.asList(Keyboards.upper[0][1], Keyboards.upper[0][2]));
            graph.add(Arrays.asList(Keyboards.upper[0][1], Keyboards.upper[1][1]));
            graph.add(Arrays.asList(Keyboards.upper[0][1], Keyboards.upper[0][0]));
            graph.add(Arrays.asList(Keyboards.upper[0][1], Keyboards.upper[5][1]));

            //3
            graph.add(Arrays.asList(Keyboards.upper[0][2], Keyboards.upper[0][3]));
            graph.add(Arrays.asList(Keyboards.upper[0][2], Keyboards.upper[1][2]));
            graph.add(Arrays.asList(Keyboards.upper[0][2], Keyboards.upper[0][1]));
            graph.add(Arrays.asList(Keyboards.upper[0][2], Keyboards.upper[5][2]));

            //4
            graph.add(Arrays.asList(Keyboards.upper[0][3], Keyboards.upper[0][4]));
            graph.add(Arrays.asList(Keyboards.upper[0][3], Keyboards.upper[1][3]));
            graph.add(Arrays.asList(Keyboards.upper[0][3], Keyboards.upper[0][2]));
            graph.add(Arrays.asList(Keyboards.upper[0][3], Keyboards.upper[5][3]));

            //5
            graph.add(Arrays.asList(Keyboards.upper[0][4], Keyboards.upper[0][5]));
            graph.add(Arrays.asList(Keyboards.upper[0][4], Keyboards.upper[1][4]));
            graph.add(Arrays.asList(Keyboards.upper[0][4], Keyboards.upper[0][3]));
            graph.add(Arrays.asList(Keyboards.upper[0][4], Keyboards.upper[5][4]));

            //6
            graph.add(Arrays.asList(Keyboards.upper[0][5], Keyboards.upper[0][6]));
            graph.add(Arrays.asList(Keyboards.upper[0][5], Keyboards.upper[1][5]));
            graph.add(Arrays.asList(Keyboards.upper[0][5], Keyboards.upper[0][4]));
            graph.add(Arrays.asList(Keyboards.upper[0][5], Keyboards.upper[5][5]));

            //7
            graph.add(Arrays.asList(Keyboards.upper[0][6], Keyboards.upper[0][7]));
            graph.add(Arrays.asList(Keyboards.upper[0][6], Keyboards.upper[1][6]));
            graph.add(Arrays.asList(Keyboards.upper[0][6], Keyboards.upper[0][5]));
            graph.add(Arrays.asList(Keyboards.upper[0][6], Keyboards.upper[5][6]));

            //8
            graph.add(Arrays.asList(Keyboards.upper[0][7], Keyboards.upper[0][8]));
            graph.add(Arrays.asList(Keyboards.upper[0][7], Keyboards.upper[1][7]));
            graph.add(Arrays.asList(Keyboards.upper[0][7], Keyboards.upper[0][6]));
            graph.add(Arrays.asList(Keyboards.upper[0][7], Keyboards.upper[5][7]));

            //9
            graph.add(Arrays.asList(Keyboards.upper[0][8], Keyboards.upper[0][9]));
            graph.add(Arrays.asList(Keyboards.upper[0][8], Keyboards.upper[1][8]));
            graph.add(Arrays.asList(Keyboards.upper[0][8], Keyboards.upper[0][7]));
            graph.add(Arrays.asList(Keyboards.upper[0][8], Keyboards.upper[5][8]));

            //0
            graph.add(Arrays.asList(Keyboards.upper[0][9], Keyboards.upper[0][10]));
            graph.add(Arrays.asList(Keyboards.upper[0][9], Keyboards.upper[1][9]));
            graph.add(Arrays.asList(Keyboards.upper[0][9], Keyboards.upper[0][8]));
            graph.add(Arrays.asList(Keyboards.upper[0][9], Keyboards.upper[5][9]));

            //.
            graph.add(Arrays.asList(Keyboards.upper[0][10], Keyboards.upper[0][0]));
            graph.add(Arrays.asList(Keyboards.upper[0][10], Keyboards.upper[1][10]));
            graph.add(Arrays.asList(Keyboards.upper[0][10], Keyboards.upper[0][9]));
            graph.add(Arrays.asList(Keyboards.upper[0][10], Keyboards.upper[5][10]));

            //Q
            graph.add(Arrays.asList(Keyboards.upper[1][0], Keyboards.upper[1][1]));
            graph.add(Arrays.asList(Keyboards.upper[1][0], Keyboards.upper[2][0]));
            graph.add(Arrays.asList(Keyboards.upper[1][0], Keyboards.upper[1][10]));
            graph.add(Arrays.asList(Keyboards.upper[1][0], Keyboards.upper[0][0]));

            //W
            graph.add(Arrays.asList(Keyboards.upper[1][1], Keyboards.upper[1][2]));
            graph.add(Arrays.asList(Keyboards.upper[1][1], Keyboards.upper[2][1]));
            graph.add(Arrays.asList(Keyboards.upper[1][1], Keyboards.upper[1][0]));
            graph.add(Arrays.asList(Keyboards.upper[1][1], Keyboards.upper[0][1]));

            //E
            graph.add(Arrays.asList(Keyboards.upper[1][2], Keyboards.upper[1][3]));
            graph.add(Arrays.asList(Keyboards.upper[1][2], Keyboards.upper[2][2]));
            graph.add(Arrays.asList(Keyboards.upper[1][2], Keyboards.upper[1][1]));
            graph.add(Arrays.asList(Keyboards.upper[1][2], Keyboards.upper[0][2]));

            //R
            graph.add(Arrays.asList(Keyboards.upper[1][3], Keyboards.upper[1][4]));
            graph.add(Arrays.asList(Keyboards.upper[1][3], Keyboards.upper[2][3]));
            graph.add(Arrays.asList(Keyboards.upper[1][3], Keyboards.upper[1][2]));
            graph.add(Arrays.asList(Keyboards.upper[1][3], Keyboards.upper[0][3]));

            //T
            graph.add(Arrays.asList(Keyboards.upper[1][4], Keyboards.upper[1][5]));
            graph.add(Arrays.asList(Keyboards.upper[1][4], Keyboards.upper[2][4]));
            graph.add(Arrays.asList(Keyboards.upper[1][4], Keyboards.upper[1][3]));
            graph.add(Arrays.asList(Keyboards.upper[1][4], Keyboards.upper[0][4]));

            //Z
            graph.add(Arrays.asList(Keyboards.upper[1][5], Keyboards.upper[1][6]));
            graph.add(Arrays.asList(Keyboards.upper[1][5], Keyboards.upper[2][5]));
            graph.add(Arrays.asList(Keyboards.upper[1][5], Keyboards.upper[1][4]));
            graph.add(Arrays.asList(Keyboards.upper[1][5], Keyboards.upper[0][5]));

            //U
            graph.add(Arrays.asList(Keyboards.upper[1][6], Keyboards.upper[1][7]));
            graph.add(Arrays.asList(Keyboards.upper[1][6], Keyboards.upper[2][6]));
            graph.add(Arrays.asList(Keyboards.upper[1][6], Keyboards.upper[1][5]));
            graph.add(Arrays.asList(Keyboards.upper[1][6], Keyboards.upper[0][6]));

            //I
            graph.add(Arrays.asList(Keyboards.upper[1][7], Keyboards.upper[1][8]));
            graph.add(Arrays.asList(Keyboards.upper[1][7], Keyboards.upper[2][7]));
            graph.add(Arrays.asList(Keyboards.upper[1][7], Keyboards.upper[1][6]));
            graph.add(Arrays.asList(Keyboards.upper[1][7], Keyboards.upper[0][7]));

            //O
            graph.add(Arrays.asList(Keyboards.upper[1][8], Keyboards.upper[1][9]));
            graph.add(Arrays.asList(Keyboards.upper[1][8], Keyboards.upper[2][8]));
            graph.add(Arrays.asList(Keyboards.upper[1][8], Keyboards.upper[1][7]));
            graph.add(Arrays.asList(Keyboards.upper[1][8], Keyboards.upper[0][8]));

            //P
            graph.add(Arrays.asList(Keyboards.upper[1][9], Keyboards.upper[1][10]));
            graph.add(Arrays.asList(Keyboards.upper[1][9], Keyboards.upper[2][9]));
            graph.add(Arrays.asList(Keyboards.upper[1][9], Keyboards.upper[1][8]));
            graph.add(Arrays.asList(Keyboards.upper[1][9], Keyboards.upper[0][9]));

            //Ü
            graph.add(Arrays.asList(Keyboards.upper[1][10], Keyboards.upper[1][0]));
            graph.add(Arrays.asList(Keyboards.upper[1][10], Keyboards.upper[2][10]));
            graph.add(Arrays.asList(Keyboards.upper[1][10], Keyboards.upper[1][9]));
            graph.add(Arrays.asList(Keyboards.upper[1][10], Keyboards.upper[0][10]));

            //A
            graph.add(Arrays.asList(Keyboards.upper[2][0], Keyboards.upper[2][1]));
            graph.add(Arrays.asList(Keyboards.upper[2][0], Keyboards.upper[3][0]));
            graph.add(Arrays.asList(Keyboards.upper[2][0], Keyboards.upper[2][10]));
            graph.add(Arrays.asList(Keyboards.upper[2][0], Keyboards.upper[1][0]));

            //S
            graph.add(Arrays.asList(Keyboards.upper[2][1], Keyboards.upper[2][2]));
            graph.add(Arrays.asList(Keyboards.upper[2][1], Keyboards.upper[3][1]));
            graph.add(Arrays.asList(Keyboards.upper[2][1], Keyboards.upper[2][0]));
            graph.add(Arrays.asList(Keyboards.upper[2][1], Keyboards.upper[1][1]));

            //main.java.D
            graph.add(Arrays.asList(Keyboards.upper[2][2], Keyboards.upper[2][3]));
            graph.add(Arrays.asList(Keyboards.upper[2][2], Keyboards.upper[3][2]));
            graph.add(Arrays.asList(Keyboards.upper[2][2], Keyboards.upper[2][1]));
            graph.add(Arrays.asList(Keyboards.upper[2][2], Keyboards.upper[1][2]));

            //F
            graph.add(Arrays.asList(Keyboards.upper[2][3], Keyboards.upper[2][4]));
            graph.add(Arrays.asList(Keyboards.upper[2][3], Keyboards.upper[3][3]));
            graph.add(Arrays.asList(Keyboards.upper[2][3], Keyboards.upper[2][2]));
            graph.add(Arrays.asList(Keyboards.upper[2][3], Keyboards.upper[1][3]));

            //G
            graph.add(Arrays.asList(Keyboards.upper[2][4], Keyboards.upper[2][5]));
            graph.add(Arrays.asList(Keyboards.upper[2][4], Keyboards.upper[3][4]));
            graph.add(Arrays.asList(Keyboards.upper[2][4], Keyboards.upper[2][3]));
            graph.add(Arrays.asList(Keyboards.upper[2][4], Keyboards.upper[1][4]));

            //H
            graph.add(Arrays.asList(Keyboards.upper[2][5], Keyboards.upper[2][6]));
            graph.add(Arrays.asList(Keyboards.upper[2][5], Keyboards.upper[3][5]));
            graph.add(Arrays.asList(Keyboards.upper[2][5], Keyboards.upper[2][4]));
            graph.add(Arrays.asList(Keyboards.upper[2][5], Keyboards.upper[1][5]));

            //J
            graph.add(Arrays.asList(Keyboards.upper[2][6], Keyboards.upper[2][7]));
            graph.add(Arrays.asList(Keyboards.upper[2][6], Keyboards.upper[3][6]));
            graph.add(Arrays.asList(Keyboards.upper[2][6], Keyboards.upper[2][5]));
            graph.add(Arrays.asList(Keyboards.upper[2][6], Keyboards.upper[1][6]));

            //K
            graph.add(Arrays.asList(Keyboards.upper[2][7], Keyboards.upper[2][8]));
            graph.add(Arrays.asList(Keyboards.upper[2][7], Keyboards.upper[3][7]));
            graph.add(Arrays.asList(Keyboards.upper[2][7], Keyboards.upper[2][6]));
            graph.add(Arrays.asList(Keyboards.upper[2][7], Keyboards.upper[1][7]));

            //L
            graph.add(Arrays.asList(Keyboards.upper[2][8], Keyboards.upper[2][9]));
            graph.add(Arrays.asList(Keyboards.upper[2][8], Keyboards.upper[3][8]));
            graph.add(Arrays.asList(Keyboards.upper[2][8], Keyboards.upper[2][7]));
            graph.add(Arrays.asList(Keyboards.upper[2][8], Keyboards.upper[1][8]));

            //Ö
            graph.add(Arrays.asList(Keyboards.upper[2][9], Keyboards.upper[2][10]));
            graph.add(Arrays.asList(Keyboards.upper[2][9], Keyboards.upper[3][9]));
            graph.add(Arrays.asList(Keyboards.upper[2][9], Keyboards.upper[2][8]));
            graph.add(Arrays.asList(Keyboards.upper[2][9], Keyboards.upper[1][9]));

            //Ä
            graph.add(Arrays.asList(Keyboards.upper[2][10], Keyboards.upper[2][0]));
            graph.add(Arrays.asList(Keyboards.upper[2][10], Keyboards.upper[3][10]));
            graph.add(Arrays.asList(Keyboards.upper[2][10], Keyboards.upper[2][9]));
            graph.add(Arrays.asList(Keyboards.upper[2][10], Keyboards.upper[1][10]));

            //shift
            graph.add(Arrays.asList(Keyboards.upper[3][0], Keyboards.lower[3][2]));
            graph.add(Arrays.asList(Keyboards.upper[3][0], Keyboards.lower[4][0]));
            graph.add(Arrays.asList(Keyboards.upper[3][0], Keyboards.lower[3][10]));
            graph.add(Arrays.asList(Keyboards.upper[3][0], Keyboards.lower[2][0]));

            graph.add(Arrays.asList(Keyboards.upper[3][1], Keyboards.lower[3][2]));
            graph.add(Arrays.asList(Keyboards.upper[3][1], Keyboards.lower[4][1]));
            graph.add(Arrays.asList(Keyboards.upper[3][1], Keyboards.lower[3][10]));
            graph.add(Arrays.asList(Keyboards.upper[3][1], Keyboards.lower[2][1]));

            graph.add(Arrays.asList(Keyboards.upper[3][0], Keyboards.upper[3][2]));
            graph.add(Arrays.asList(Keyboards.upper[3][0], Keyboards.upper[4][0]));
            graph.add(Arrays.asList(Keyboards.upper[3][0], Keyboards.upper[3][10]));
            graph.add(Arrays.asList(Keyboards.upper[3][0], Keyboards.upper[2][0]));

            graph.add(Arrays.asList(Keyboards.upper[3][1], Keyboards.upper[3][2]));
            graph.add(Arrays.asList(Keyboards.upper[3][1], Keyboards.upper[4][1]));
            graph.add(Arrays.asList(Keyboards.upper[3][1], Keyboards.upper[3][10]));
            graph.add(Arrays.asList(Keyboards.upper[3][1], Keyboards.upper[2][1]));

            //Y
            graph.add(Arrays.asList(Keyboards.upper[3][2], Keyboards.upper[3][3]));
            graph.add(Arrays.asList(Keyboards.upper[3][2], Keyboards.upper[4][2]));
            graph.add(Arrays.asList(Keyboards.upper[3][2], Keyboards.upper[3][0]));
            graph.add(Arrays.asList(Keyboards.upper[3][2], Keyboards.upper[2][2]));

            //X
            graph.add(Arrays.asList(Keyboards.upper[3][3], Keyboards.upper[3][4]));
            graph.add(Arrays.asList(Keyboards.upper[3][3], Keyboards.upper[4][3]));
            graph.add(Arrays.asList(Keyboards.upper[3][3], Keyboards.upper[3][2]));
            graph.add(Arrays.asList(Keyboards.upper[3][3], Keyboards.upper[2][3]));

            //main.java.C
            graph.add(Arrays.asList(Keyboards.upper[3][4], Keyboards.upper[3][5]));
            graph.add(Arrays.asList(Keyboards.upper[3][4], Keyboards.upper[4][4]));
            graph.add(Arrays.asList(Keyboards.upper[3][4], Keyboards.upper[3][3]));
            graph.add(Arrays.asList(Keyboards.upper[3][4], Keyboards.upper[2][4]));

            //V
            graph.add(Arrays.asList(Keyboards.upper[3][5], Keyboards.upper[3][6]));
            graph.add(Arrays.asList(Keyboards.upper[3][5], Keyboards.upper[4][5]));
            graph.add(Arrays.asList(Keyboards.upper[3][5], Keyboards.upper[3][4]));
            graph.add(Arrays.asList(Keyboards.upper[3][5], Keyboards.upper[2][5]));

            //B
            graph.add(Arrays.asList(Keyboards.upper[3][6], Keyboards.upper[3][7]));
            graph.add(Arrays.asList(Keyboards.upper[3][6], Keyboards.upper[4][6]));
            graph.add(Arrays.asList(Keyboards.upper[3][6], Keyboards.upper[3][5]));
            graph.add(Arrays.asList(Keyboards.upper[3][6], Keyboards.upper[2][6]));

            //N
            graph.add(Arrays.asList(Keyboards.upper[3][7], Keyboards.upper[3][8]));
            graph.add(Arrays.asList(Keyboards.upper[3][7], Keyboards.upper[4][7]));
            graph.add(Arrays.asList(Keyboards.upper[3][7], Keyboards.upper[3][6]));
            graph.add(Arrays.asList(Keyboards.upper[3][7], Keyboards.upper[2][7]));

            //M
            graph.add(Arrays.asList(Keyboards.upper[3][8], Keyboards.upper[3][9]));
            graph.add(Arrays.asList(Keyboards.upper[3][8], Keyboards.upper[4][8]));
            graph.add(Arrays.asList(Keyboards.upper[3][8], Keyboards.upper[3][7]));
            graph.add(Arrays.asList(Keyboards.upper[3][8], Keyboards.upper[2][8]));

            //-
            graph.add(Arrays.asList(Keyboards.upper[3][9], Keyboards.upper[3][10]));
            graph.add(Arrays.asList(Keyboards.upper[3][9], Keyboards.upper[4][9]));
            graph.add(Arrays.asList(Keyboards.upper[3][9], Keyboards.upper[3][8]));
            graph.add(Arrays.asList(Keyboards.upper[3][9], Keyboards.upper[2][9]));

            //'
            graph.add(Arrays.asList(Keyboards.upper[3][10], Keyboards.upper[3][0]));
            graph.add(Arrays.asList(Keyboards.upper[3][10], Keyboards.upper[4][10]));
            graph.add(Arrays.asList(Keyboards.upper[3][10], Keyboards.upper[3][9]));
            graph.add(Arrays.asList(Keyboards.upper[3][10], Keyboards.upper[2][10]));

            //!#$
            graph.add(Arrays.asList(Keyboards.upper[4][0], Keyboards.upper[4][2]));
            graph.add(Arrays.asList(Keyboards.upper[4][0], Keyboards.upper[5][0]));
            graph.add(Arrays.asList(Keyboards.upper[4][0], Keyboards.upper[4][8]));
            graph.add(Arrays.asList(Keyboards.upper[4][0], Keyboards.upper[3][0]));

            graph.add(Arrays.asList(Keyboards.upper[4][1], Keyboards.upper[4][2]));
            graph.add(Arrays.asList(Keyboards.upper[4][1], Keyboards.upper[5][1]));
            graph.add(Arrays.asList(Keyboards.upper[4][1], Keyboards.upper[4][8]));
            graph.add(Arrays.asList(Keyboards.upper[4][1], Keyboards.upper[3][0]));

            //àáâ
            graph.add(Arrays.asList(Keyboards.upper[4][2], Keyboards.upper[4][4]));
            graph.add(Arrays.asList(Keyboards.upper[4][2], Keyboards.upper[5][2]));
            graph.add(Arrays.asList(Keyboards.upper[4][2], Keyboards.upper[4][0]));
            graph.add(Arrays.asList(Keyboards.upper[4][2], Keyboards.upper[3][2]));

            graph.add(Arrays.asList(Keyboards.upper[4][3], Keyboards.upper[4][4]));
            graph.add(Arrays.asList(Keyboards.upper[4][3], Keyboards.upper[5][3]));
            graph.add(Arrays.asList(Keyboards.upper[4][3], Keyboards.upper[4][0]));
            graph.add(Arrays.asList(Keyboards.upper[4][3], Keyboards.upper[3][3]));

            //space
            graph.add(Arrays.asList(Keyboards.upper[4][4], Keyboards.upper[4][8]));
            graph.add(Arrays.asList(Keyboards.upper[4][4], Keyboards.upper[5][4]));
            graph.add(Arrays.asList(Keyboards.upper[4][4], Keyboards.upper[4][2]));
            graph.add(Arrays.asList(Keyboards.upper[4][4], Keyboards.upper[3][4]));

            graph.add(Arrays.asList(Keyboards.upper[4][5], Keyboards.upper[4][8]));
            graph.add(Arrays.asList(Keyboards.upper[4][5], Keyboards.upper[5][5]));
            graph.add(Arrays.asList(Keyboards.upper[4][5], Keyboards.upper[4][2]));
            graph.add(Arrays.asList(Keyboards.upper[4][5], Keyboards.upper[3][5]));

            graph.add(Arrays.asList(Keyboards.upper[4][6], Keyboards.upper[4][8]));
            graph.add(Arrays.asList(Keyboards.upper[4][6], Keyboards.upper[5][6]));
            graph.add(Arrays.asList(Keyboards.upper[4][6], Keyboards.upper[4][2]));
            graph.add(Arrays.asList(Keyboards.upper[4][6], Keyboards.upper[3][6]));

            graph.add(Arrays.asList(Keyboards.upper[4][7], Keyboards.upper[4][8]));
            graph.add(Arrays.asList(Keyboards.upper[4][7], Keyboards.upper[5][7]));
            graph.add(Arrays.asList(Keyboards.upper[4][7], Keyboards.upper[4][2]));
            graph.add(Arrays.asList(Keyboards.upper[4][7], Keyboards.upper[3][7]));

            //delete
            graph.add(Arrays.asList(Keyboards.upper[4][8], Keyboards.upper[4][0]));
            graph.add(Arrays.asList(Keyboards.upper[4][8], Keyboards.upper[5][8]));
            graph.add(Arrays.asList(Keyboards.upper[4][8], Keyboards.upper[4][4]));
            graph.add(Arrays.asList(Keyboards.upper[4][8], Keyboards.upper[3][8]));

            graph.add(Arrays.asList(Keyboards.upper[4][9], Keyboards.upper[4][0]));
            graph.add(Arrays.asList(Keyboards.upper[4][9], Keyboards.upper[5][9]));
            graph.add(Arrays.asList(Keyboards.upper[4][9], Keyboards.upper[4][4]));
            graph.add(Arrays.asList(Keyboards.upper[4][9], Keyboards.upper[3][9]));

            graph.add(Arrays.asList(Keyboards.upper[4][10], Keyboards.upper[4][0]));
            graph.add(Arrays.asList(Keyboards.upper[4][10], Keyboards.upper[5][10]));
            graph.add(Arrays.asList(Keyboards.upper[4][10], Keyboards.upper[4][4]));
            graph.add(Arrays.asList(Keyboards.upper[4][10], Keyboards.upper[3][10]));

            //Abbrechen
            graph.add(Arrays.asList(Keyboards.upper[5][0], Keyboards.upper[5][5]));
            graph.add(Arrays.asList(Keyboards.upper[5][0], Keyboards.upper[0][0]));
            graph.add(Arrays.asList(Keyboards.upper[5][0], Keyboards.upper[5][5]));
            graph.add(Arrays.asList(Keyboards.upper[5][0], Keyboards.upper[4][0]));

            graph.add(Arrays.asList(Keyboards.upper[5][1], Keyboards.upper[5][5]));
            graph.add(Arrays.asList(Keyboards.upper[5][1], Keyboards.upper[0][1]));
            graph.add(Arrays.asList(Keyboards.upper[5][1], Keyboards.upper[5][5]));
            graph.add(Arrays.asList(Keyboards.upper[5][1], Keyboards.upper[4][0]));

            graph.add(Arrays.asList(Keyboards.upper[5][2], Keyboards.upper[5][5]));
            graph.add(Arrays.asList(Keyboards.upper[5][2], Keyboards.upper[0][2]));
            graph.add(Arrays.asList(Keyboards.upper[5][2], Keyboards.upper[5][5]));
            graph.add(Arrays.asList(Keyboards.upper[5][2], Keyboards.upper[4][2]));

            graph.add(Arrays.asList(Keyboards.upper[5][3], Keyboards.upper[5][5]));
            graph.add(Arrays.asList(Keyboards.upper[5][3], Keyboards.upper[0][3]));
            graph.add(Arrays.asList(Keyboards.upper[5][3], Keyboards.upper[5][5]));
            graph.add(Arrays.asList(Keyboards.upper[5][3], Keyboards.upper[4][3]));

            graph.add(Arrays.asList(Keyboards.upper[5][4], Keyboards.upper[5][5]));
            graph.add(Arrays.asList(Keyboards.upper[5][4], Keyboards.upper[0][4]));
            graph.add(Arrays.asList(Keyboards.upper[5][4], Keyboards.upper[5][5]));
            graph.add(Arrays.asList(Keyboards.upper[5][4], Keyboards.upper[4][4]));

            //Fertig
            graph.add(Arrays.asList(Keyboards.upper[5][5], Keyboards.upper[5][0]));
            graph.add(Arrays.asList(Keyboards.upper[5][5], Keyboards.upper[0][5]));
            graph.add(Arrays.asList(Keyboards.upper[5][5], Keyboards.upper[5][0]));
            graph.add(Arrays.asList(Keyboards.upper[5][5], Keyboards.upper[4][4]));

            graph.add(Arrays.asList(Keyboards.upper[5][6], Keyboards.upper[5][0]));
            graph.add(Arrays.asList(Keyboards.upper[5][6], Keyboards.upper[0][6]));
            graph.add(Arrays.asList(Keyboards.upper[5][6], Keyboards.upper[5][0]));
            graph.add(Arrays.asList(Keyboards.upper[5][6], Keyboards.upper[4][4]));

            graph.add(Arrays.asList(Keyboards.upper[5][7], Keyboards.upper[5][0]));
            graph.add(Arrays.asList(Keyboards.upper[5][7], Keyboards.upper[0][7]));
            graph.add(Arrays.asList(Keyboards.upper[5][7], Keyboards.upper[5][0]));
            graph.add(Arrays.asList(Keyboards.upper[5][7], Keyboards.upper[4][4]));

            graph.add(Arrays.asList(Keyboards.upper[5][8], Keyboards.upper[5][0]));
            graph.add(Arrays.asList(Keyboards.upper[5][8], Keyboards.upper[0][8]));
            graph.add(Arrays.asList(Keyboards.upper[5][8], Keyboards.upper[5][0]));
            graph.add(Arrays.asList(Keyboards.upper[5][8], Keyboards.upper[4][8]));

            graph.add(Arrays.asList(Keyboards.upper[5][9], Keyboards.upper[5][0]));
            graph.add(Arrays.asList(Keyboards.upper[5][9], Keyboards.upper[0][9]));
            graph.add(Arrays.asList(Keyboards.upper[5][9], Keyboards.upper[5][0]));
            graph.add(Arrays.asList(Keyboards.upper[5][9], Keyboards.upper[4][8]));

            graph.add(Arrays.asList(Keyboards.upper[5][10], Keyboards.upper[5][0]));
            graph.add(Arrays.asList(Keyboards.upper[5][10], Keyboards.upper[0][10]));
            graph.add(Arrays.asList(Keyboards.upper[5][10], Keyboards.upper[5][0]));
            graph.add(Arrays.asList(Keyboards.upper[5][10], Keyboards.upper[4][8]));
        }


    }

    static class Keyboards {
        public static final Point[][] lower = new Point[6][11];
        public static final Point[][] upper = new Point[6][11];

        static {
            //lower
            lower[0][0] = new Point(0, 0, "1", "lower");
            lower[0][1] = new Point(0, 1, "2", "lower");
            lower[0][2] = new Point(0, 2, "3", "lower");
            lower[0][3] = new Point(0, 3, "4", "lower");
            lower[0][4] = new Point(0, 4, "5", "lower");
            lower[0][5] = new Point(0, 5, "6", "lower");
            lower[0][6] = new Point(0, 6, "7", "lower");
            lower[0][7] = new Point(0, 7, "8", "lower");
            lower[0][8] = new Point(0, 8, "9", "lower");
            lower[0][9] = new Point(0, 9, "0", "lower");
            lower[0][10] = new Point(0, 10, "ß", "lower");

            lower[1][0] = new Point(1, 0, "q", "lower");
            lower[1][1] = new Point(1, 1, "w", "lower");
            lower[1][2] = new Point(1, 2, "e", "lower");
            lower[1][3] = new Point(1, 3, "r", "lower");
            lower[1][4] = new Point(1, 4, "t", "lower");
            lower[1][5] = new Point(1, 5, "z", "lower");
            lower[1][6] = new Point(1, 6, "u", "lower");
            lower[1][7] = new Point(1, 7, "i", "lower");
            lower[1][8] = new Point(1, 8, "o", "lower");
            lower[1][9] = new Point(1, 9, "p", "lower");
            lower[1][10] = new Point(1, 10, "ü", "lower");

            lower[2][0] = new Point(2, 0, "a", "lower");
            lower[2][1] = new Point(2, 1, "s", "lower");
            lower[2][2] = new Point(2, 2, "d", "lower");
            lower[2][3] = new Point(2, 3, "f", "lower");
            lower[2][4] = new Point(2, 4, "g", "lower");
            lower[2][5] = new Point(2, 5, "h", "lower");
            lower[2][6] = new Point(2, 6, "j", "lower");
            lower[2][7] = new Point(2, 7, "k", "lower");
            lower[2][8] = new Point(2, 8, "l", "lower");
            lower[2][9] = new Point(2, 9, "ö", "lower");
            lower[2][10] = new Point(2, 10, "ä", "lower");

            lower[3][0] = new Point(3, 0, "shift", "lower");
            lower[3][1] = new Point(3, 1, "shift", "lower");
            lower[3][2] = new Point(3, 2, "y", "lower");
            lower[3][3] = new Point(3, 3, "x", "lower");
            lower[3][4] = new Point(3, 4, "c", "lower");
            lower[3][5] = new Point(3, 5, "v", "lower");
            lower[3][6] = new Point(3, 6, "b", "lower");
            lower[3][7] = new Point(3, 7, "n", "lower");
            lower[3][8] = new Point(3, 8, "m", "lower");
            lower[3][9] = new Point(3, 9, "-", "lower");
            lower[3][10] = new Point(3, 10, "'", "lower");

            lower[4][0] = new Point(4, 0, "!#$", "lower");
            lower[4][1] = new Point(4, 1, "!#$", "lower");
            lower[4][2] = new Point(4, 2, "àáâ", "lower");
            lower[4][3] = new Point(4, 3, "àáâ", "lower");
            lower[4][4] = new Point(4, 4, "space", "lower");
            lower[4][5] = new Point(4, 5, "space", "lower");
            lower[4][6] = new Point(4, 6, "space", "lower");
            lower[4][7] = new Point(4, 7, "space", "lower");
            lower[4][8] = new Point(4, 8, "delete", "lower");
            lower[4][9] = new Point(4, 9, "delete", "lower");
            lower[4][10] = new Point(4, 10, "delete", "lower");

            lower[5][0] = new Point(5, 0, "Abbrechen", "lower");
            lower[5][1] = new Point(5, 1, "Abbrechen", "lower");
            lower[5][2] = new Point(5, 2, "Abbrechen", "lower");
            lower[5][3] = new Point(5, 3, "Abbrechen", "lower");
            lower[5][4] = new Point(5, 4, "Abbrechen", "lower");
            lower[5][5] = new Point(5, 5, "Fertig", "lower");
            lower[5][6] = new Point(5, 6, "Fertig", "lower");
            lower[5][7] = new Point(5, 7, "Fertig", "lower");
            lower[5][8] = new Point(5, 8, "Fertig", "lower");
            lower[5][9] = new Point(5, 9, "Fertig", "lower");
            lower[5][10] = new Point(5, 10, "Fertig", "lower");

            //upper
            upper[0][0] = new Point(0, 0, "1", "upper");
            upper[0][1] = new Point(0, 1, "2", "upper");
            upper[0][2] = new Point(0, 2, "3", "upper");
            upper[0][3] = new Point(0, 3, "4", "upper");
            upper[0][4] = new Point(0, 4, "5", "upper");
            upper[0][5] = new Point(0, 5, "6", "upper");
            upper[0][6] = new Point(0, 6, "7", "upper");
            upper[0][7] = new Point(0, 7, "8", "upper");
            upper[0][8] = new Point(0, 8, "9", "upper");
            upper[0][9] = new Point(0, 9, "0", "upper");
            upper[0][10] = new Point(0, 10, ".", "upper");

            upper[1][0] = new Point(1, 0, "Q", "upper");
            upper[1][1] = new Point(1, 1, "W", "upper");
            upper[1][2] = new Point(1, 2, "E", "upper");
            upper[1][3] = new Point(1, 3, "R", "upper");
            upper[1][4] = new Point(1, 4, "T", "upper");
            upper[1][5] = new Point(1, 5, "Z", "upper");
            upper[1][6] = new Point(1, 6, "U", "upper");
            upper[1][7] = new Point(1, 7, "I", "upper");
            upper[1][8] = new Point(1, 8, "O", "upper");
            upper[1][9] = new Point(1, 9, "P", "upper");
            upper[1][10] = new Point(1, 10, "Ü", "upper");

            upper[2][0] = new Point(2, 0, "A", "upper");
            upper[2][1] = new Point(2, 1, "S", "upper");
            upper[2][2] = new Point(2, 2, "main.java.D", "upper");
            upper[2][3] = new Point(2, 3, "F", "upper");
            upper[2][4] = new Point(2, 4, "G", "upper");
            upper[2][5] = new Point(2, 5, "H", "upper");
            upper[2][6] = new Point(2, 6, "J", "upper");
            upper[2][7] = new Point(2, 7, "K", "upper");
            upper[2][8] = new Point(2, 8, "L", "upper");
            upper[2][9] = new Point(2, 9, "Ö", "upper");
            upper[2][10] = new Point(2, 10, "Ä", "upper");

            upper[3][0] = new Point(3, 0, "shift", "upper");
            upper[3][1] = new Point(3, 1, "shift", "upper");
            upper[3][2] = new Point(3, 2, "Y", "upper");
            upper[3][3] = new Point(3, 3, "X", "upper");
            upper[3][4] = new Point(3, 4, "main.java.C", "upper");
            upper[3][5] = new Point(3, 5, "V", "upper");
            upper[3][6] = new Point(3, 6, "B", "upper");
            upper[3][7] = new Point(3, 7, "N", "upper");
            upper[3][8] = new Point(3, 8, "M", "upper");
            upper[3][9] = new Point(3, 9, "-", "upper");
            upper[3][10] = new Point(3, 10, "'", "upper");

            upper[4][0] = new Point(4, 0, "!#$", "upper");
            upper[4][1] = new Point(4, 1, "!#$", "upper");
            upper[4][2] = new Point(4, 2, "àáâ", "upper");
            upper[4][3] = new Point(4, 3, "àáâ", "upper");
            upper[4][4] = new Point(4, 4, "space", "upper");
            upper[4][5] = new Point(4, 5, "space", "upper");
            upper[4][6] = new Point(4, 6, "space", "upper");
            upper[4][7] = new Point(4, 7, "space", "upper");
            upper[4][8] = new Point(4, 8, "delete", "upper");
            upper[4][9] = new Point(4, 9, "delete", "upper");
            upper[4][10] = new Point(4, 10, "delete", "upper");

            upper[5][0] = new Point(5, 0, "Abbrechen", "upper");
            upper[5][1] = new Point(5, 1, "Abbrechen", "upper");
            upper[5][2] = new Point(5, 2, "Abbrechen", "upper");
            upper[5][3] = new Point(5, 3, "Abbrechen", "upper");
            upper[5][4] = new Point(5, 4, "Abbrechen", "upper");
            upper[5][5] = new Point(5, 5, "Fertig", "upper");
            upper[5][6] = new Point(5, 6, "Fertig", "upper");
            upper[5][7] = new Point(5, 7, "Fertig", "upper");
            upper[5][8] = new Point(5, 8, "Fertig", "upper");
            upper[5][9] = new Point(5, 9, "Fertig", "upper");
            upper[5][10] = new Point(5, 10, "Fertig", "upper");
        }
    }

    static class MyPoint {

        public int row;
        public int col;
        public String type;
        public String keyboardLayer;

        public MyPoint(Point p) {
            this.row = p.row;
            this.col = p.col;
            this.type = p.type;
            this.keyboardLayer = p.keyboardLayer;
        }

        public MyPoint(int row, int col, String type, String keyboardLayer) {
            this.row = row;
            this.col = col;
            this.type = type;
            this.keyboardLayer = keyboardLayer;
        }

        @Override
        public String toString() {
            return "[" + this.row + "," + this.col + "," + this.type + "," + this.keyboardLayer + "]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyPoint myPoint = (MyPoint) o;
            return row == myPoint.row && col == myPoint.col && type.equals(myPoint.type) && keyboardLayer.equals(myPoint.keyboardLayer);
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col, type, keyboardLayer);
        }
    }

    static class Point {
        public int row;
        public int col;
        public String type;
        public String keyboardLayer;

        public Point(int row, int col, String type) {
            this.row = row;
            this.col = col;
            this.type = type;
            this.keyboardLayer = "";
        }

        public Point(int row, int col, String type, String keyboardLayer) {
            this.row = row;
            this.col = col;
            this.type = type;
            this.keyboardLayer = keyboardLayer;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other)
                return true;

            if (other == null || other.getClass() != this.getClass())
                return false;

            Point otherPoint = (Point) other;

            return otherPoint.col == this.col && otherPoint.row == this.row && otherPoint.type.equals(this.type) && otherPoint.keyboardLayer.equals(this.keyboardLayer);
        }

        @Override
        public String toString() {
            return "[" + this.row + "," + this.col + "," + this.type + "," + this.keyboardLayer + "]";
        }
    }

    static class MyPointComparator implements Comparator<MyPoint> {

        @Override
        public int compare(MyPoint p1, MyPoint p2) {
            return distanceMap.get(p1).compareTo(distanceMap.get(p2));
        }
    }

    static Map<MyPoint, List<MyPoint>> neighboursMap = new HashMap<>();
    static Map<MyPoint, Integer> maxDistanceMap = new HashMap<>();
    static Map<MyPoint, Integer> distanceMap = new HashMap<>();
    static Map<MyPoint, Map<MyPoint, Integer>> measuredDistances = new HashMap<>();
    static String shift = "shift";

    static {
        for (int i = 0; i < Keyboards.lower.length; i++) {
            for (int j = 0; j < Keyboards.lower[i].length; j++) {
                maxDistanceMap.put(new MyPoint(Keyboards.lower[i][j]), Integer.MAX_VALUE);
                maxDistanceMap.put(new MyPoint(Keyboards.upper[i][j]), Integer.MAX_VALUE);
            }
        }

        for (List<Point> l : KeyboardGraph.graph) {
            List<MyPoint> values = new ArrayList<>();
            if (neighboursMap.containsKey(new MyPoint(l.get(0)))) {
                values.addAll(neighboursMap.get(new MyPoint(l.get(0))));
                values.add(new MyPoint(l.get(1)));
                neighboursMap.put(new MyPoint(l.get(0)), values);
            } else {
                values.add(new MyPoint(l.get(1)));
                neighboursMap.put(new MyPoint(l.get(0)), values);
            }
        }

    }

    public static void main(String[] args) {
        //System.out.println(getCoordinates("held"));
        //System.out.println(getCoordinates("Enton"));

        /*System.out.println(getLengthOfShortestPath(Arrays.asList(
                new Point(2, 4, "g", "lower"),
                new Point(1, 9, "p", "lower"),
                new Point(1, 7, "i", "lower"),
                new Point(1, 7, "i", "lower"))));

        System.out.println(getLengthOfShortestPath(Arrays.asList(
                new Point(2, 4, "g", "lower"),
                new Point(2, 7, "k", "lower"),
                new Point(3, 7, "n", "lower"),
                new Point(1, 7, "i", "lower"),
                new Point(2, 8, "l", "lower"),
                new Point(1, 5, "z", "lower"))));

        System.out.println(getLengthOfShortestPath(Arrays.asList(
                new Point(2, 4, "g", "lower"),
                new Point(2, 4, "g", "lower"),
                new Point(1, 2, "e", "lower"),
                new Point(3, 7, "n", "lower"),
                new Point(2, 4, "g", "lower"),
                new Point(2, 0, "a", "lower"),
                new Point(1, 3, "r", "lower"))));*/

        /*System.out.println(getLengthOfShortestPath(Arrays.asList(
                new Point(2, 4, "g", "lower"),
                new Point(1, 2, "e", "lower"),
                new Point(3, 7, "n", "lower"),
                new Point(1, 4, "t", "lower"),
                new Point(1, 1, "w", "lower"),
                new Point(1, 7, "i", "lower"),
                new Point(3, 4, "c", "lower"),
                new Point(2, 7, "k", "lower"),
                new Point(2, 8, "l", "lower"),
                new Point(1, 2, "e", "lower"),
                new Point(1, 3, "r", "lower"),
                new Point(2, 5, "h", "lower"),
                new Point(1, 2, "e", "lower"),
                new Point(2, 8, "l", "lower"),
                new Point(2, 2, "d", "lower")
        )));*/

        System.out.println(getLengthOfShortestPath(Arrays.asList(
                new Point(2, 4, "g", "lower"),
                new Point(3, 0, "shift", "lower"),
                new Point(3, 1, "shift", "lower"),
                new Point(1, 8, "O", "upper"),
                new Point(3, 0, "shift", "upper"),
                new Point(3, 1, "shift", "upper"),
                new Point(3, 7, "n", "lower"),
                new Point(1, 7, "i", "lower"),
                new Point(3, 3, "x", "lower")
        )));

        System.out.println(getLengthOfShortestPath(Arrays.asList(
                new Point(2, 4, "g", "lower"),
                new Point(3, 0, "shift", "lower"),
                new Point(3, 1, "shift", "lower"),
                new Point(1, 3, "R", "upper"),
                new Point(3, 0, "shift", "upper"),
                new Point(3, 1, "shift", "upper"),
                new Point(2, 0, "a", "lower"),
                new Point(1, 7, "i", "lower"),
                new Point(3, 4, "c", "lower"),
                new Point(2, 5, "h", "lower"),
                new Point(1, 6, "u", "lower")
        )));

    }

    static List<Point> getCoordinates(String nickname) {
        List<Point> path = new ArrayList<>(Arrays.asList(Keyboards.lower[2][4]));

        if (nickname != null && !nickname.isEmpty()) {
            boolean isLowercaseActive = true;
            boolean cIsUppercase;
            for (char c : nickname.toCharArray()) {
                cIsUppercase = Character.isUpperCase(c);
                if (isLowercaseActive && cIsUppercase) {
                    addShiftToPath(path, true);
                    isLowercaseActive = false;

                } else if (!isLowercaseActive && !cIsUppercase) {
                    addShiftToPath(path, false);
                    isLowercaseActive = true;

                }
                Point[][] arr = Keyboards.lower;
                if (cIsUppercase)
                    arr = Keyboards.upper;

                Point pointToAddInPath = Arrays.stream(arr)
                        .flatMap(Arrays::stream)
                        .filter(inArr -> inArr.type.equals(String.valueOf(c)))
                        .findFirst()
                        .get();
                path.add(pointToAddInPath);
            }
        }
        return path;
    }

    static int getLengthOfShortestPath(List<Point> list) {
        int length = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            MyPoint current = new MyPoint(list.get(i));
            MyPoint next = new MyPoint(list.get(i + 1));
            if (current.type.equals(shift) && shift.equals(list.get(i - 1).type)) {
                current = new MyPoint(3, 0, shift, current.keyboardLayer);
            }
            if (!current.type.equals(next.type)) {
                int vertical = Math.abs(next.row - current.row);
                int horizontal = Math.min(Math.abs(next.col - current.col), 11 - Math.abs(next.col - current.col));
                int viaPathFinder = pathFinder(current, next);
                length += Math.min(horizontal + vertical, viaPathFinder);
            }
        }

        return length;
    }

    private static void addShiftToPath(List<Point> path, boolean isLowercaseActive) {
        if (isLowercaseActive) {
            path.add(Keyboards.lower[3][0]);
            path.add(Keyboards.lower[3][1]);
        } else {
            path.add(Keyboards.upper[3][0]);
            path.add(Keyboards.upper[3][1]);
        }
    }

    private static int backtrack(Map<MyPoint, MyPoint> predecessors, MyPoint current, MyPoint next) {
        int result = 1;
        MyPoint from = predecessors.get(next);
        while (!from.equals(current)) {
            result += 1;
            from = predecessors.get(from);
        }

        return result;
    }

    private static int pathFinder(MyPoint current, MyPoint next) {
        distanceMap = new HashMap<>(maxDistanceMap);
        distanceMap.put(current, 0);
        Set<MyPoint> settledNodes = new HashSet<>();
        Queue<MyPoint> unSettledNodes = new PriorityQueue<>(new MyPointComparator());
        unSettledNodes.add(current);
        Map<MyPoint, MyPoint> predecessors = new HashMap<>();

        if (measuredDistances.containsKey(current) && measuredDistances.get(current).containsKey(next))
            return measuredDistances.get(current).get(next);

        while (!unSettledNodes.isEmpty()) {
            MyPoint node = unSettledNodes.poll();
            List<MyPoint> neighbours = new ArrayList<>(neighboursMap.get(node));
            for (MyPoint neighbour : neighbours) {
                if (!settledNodes.contains(neighbour)) {
                    Integer newDistance = distanceMap.get(node) + 1;
                    if (newDistance.compareTo(distanceMap.get(neighbour)) < 1) {
                        unSettledNodes.remove(neighbour);
                        distanceMap.put(neighbour, newDistance);
                        putNewMeasuredDistance(newDistance, current, neighbour);
                        predecessors.put(neighbour, node);
                        unSettledNodes.add(neighbour);
                    }
                }
                if (node.equals(next)) {
                    break;
                }
            }

            settledNodes.add(node);
        }

        int result = backtrack(predecessors, current, next);

        return result;
    }

    private static void putNewMeasuredDistance(Integer newDistance, MyPoint current, MyPoint neighbour) {
        Map<MyPoint, Integer> distanceToMap = Optional.ofNullable(measuredDistances.get(current)).orElse(new HashMap<>());
        distanceToMap.putIfAbsent(neighbour, newDistance);
        measuredDistances.put(current, distanceToMap);
    }

}
