package pl.susfenix.course.backend.game.chess.model;

import java.util.Objects;

public class Position {

    private final int row;
    private final int col;
    private final String name;



    public Position(int row, int col) {
        this.row = row;
        this.col = col;
        this.name = extractName(row, col);
    }

    private String extractName(int row, int col) {
        char columnName = (char)('A' + col); //A to 65 w ascii
        int  rowName = row + 1;
        return ""+columnName+rowName;
    }

    public String getName() {
        return name;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && col == position.col && name.equals(position.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col, name);
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", col=" + col +
                ", name='" + name + '\'' +
                '}';
    }
}
