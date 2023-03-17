package com.example.graphtraversals;


import com.example.graphtraversals.bfs.BreadthFirstSearch;
import com.example.graphtraversals.dfs.DepthFirstSearch;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var v0 = new Vertex<Integer>(0);
        var v1 = new Vertex<Integer>(1);
        var v2 = new Vertex<Integer>(2);
        var v3 = new Vertex<Integer>(3);
        var v4 = new Vertex<Integer>(4);
        var v5 = new Vertex<Integer>(5);
        var v6 = new Vertex<Integer>(6);

        v0.setNeighbours(Arrays.asList(v1, v5, v6));
        v1.setNeighbours(Arrays.asList(v3, v4, v5));
        v4.setNeighbours(Arrays.asList(v2, v6));
        v6.setNeighbours(Arrays.asList(v0));

        var dfs = new DepthFirstSearch<Integer>();
        //dfs.traverse(v0);

        var bfs = new BreadthFirstSearch<Integer>();
        bfs.traverse(v0);

    }
}
