package Strategy;

import models.Board;
import models.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameStrategy implements GameWinningStrategy{

    List<HashMap<Character,Integer>> rowsCountSymbol = new ArrayList<>();
    List<HashMap<Character,Integer>> colsCountSymbol = new ArrayList<>();

    HashMap<Character,Integer> topLeftDiagSymbolCount = new HashMap<>();
    HashMap<Character,Integer> topRightDiagSymbolCount = new HashMap<>();

    private int count;

    public OrderOneGameStrategy(int dimensions){

        for(int i=0;i<dimensions;i++){
            rowsCountSymbol.add(new HashMap<>());
            colsCountSymbol.add(new HashMap<>());
        }
        count = 0;
    }

    boolean isTopLeftDiagonal(int row,int col){
        return row == col;
    }

    boolean isTopRightDiagonal(int row, int col, int dimension){

        return (row + col) == dimension-1;
    }

    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();
        int dimension = board.getBoard().size();

        rowsCountSymbol.get(row).put(symbol,rowsCountSymbol.get(row).getOrDefault(symbol,0)+1);
        colsCountSymbol.get(col).put(symbol,colsCountSymbol.get(col).getOrDefault(symbol,0)+1);

        if(isTopLeftDiagonal(row,col)){
            topLeftDiagSymbolCount.put(symbol,topLeftDiagSymbolCount.getOrDefault(symbol,0)+1);
        }

        if(isTopRightDiagonal(row,col,dimension)){
            topRightDiagSymbolCount.put(symbol,topRightDiagSymbolCount.getOrDefault(symbol,0)+1);
        }
        count++;

        if(rowsCountSymbol.get(row).get(symbol)== dimension) return true;

        if(colsCountSymbol.get(col).get(symbol) == dimension) return true;

        if(isTopLeftDiagonal(row,col) && topLeftDiagSymbolCount.get(symbol) == dimension) return true;

        if(isTopRightDiagonal(row,col,dimension) && topRightDiagSymbolCount.get(symbol) == dimension) return true;

        return false;
    }

    @Override
    public void removeLastMove(Move move,Board board) {

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol();

        rowsCountSymbol.get(row).put(symbol,rowsCountSymbol.get(row).get(symbol)-1);
        colsCountSymbol.get(col).put(symbol,colsCountSymbol.get(col).get(symbol)-1);

        if(isTopLeftDiagonal(row,col)){
            topLeftDiagSymbolCount.put(symbol,topLeftDiagSymbolCount.get(symbol)-1);
        }

        if(isTopRightDiagonal(row,col,board.getBoard().size())){
            topRightDiagSymbolCount.put(symbol,topRightDiagSymbolCount.get(symbol)-1);
        }
        count--;
    }

    @Override
    public boolean checkDraw(Board board) {
        int dimension = board.getBoard().size();

        return count == dimension*dimension;
    }


}
