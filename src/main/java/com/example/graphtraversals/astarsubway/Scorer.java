package com.example.graphtraversals.astarsubway;

public interface Scorer<T extends GraphNode> {
    double computeCost(T from, T to);
}
