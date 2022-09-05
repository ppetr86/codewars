package com.example.codewars3.entwicklerheld.queens;

public class Position {
    int rowIndex;
    int columnIndex;

    public Position(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public int rowIndex() {
        return this.rowIndex;
    }

    public int columnIndex() {
        return this.columnIndex;
    }

    public int leftDiagonal() {
        return this.rowIndex - this.columnIndex;
    }

    public int rightDiagonal() {
        return this.rowIndex + this.columnIndex;
    }

    public String toString() {
        return "(" + this.rowIndex + ", " + this.columnIndex + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position) || obj == null) {
            return false;
        }
        Position position = (Position) obj;
        return (this.rowIndex == position.rowIndex && this.columnIndex == position.columnIndex);
    }
}
