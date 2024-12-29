package org.example;

import org.example.controller.GameController;
import org.example.models.*;
import org.example.strategies.ColWinningStrategy;
import org.example.strategies.DiagonalWinningStrategy;
import org.example.strategies.RowWinningStrategy;
import org.example.strategies.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        Game g1 = Game.getBuilder()
//                .setGameState(GameState.INITIALISING)
//                .setMoves(null)
//                .setBoard(null)
//                .setPlayers(null)
//                .setCurrentPlayerIndex(0)
//                .setWinningStrategies(null)
//                .build();
//        System.out.println(g1);

        List<WinningStrategy> winningStrategies = new ArrayList<WinningStrategy>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        GameController gameController = new GameController();
        Game game = gameController.startGame(List.of(new HumanPlayer("Pranav",'X',1),
                        new BotPlayer("Rahul",'0',2, BotDifficultyLevel.EASY)),
                winningStrategies,
                3);
       // System.out.println(game.board);

        while(gameController.getGameState(game)==GameState.ONGOING)
        {
            System.out.println(gameController.displayBoard(game));
            gameController.makeNextMove(game);
        }

    }
}
