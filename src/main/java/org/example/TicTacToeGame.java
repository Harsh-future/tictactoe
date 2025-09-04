package org.example;

import controller.GameController;
import exceptions.InvalidCellStateException;
import exceptions.InvalidRowColException;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame{
    public static void main(String[] args) throws InvalidCellStateException, InvalidRowColException {

        System.out.println("Game is starting......");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the dimensions of the game.");
        int dimension = scanner.nextInt();
        int playerNumber = dimension;

        List<Player> players = new ArrayList<>();

        System.out.println("Will there be any bot?");
        String ans = scanner.next();

        if(ans.equals("y")){
            playerNumber= playerNumber-1;
            System.out.println("What is the name of the Bot?");
            String botName = scanner.next();

            System.out.println("What is the symbol of the Bot?");
            Character botSymbol = scanner.next().charAt(0);

            Bot bot = new Bot(botName,botSymbol, BotDifficultyLevel.EASY);
            players.add(bot);
        }

        for(int i=1;i<playerNumber;i++){
            System.out.println("What is the name of player" + i + "?");
            String name = scanner.next();

            System.out.println("What is the symbol of the player" + i + "?");
            Character symbol = scanner.next().charAt(0);

            Player player = new Player(name,symbol, PlayerType.HUMAN);
            players.add(player);
        }

        GameController gameController = new GameController();
        Game game = gameController.createGame(dimension,players);

        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)) {

            System.out.println("Current state of the game");
            gameController.displayBoard(game);

            gameController.executeNextMove(game);

            System.out.println("Do you want to undo? y/n");
            String input = scanner.next();

            if(input.equals("y")){
                gameController.undo(game);
            }
        }


        if(gameController.getGameStatus(game).equals(GameStatus.DRAW)){
            System.out.println("Game is drawn. Nobody is the winner");
        }

        if(gameController.getGameStatus(game).equals(GameStatus.ENDED)){
            System.out.println("Game Ended!!");
            System.out.println("Game is won by " + game.getWinner().getName());
        }

    }
}