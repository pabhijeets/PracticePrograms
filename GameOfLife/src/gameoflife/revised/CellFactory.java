package gameoflife.revised;

import java.util.HashMap;
import java.util.Map;

public class CellFactory {
    private static final Map<Boolean, Cell> CELLS = new HashMap<>();

    static {
        CELLS.put(false, new DeadCell());
        CELLS.put(true, new AliveCell());
    }

    static Cell getCell(boolean alive) {
        return CELLS.get(alive);
    }
}
