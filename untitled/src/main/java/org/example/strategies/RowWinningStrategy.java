package org.example.strategies;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.CellState;
import org.example.models.Move;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        int row = lastMove.cell.row;
        for(int i = 0;i< board.n;i++)
        {
            Cell cell = board.cells.get(row).get(i);
            if(cell.cellState== CellState.EMPTY || cell.player.symbol!=lastMove.cell.player.symbol)
                return false;
        }
        return true;
    }
}
