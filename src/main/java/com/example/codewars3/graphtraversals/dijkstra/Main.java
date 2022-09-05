package com.example.codewars3.graphtraversals.dijkstra;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var a = new Node("A");
        var b = new Node("B");
        var c = new Node("main.java.C");
        var d = new Node("main.java.D");
        var e = new Node("E");
        var f = new Node("F");

        a.addAdjacentNode(b, 2);
        a.addAdjacentNode(c, 4);

        b.addAdjacentNode(c, 3);
        b.addAdjacentNode(d, 1);
        b.addAdjacentNode(e, 5);

        c.addAdjacentNode(d, 2);

        d.addAdjacentNode(e, 1);
        d.addAdjacentNode(f, 4);

        e.addAdjacentNode(f, 2);

        var dijkstra = new DijkstraAlgo();
        dijkstra.calculateShortestPath(a);

        DijkstraAlgo.printPaths(Arrays.asList(a, b, c, d, e, f));
    }
}
