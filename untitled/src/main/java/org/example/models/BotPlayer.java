package org.example.models;

import org.example.strategies.BotPlayingStrategy;

public class BotPlayer extends Player{
    public BotDifficultyLevel botDifficultyLevel;

    public BotPlayer(String name, Character symbol, int id) {
        super(name, symbol, id);
    }

    public BotPlayer(String name, Character symbol, int id, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, id);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        BotPlayingStrategy botPlayingStrategy = BotPlayingStrategyFactory.get(botDifficultyLevel);
        return botPlayingStrategy.makeMove(board);
    }
}
