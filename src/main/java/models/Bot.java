package models;

import Strategy.BotPlayingStrategy;
import factory.BotDifficultyfactory;
import lombok.Setter;

public class Bot extends Player{

    @Setter
    @lombok.Getter
    private BotDifficultyLevel botDifficultyLevel;

    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, Character symbol, BotDifficultyLevel botDifficultyLevel){
        super(name,symbol,PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotDifficultyfactory.BotStrategyByDifficultyLevel(botDifficultyLevel);
    }

    @Override
    public Move decideToMove(Board board){
        return botPlayingStrategy.decideMove(this,board);
    }

}
