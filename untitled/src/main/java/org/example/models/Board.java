package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public int n;
    public List<List<Cell>> cells;

    public Board(int n) {
        this.n = n;
        this.cells = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            cells.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                cells.get(i).add(new Cell(i,j));
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++)
        {
            for(int j = 0;j<n;j++)
            {
                Cell cell = cells.get(i).get(j);
                if(cell.cellState==CellState.EMPTY)
                {
                    sb.append("# ");
                }
                else sb.append(cell.player.symbol+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
