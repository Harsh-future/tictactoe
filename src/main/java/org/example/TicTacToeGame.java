package org.example;

import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame{
    public static void main(String[] args) {

        System.out.println("Game is starting......");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the dimensions of the game.");
        int dimension = scanner.nextInt();

        List<Player> players = new ArrayList<>();

        System.out.println("Will there be any bot?");
        String ans = scanner.next();

        if(ans.equals("y")){
            dimension= dimension-1;
            System.out.println("What is the name of the Bot?");
            String botName = scanner.next();

            System.out.println("What is the symbol of the Bot?");
            String botSymbol = scanner.next();

            Bot bot = new Bot(botName,botSymbol, BotDifficultyLevel.EASY);
        }

        for(int i=1;i<dimension;i++){
            System.out.println("What is the name of player" + i + "?");
            String name = scanner.next();

            System.out.println("What is the symbol of the player" + i + "?");
            String symbol = scanner.next();

            Player player = new Player(name,symbol, PlayerType.HUMAN);
            players.add(player);
        }


        Game game = Game.getBuilder()
                    .setDimensions(dimension)
                    .setPlayers(players)
                    .build();



    }
}