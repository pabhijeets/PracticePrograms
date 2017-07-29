package gameoflife.revised;

/**
 * Created by chhota-bhim on 7/7/17.
 */
public class DeadCell implements Cell {
    private static final int REPRODUCTION_POPULATION = 3;

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public Cell evolve(int numLiveNeighbors) {
        return CellFactory.getCell(numLiveNeighbors == REPRODUCTION_POPULATION);
    }
}
