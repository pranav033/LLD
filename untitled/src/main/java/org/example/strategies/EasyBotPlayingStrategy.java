package org.example.strategies;

import org.example.models.Board;
import org.example.models.CellState;
import org.example.models.Game;
import org.example.models.Move;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeMove(Board board) {
        int n = board.n;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board.cells.get(i).get(j).cellState == CellState.EMPTY)
                {
                    return new Move(i,j);
                }
            }
        }
        return null;
    }
}
