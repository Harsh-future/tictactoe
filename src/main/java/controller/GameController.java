package controller;

import models.Game;
import models.GameStatus;
import models.Player;

import java.util.List;

public class GameController {


    public Game createGame(int dimensions, List<Player> players){
        Game game = Game.getBuilder()
                .setDimensions(dimensions)
                .setPlayers(players)
                .build();
        return game;
    }

    public void undo(Game game){

        // add undo feature
    }

    public void makeMoves(Game game){

    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public void displayBoard(Game game){
        game.displayBoard(game);
    }
}
