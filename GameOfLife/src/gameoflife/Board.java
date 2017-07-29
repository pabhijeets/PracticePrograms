package gameoflife;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private static final int MINIMUM_POPULATION = 2;
    private static final int MAXIMUM_POPULATION = 3;
    private static final int REPRODUCTION_POPULATION = 3;

    enum Action{
        NO_ACTION,SURVIVE,DIE,BIRTH;
    }

    private final BoardCell[][] state;

    public Board(BoardCell[][] state) {
        this.state = state;
    }

    public BoardCell[][] getState() {
        return state;
    }

    public void tick() {
        Map<Action,List<BoardCell>> actions = new HashMap<>();
        for(int rowIndex=0;rowIndex<state.length;rowIndex++){
            BoardCell[] row = state[rowIndex];
            for(int columnIndex=0;columnIndex<row.length;columnIndex++){
                int liveNeighbours = getLiveNeighbours(rowIndex, columnIndex);
                BoardCell boardCell = state[rowIndex][columnIndex];
                Action action = getNextAction(boardCell,liveNeighbours);

                List<BoardCell> cells = actions.get(action);
                if(cells==null){
                    cells = new ArrayList<>();
                    actions.put(action,cells);
                }
                cells.add(boardCell);
            }
        }

        List<BoardCell> cellsToDie = actions.get(Action.DIE);
        if(cellsToDie !=null) {
            cellsToDie.stream().forEach(boardCell -> boardCell.setAlive(false));
        }

        List<BoardCell> cellsToBorn = actions.get(Action.BIRTH);
        if(cellsToBorn !=null) {
            cellsToBorn.stream().forEach(boardCell -> boardCell.setAlive(true));
        }
    }

    private Action getNextAction(BoardCell boardCell, int liveNeighbours) {
        Action nextAction = Action.NO_ACTION;
        if(boardCell.isAlive()){
            if(liveNeighbours<MINIMUM_POPULATION || liveNeighbours>MAXIMUM_POPULATION)
                nextAction=Action.DIE;
        }else{
            if(liveNeighbours==REPRODUCTION_POPULATION)
                nextAction=Action.BIRTH;
        }
        return nextAction;
    }

    private int getLiveNeighbours(int rowIndex, int columnIndex) {
        int liveNeighbours = 0;
        if(isAlive(rowIndex-1,columnIndex-1))
            liveNeighbours++;
        if(isAlive(rowIndex-1,columnIndex))
            liveNeighbours++;
        if(isAlive(rowIndex-1,columnIndex+1))
            liveNeighbours++;

        if(isAlive(rowIndex,columnIndex-1))
            liveNeighbours++;
        if(isAlive(rowIndex,columnIndex+1))
            liveNeighbours++;


        if(isAlive(rowIndex+1,columnIndex-1))
            liveNeighbours++;
        if(isAlive(rowIndex+1,columnIndex))
            liveNeighbours++;
        if(isAlive(rowIndex+1,columnIndex+1))
            liveNeighbours++;
        return liveNeighbours;
    }

    private boolean isAlive(int row, int col) {
        return (row==-1 || row==state.length || col==-1 || col==state[0].length) ? false : state[row][col].isAlive();
    }

}