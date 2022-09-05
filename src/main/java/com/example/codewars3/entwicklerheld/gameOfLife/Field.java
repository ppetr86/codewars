package com.example.codewars3.entwicklerheld.gameOfLife;

public class Field {

    public int row;
    public int column;

    public Field(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Field otherField) {
            return otherField.column == this.column && otherField.row == this.row;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Fiel(row: " + this.row + " , column: " + this.column + ")";
    }
}
