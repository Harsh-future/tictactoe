package models;

import java.util.Scanner;

public class Player {

    private String name;

    private Character symbol;

    private PlayerType playerType;

    private static Scanner scanner = new Scanner(System.in);

    public Player(String name, Character symbol, PlayerType playerType){
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Move decideToMove(Board board){

        System.out.println("Enter the rol to make the move");
        int row = scanner.nextInt();

        System.out.println("Enter the col to make the move");
        int col = scanner.nextInt();

        return new Move(new Cell(row,col),this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

}
