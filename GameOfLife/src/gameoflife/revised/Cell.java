package gameoflife.revised;

public interface Cell {
    boolean isAlive();
    Cell evolve(int numLiveNeighbors);
}
