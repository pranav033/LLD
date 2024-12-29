package org.example.models;

public class Cell {
    public CellState cellState;
    public Player player;
    public int row;
    public int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;
    }
}
