package org.example.models;

import org.example.strategies.WinningStrategy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    public List<Player> players;
    public Board board;
    public int currentPlayerIndex;
    public List<WinningStrategy> winningStrategies;
    public GameState gameState;
    public List<Move> moves;
    public Player winner;

    @Override
    public String toString() {
        return "Game{" +
                "players=" + players +
                ", board=" + board +
                ", currentPlayerIndex=" + currentPlayerIndex +
                ", winningStrategies=" + winningStrategies +
                ", gameState=" + gameState +
                ", moves=" + moves +
                '}';
    }

    private Game(Builder builder)
    {

        this.players = builder.players;
        this.board = builder.board;
        this.currentPlayerIndex = builder.currentPlayerIndex;
        this.winningStrategies = builder.winningStrategies;
        this.gameState = builder.gameState;
        this.moves = builder.moves;
    }

    public static Builder getBuilder()
    {
        return new Builder();
    }

    public static class Builder
    {
        List<Player> players;
        Board board;
        int currentPlayerIndex;
        List<WinningStrategy> winningStrategies;
        GameState gameState;
        List<Move> moves;

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Board getBoard() {
            return board;
        }

        public Builder setBoard(Board board) {
            this.board = board;
            return this;
        }

        public int getCurrentPlayerIndex() {
            return currentPlayerIndex;
        }

        public Builder setCurrentPlayerIndex(int currentPlayerIndex) {
            this.currentPlayerIndex = currentPlayerIndex;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public GameState getGameState() {
            return gameState;
        }

        public Builder setGameState(GameState gameState) {
            this.gameState = gameState;
            return this;
        }

        public List<Move> getMoves() {
            return moves;
        }

        public Builder setMoves(List<Move> moves) {
            this.moves = moves;
            return this;
        }

        public Game build()
        {
            Set<Character> symbolSet = new HashSet<>();
            for(Player player : players)
            {
                symbolSet.add(player.symbol);
            }
            if(symbolSet.size() != players.size())
            {
                throw new IllegalArgumentException("The symbol set does not match the number of players");
            }

            return new Game(this);
        }
    }
}
