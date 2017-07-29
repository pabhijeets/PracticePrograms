package gameoflife.revised;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest {

    @Test
    public void testDeathByUnderPopulation() {

        //Given
        Cell[][] seedState = new Cell[3][3];
        seedState[0][0] = CellFactory.getCell(true);
        seedState[0][1] = CellFactory.getCell(true);
        seedState[0][2] = CellFactory.getCell(true);

        seedState[1][0] = CellFactory.getCell(false);
        seedState[1][1] = CellFactory.getCell(false);
        seedState[1][2] = CellFactory.getCell(false);

        seedState[2][0] = CellFactory.getCell(false);
        seedState[2][1] = CellFactory.getCell(false);
        seedState[2][2] = CellFactory.getCell(false);

        //when
        Board lifeBoard = new Board(seedState);
        lifeBoard.tick();

        //then
        Cell[][] state = lifeBoard.getState();
        assertFalse(state[0][0].isAlive());
        assertTrue(state[0][1].isAlive());
        assertFalse(state[0][2].isAlive());

    }

    @Test
    public void testDeathByOverPopulation() {

        //Given
        Cell[][] seedState = new Cell[3][3];
        seedState[0][0] = CellFactory.getCell(false);
        seedState[0][1] = CellFactory.getCell(true);
        seedState[0][2] = CellFactory.getCell(false);

        seedState[1][0] = CellFactory.getCell(true);
        seedState[1][1] = CellFactory.getCell(true);
        seedState[1][2] = CellFactory.getCell(true);

        seedState[2][0] = CellFactory.getCell(false);
        seedState[2][1] = CellFactory.getCell(true);
        seedState[2][2] = CellFactory.getCell(false);

        //when
        Board lifeBoard = new Board(seedState);
        lifeBoard.tick();

        //then
        Cell[][] state = lifeBoard.getState();
        assertTrue(state[0][0].isAlive());
        assertTrue(state[0][1].isAlive());
        assertTrue(state[0][2].isAlive());
        assertTrue(state[1][0].isAlive());
        assertTrue(state[1][2].isAlive());
        assertTrue(state[2][1].isAlive());

        assertFalse(state[1][1].isAlive());
    }

    @Test
    public void testSurvivalOfCell() {

        //Given
        Cell[][] seedState = new Cell[3][3];
        seedState[0][0] = CellFactory.getCell(false);
        seedState[0][1] = CellFactory.getCell(true);
        seedState[0][2] = CellFactory.getCell(false);

        seedState[1][0] = CellFactory.getCell(true);
        seedState[1][1] = CellFactory.getCell(true);
        seedState[1][2] = CellFactory.getCell(true);

        seedState[2][0] = CellFactory.getCell(false);
        seedState[2][1] = CellFactory.getCell(false);
        seedState[2][2] = CellFactory.getCell(false);

        //when
        Board lifeBoard = new Board(seedState);
        lifeBoard.tick();

        //then
        Cell[][] state = lifeBoard.getState();
        assertTrue(state[0][0].isAlive());
        assertTrue(state[0][1].isAlive());
        assertTrue(state[0][2].isAlive());
        assertTrue(state[1][0].isAlive());
        assertTrue(state[1][1].isAlive());
        assertTrue(state[1][2].isAlive());
        assertTrue(state[2][1].isAlive());
        assertTrue(state[1][1].isAlive());
    }

    @Test
    public void testRebirthOfCell() {

        //Given
        Cell[][] seedState = new Cell[4][4];
        seedState[0][0] = CellFactory.getCell(true);
        seedState[0][1] = CellFactory.getCell(false);
        seedState[0][2] = CellFactory.getCell(true);
        seedState[0][3] = CellFactory.getCell(false);


        seedState[1][0] = CellFactory.getCell(true);
        seedState[1][1] = CellFactory.getCell(true);
        seedState[1][2] = CellFactory.getCell(true);
        seedState[1][3] = CellFactory.getCell(false);

        seedState[2][0] = CellFactory.getCell(false);
        seedState[2][1] = CellFactory.getCell(false);
        seedState[2][2] = CellFactory.getCell(false);
        seedState[2][3] = CellFactory.getCell(false);

        seedState[3][0] = CellFactory.getCell(false);
        seedState[3][1] = CellFactory.getCell(false);
        seedState[3][2] = CellFactory.getCell(false);
        seedState[3][3] = CellFactory.getCell(false);

        //when
        Board lifeBoard = new Board(seedState);
        lifeBoard.tick();

        //then
        Cell[][] state = lifeBoard.getState();
        assertTrue(state[0][0].isAlive());
        assertTrue(state[0][2].isAlive());
        assertTrue(state[1][0].isAlive());
        assertFalse(state[1][1].isAlive());
        assertTrue(state[1][2].isAlive());
        assertTrue(state[2][1].isAlive());

    }

}
