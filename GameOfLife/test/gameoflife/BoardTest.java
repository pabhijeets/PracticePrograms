package gameoflife;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardTest {

    @Test
    public void testDeathByUnderPopulation() {

        //Given
        BoardCell[][] seedState = new BoardCell[3][3];
        seedState[0][0] = new BoardCell(true);
        seedState[0][1] = new BoardCell(true);
        seedState[0][2] = new BoardCell(true);

        seedState[1][0] = new BoardCell(false);
        seedState[1][1] = new BoardCell(false);
        seedState[1][2] = new BoardCell(false);

        seedState[2][0] = new BoardCell(false);
        seedState[2][1] = new BoardCell(false);
        seedState[2][2] = new BoardCell(false);

        //when
        Board lifeBoard = new Board(seedState);
        lifeBoard.tick();

        //then
        BoardCell[][] state = lifeBoard.getState();
        assertFalse(state[0][0].isAlive());
        assertTrue(state[0][1].isAlive());
        assertFalse(state[0][2].isAlive());

    }

    @Test
    public void testDeathByOverPopulation() {

        //Given
        BoardCell[][] seedState = new BoardCell[3][3];
        seedState[0][0] = new BoardCell(false);
        seedState[0][1] = new BoardCell(true);
        seedState[0][2] = new BoardCell(false);

        seedState[1][0] = new BoardCell(true);
        seedState[1][1] = new BoardCell(true);
        seedState[1][2] = new BoardCell(true);

        seedState[2][0] = new BoardCell(false);
        seedState[2][1] = new BoardCell(true);
        seedState[2][2] = new BoardCell(false);

        //when
        Board lifeBoard = new Board(seedState);
        lifeBoard.tick();

        //then
        BoardCell[][] state = lifeBoard.getState();
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
        BoardCell[][] seedState = new BoardCell[3][3];
        seedState[0][0] = new BoardCell(false);
        seedState[0][1] = new BoardCell(true);
        seedState[0][2] = new BoardCell(false);

        seedState[1][0] = new BoardCell(true);
        seedState[1][1] = new BoardCell(true);
        seedState[1][2] = new BoardCell(true);

        seedState[2][0] = new BoardCell(false);
        seedState[2][1] = new BoardCell(false);
        seedState[2][2] = new BoardCell(false);

        //when
        Board lifeBoard = new Board(seedState);
        lifeBoard.tick();

        //then
        BoardCell[][] state = lifeBoard.getState();
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
        BoardCell[][] seedState = new BoardCell[4][4];
        seedState[0][0] = new BoardCell(true);
        seedState[0][1] = new BoardCell(false);
        seedState[0][2] = new BoardCell(true);
        seedState[0][3] = new BoardCell(false);


        seedState[1][0] = new BoardCell(true);
        seedState[1][1] = new BoardCell(true);
        seedState[1][2] = new BoardCell(true);
        seedState[1][3] = new BoardCell(false);

        seedState[2][0] = new BoardCell(false);
        seedState[2][1] = new BoardCell(false);
        seedState[2][2] = new BoardCell(false);
        seedState[2][3] = new BoardCell(false);

        seedState[3][0] = new BoardCell(false);
        seedState[3][1] = new BoardCell(false);
        seedState[3][2] = new BoardCell(false);
        seedState[3][3] = new BoardCell(false);

        //when
        Board lifeBoard = new Board(seedState);
        lifeBoard.tick();

        //then
        BoardCell[][] state = lifeBoard.getState();
        assertTrue(state[0][0].isAlive());
        assertTrue(state[0][2].isAlive());
        assertTrue(state[1][0].isAlive());
        assertFalse(state[1][1].isAlive());
        assertTrue(state[1][2].isAlive());
        assertTrue(state[2][1].isAlive());

    }

}
