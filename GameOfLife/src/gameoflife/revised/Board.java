package gameoflife.revised;



public class Board {
    private final Cell[][] seedState;
    private Cell[][] currentState;

    public Board(Cell[][] state) {
        this.seedState = state;
        this.currentState = state;
    }

    public Cell[][] getState() {
        return currentState;
    }

    public void tick() {
        Cell[][] nextGenerationState = new Cell[currentState.length][currentState[0].length];
        for(int rowIndex=0;rowIndex<currentState.length;rowIndex++) {
            Cell[] row = currentState[rowIndex];
            for (int columnIndex = 0; columnIndex < row.length; columnIndex++) {
                int liveNeighbours = getLiveNeighbours(rowIndex, columnIndex);
                Cell cell = currentState[rowIndex][columnIndex];
                nextGenerationState[rowIndex][columnIndex] = cell.evolve(liveNeighbours);
            }
        }
        currentState = nextGenerationState;
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
        return (row==-1 || row==currentState.length || col==-1 || col==currentState[0].length) ? false : currentState[row][col].isAlive();
    }
}
