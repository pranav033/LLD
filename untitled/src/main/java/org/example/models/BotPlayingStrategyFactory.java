package org.example.models;

import org.example.strategies.BotPlayingStrategy;
import org.example.strategies.EasyBotPlayingStrategy;
import org.example.strategies.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {


    public static BotPlayingStrategy get(BotDifficultyLevel botDifficultyLevel)
    {
        return switch(botDifficultyLevel) {
            case EASY -> new EasyBotPlayingStrategy();
            default -> new MediumBotPlayingStrategy();
        };
    }
}
