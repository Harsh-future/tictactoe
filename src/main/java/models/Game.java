package models;


import exceptions.InvalidCellStateException;
import exceptions.InvalidDimesionException;
import exceptions.InvalidPlayerNumberException;
import exceptions.InvalidRowColException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private List<Player> players;

    private Board board;

    private GameStatus gameStatus;

    private List<Move> moves;

    private int nextPlayerIndex;

    private Player winner;

    private static Scanner scanner = new Scanner(System.in);

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void displayBoard(Game game){
        board.displayBoard(game);
    }

    public void makeNextMove() throws InvalidCellStateException, InvalidRowColException {

        //1. Player should allow to make the move
        //2. Check whether the move is valid or not.

        Player playerToMove = players.get(nextPlayerIndex);

        System.out.println("Its player " + playerToMove.getName()+ " time to move.");

        Move move = playerToMove.decideToMove(board);

        //validation of move

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(move.isValidMove(board)){
            //make the cell filled and save the move.
            board.applyMove(move);
            moves.add(move);

            //check if there is a winner or drawn.


            //make next move
            nextPlayerIndex += 1;
            nextPlayerIndex = nextPlayerIndex % players.size();
        }

    }

    private Game(){};

    public static Builder getBuilder(){
        return new Builder();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }


    public static class Builder{

        private int dimensions;

        private List<Player> players;

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private void isValid() throws InvalidDimesionException, InvalidPlayerNumberException {


            if(dimensions <3){
                throw new InvalidDimesionException("Dimension of the game board should be greater than or equal to 3.");
            }

            if(players.size() != dimensions -1){
                throw new InvalidPlayerNumberException("Number of players should be 1 less than the dimension of the game board.");
            }

        }

        public Game build(){

            // do validations before building the game.
            try{
                isValid();
            }
            catch (InvalidDimesionException | InvalidPlayerNumberException e) {
                System.out.println(e.getMessage());
                return null;
            }

            //game is valid
            Game game = new Game();
            game.setBoard(new Board(dimensions));
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setMoves(new ArrayList<>());
            game.setPlayers(players);
            game.setNextPlayerIndex(0);
            return game;
        }
    }



}
