package org.example.strategies;

import org.example.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class MediumBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board) {
        List<Cell> cells = new ArrayList<Cell>();


        int n = board.n;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board.cells.get(i).get(j).cellState == CellState.EMPTY)
                {
                    cells.add(board.cells.get(i).get(j));
                }
            }
        }
        int x = RandomGenerator.getDefault().nextInt() % cells.size();
        Cell cell = cells.get(x);
        return new Move(cell.row, cell.col);
    }
}
