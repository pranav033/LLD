package org.example.controller;

import org.example.models.*;
import org.example.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public Game startGame(
            List<Player> players,
            List<WinningStrategy> winningStrategies,
            int dimension
    )
    {
        return Game.getBuilder()
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .setCurrentPlayerIndex(0)
                .setGameState(GameState.ONGOING)
                .setBoard(new Board(dimension))
                .setMoves(new ArrayList<>())
                .build();

    }

    public static String displayBoard(Game game)
    {
        return game.board.toString();
    }

    public static GameState getGameState(Game game)
    {
        return game.gameState;
    }


    public void makeNextMove(Game game) {
        Player player = game.players.get(game.currentPlayerIndex);
        System.out.println("Next move: " + player.name);
        Move move = player.makeMove(game.board);
        move.cell.player = player;
        move.cell.cellState = CellState.OCCUPIED;
        validate(move,game.board);
        update(game.board,move.cell,player);
        checkWinningStrategies(game,move);

        game.moves.add(move);
        game.currentPlayerIndex+=1;
        game.currentPlayerIndex%=game.players.size();

        if(game.gameState==GameState.ONGOING) checkIfNoMoreCells(game);

    }

    public void undoMove(Game game)
    {
        Move lastMove = game.moves.get(game.moves.size() - 1);
        game.moves.remove(lastMove);
        Cell lastCell = game.board.cells.get(lastMove.cell.row).get(lastMove.cell.col);
        lastCell.cellState = CellState.EMPTY;
        lastMove.cell.player = null;

        game.currentPlayerIndex-=1;
        if(game.currentPlayerIndex<0)
        {
            game.currentPlayerIndex=game.players.size()-1;
        }
    }

    private static void checkIfNoMoreCells(Game game) {
        if(game.moves.size() == game.board.n * game.board.n) {
            game.gameState = GameState.DRAW;
            System.out.println("Game ended in a draw");
            System.out.println(GameController.displayBoard(game));

        }
    }

    public static void checkWinningStrategies(Game game, Move move)
    {
        for(WinningStrategy winningStrategy : game.winningStrategies)
        {
            if(winningStrategy.checkWinner(game.board,move))
            {
                game.gameState = GameState.COMPLETED;
                game.winner = move.cell.player;
                System.out.println(game.winner.name+ " is the winner");
                System.out.println(game.board.toString());
            }
        }

    }

    public static void update(Board board, Cell cell, Player player) {
        int r = cell.row;
        int c = cell.col;

        Cell cellToBeUpdated = board.cells.get(r).get(c);
        cellToBeUpdated.cellState = CellState.OCCUPIED;
        cellToBeUpdated.player = player;

    }

    public static void validate(Move move, Board board) {
        Cell cell = move.cell;
        if(cell.row<0 || cell.row>= board.n || cell.col<0 || cell.col> board.n ||
                board.cells.get(cell.row).get(cell.col).cellState!=CellState.EMPTY)
        {
            throw new IllegalArgumentException("Invalid move");
        }

    }
}
