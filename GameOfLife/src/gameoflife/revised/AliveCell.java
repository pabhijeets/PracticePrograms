package gameoflife.revised;

/**
 * Created by chhota-bhim on 7/7/17.
 */
public class AliveCell implements Cell {
    private static final int MINIMUM_POPULATION = 2;
    private static final int MAXIMUM_POPULATION = 3;


    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public Cell evolve(int liveNeighbours) {
        return CellFactory.getCell(!(liveNeighbours<MINIMUM_POPULATION || liveNeighbours>MAXIMUM_POPULATION));
    }
}
