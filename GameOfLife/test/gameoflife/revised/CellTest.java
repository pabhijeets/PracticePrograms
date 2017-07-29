package gameoflife.revised;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CellTest {
    @Test
    public void testDeathByUnderPopulation() {
        int liveNeighbours = 1;
        Cell cell = CellFactory.getCell(true);
        Cell evolvedCell = cell.evolve(liveNeighbours);
        assertFalse(evolvedCell.isAlive());
    }

    @Test
    public void testDeathByOverPopulation() {
        int liveNeighbours = 4;
        Cell cell = CellFactory.getCell(true);
        Cell evolvedCell = cell.evolve(liveNeighbours);
        assertFalse(evolvedCell.isAlive());
    }

    @Test
    public void testSurvivalOfCell() {
        int liveNeighbours = 3;
        Cell cell = CellFactory.getCell(true);
        Cell evolvedCell = cell.evolve(liveNeighbours);
        assertTrue(evolvedCell.isAlive());
    }

    @Test
    public void testRebirthOfCell() {
        int liveNeighbours = 3;
        Cell cell = CellFactory.getCell(false);
        Cell evolvedCell = cell.evolve(liveNeighbours);
        assertTrue(evolvedCell.isAlive());
    }
}
