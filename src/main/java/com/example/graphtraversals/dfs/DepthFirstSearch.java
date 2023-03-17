package com.example.graphtraversals.dfs;

import com.example.graphtraversals.Vertex;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstSearch<T> {
    public void traverse(Vertex<T> startVertex) {
        Deque<Vertex<T>> stack = new LinkedList<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            Vertex<T> current = stack.pop();

            if (!current.isVisited()) { //kdyby to tam nebylo, tak mi hrozi nekonecna smycka..
                current.setVisited(true);

                System.out.println(current);
                Collections.reverse(current.getNeighbours());
                current.getNeighbours().forEach(stack::push);
            }
        }
    }

    public void traverseRecursively(Vertex<T> startVertex) {
        startVertex.setVisited(true);
        System.out.println(startVertex);
        startVertex.getNeighbours().stream() //
                .filter(n -> !n.isVisited()) //
                .forEach(neighbor -> {
                    if (!neighbor.isVisited()) {
                        traverseRecursively(neighbor);
                    }
                });
    }
}
