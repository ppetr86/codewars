package com.example.graphtraversals.bfs;

import com.example.graphtraversals.Vertex;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<T> {


    public void traverse(Vertex<T> startingVertex) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(startingVertex);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.poll();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current);
                queue.addAll(current.getNeighbours());
            }
        }
    }
}
