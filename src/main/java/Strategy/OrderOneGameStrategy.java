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

    public OrderOneGameStrategy(int dimensions){

        for(int i=0;i<dimensions;i++){
            rowsCountSymbol.add(new HashMap<>());
            colsCountSymbol.add(new HashMap<>());
        }
    }

    @Override
    public boolean checkWinner(Board board, Move move) {

        return false;
    }
}
