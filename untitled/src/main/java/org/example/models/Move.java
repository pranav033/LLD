package org.example.models;

public class Move {

    public Cell cell;

    public Move(int r, int c) {
        this.cell = new Cell(r, c);
    }
}
