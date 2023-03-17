package com.example.entwicklerheld.gameOfLife;

import java.util.List;

public class Game {
    private int columns;
    private int rows;

    public Game(int rows, int columns) {
        this.columns = columns;
        this.rows = rows;
    }

    public void addAliveField(Field field) {
        // Implement this in Scenario 1
        throw new RuntimeException("Not implemented");
    }

    public List<Field> getAliveFields() {
        // Implement this in Scenario 1
        throw new RuntimeException("Not implemented");
    }

    @Override
    public String toString() {
        // Implement this in Scenario 2
        throw new RuntimeException("Not implemented");
    }

    public List<Field> step() {
        // Implement this in Scenario 3 & 4
        throw new RuntimeException("Not implemented");
    }
}
