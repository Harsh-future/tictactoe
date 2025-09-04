package controller;

import exceptions.InvalidCellStateException;
import exceptions.InvalidRowColException;
import models.Game;
import models.GameStatus;
import models.Move;
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

        game.undo();
    }

    public boolean executeNextMove(Game game){
        return game.makeNextMove();
    }

    public Player getNextPlayer(Game game){
        return game.getPlayers().get(game.getNextPlayerIndex());
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }

    public void displayBoard(Game game){
        game.displayBoard(game);
    }
}
