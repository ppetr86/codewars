package com.example.graphtraversals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Vertex<T> {
    private final T data;
    private boolean visited;
    private List<Vertex<T>> neighbours = new ArrayList<>();

    public Vertex(T data, boolean visited, List<Vertex<T>> neighbours) {
        this.data = data;
        this.visited = visited;
        this.neighbours = neighbours;
    }

    public Vertex(T i) {
        this.data = i;
    }

    public T getData() {
        return data;
    }

    public List<Vertex<T>> getNeighbours() {
        return neighbours;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setNeighbours(List<Vertex<T>> neighbours) {
        this.neighbours = neighbours;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data= " + this.getData().toString() +
                ", visited= " + visited +
                ", neighbours= " + neighbours.stream().map(n -> n.data.toString()).collect(Collectors.joining(", ")) +
                '}';
    }
}
