package org.example.strategies;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.CellState;
import org.example.models.Move;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move lastMove) {
        for(int i = 0;i<board.n;i++)
        {
            Cell cell = board.cells.get(i).get(i);
            if(cell.cellState== CellState.EMPTY || cell.player.symbol!=lastMove.cell.player.symbol)
                return false;
        }

        for(int i = board.n-1;i>=0;i--)
        {
            Cell cell = board.cells.get(i).get(i);
            if(cell.cellState== CellState.EMPTY || cell.player.symbol!=lastMove.cell.player.symbol)
                return false;
        }
        return true;
    }
}
