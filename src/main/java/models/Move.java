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

    public boolean isValidMove(Board board) throws InvalidRowColException, InvalidCellStateException {
        int row = this.getCell().getRow();
        int col = this.getCell().getCol();

        if(row >= board.getBoard().size() || row <0 || col <0 || col >= board.getBoard().size()){
            throw new InvalidRowColException("Row or Col are going out of bounds of the board.");
        }
        else if(board.getBoard().get(row).get(col).getCellState().equals(CellState.FILLED)){
            throw new InvalidCellStateException("Position is already filled by another player.");
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
