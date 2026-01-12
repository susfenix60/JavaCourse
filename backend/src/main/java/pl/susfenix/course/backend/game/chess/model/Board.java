package pl.susfenix.course.backend.game.chess.model;

import java.util.Arrays;

public class Board {

    private final Pawn[][] grid;

    public Board(Pawn[][] grid) {
        this.grid = grid;
    }

    public Pawn[][] getGrid() {
        return grid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Arrays.equals(grid, board.grid);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(grid);
    }

    @Override
    public String toString() {
        return "Board{" +
                "grid=" + Arrays.toString(grid) +
                '}';
    }
}
