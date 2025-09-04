package factory;

import Strategy.BotPlayingStrategy;
import Strategy.EasyBotPlayingStrategy;
import Strategy.HardBotPlayingStrategy;
import Strategy.MediumBotPlayingStrategy;
import models.BotDifficultyLevel;

public class BotDifficultyfactory {

    public static BotPlayingStrategy BotStrategyByDifficultyLevel(BotDifficultyLevel botDifficultyLevel){

        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
            return new EasyBotPlayingStrategy();
        }
        else if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)){
            return new MediumBotPlayingStrategy();
        }
        else if(botDifficultyLevel.equals(BotDifficultyLevel.HARD)){
            return new HardBotPlayingStrategy();
        }

        return null;
    }
}
