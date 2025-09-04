package models;

import exceptions.InvalidCellStateException;
import exceptions.InvalidRowColException;

public class Move {

    private Cell cell;

    private Player player;

    public Move(Cell cell, Player player){
        this.player = player;
        this.cell = cell;
    }

    public boolean isValidMove(Board board) {
        int row = this.getCell().getRow();
        int col = this.getCell().getCol();

        if(row >= board.getBoard().size() || row <0 || col <0 || col >= board.getBoard().size()){
            System.out.println("Invalid Move! Give legit row and col.");
            return false;

        }
        else if(board.getBoard().get(row).get(col).getCellState().equals(CellState.FILLED)){
            System.out.println("Invalid Move! Position is already acquired.");
            return false;
        }

        return true;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
