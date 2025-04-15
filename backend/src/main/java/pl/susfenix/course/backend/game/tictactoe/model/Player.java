package pl.susfenix.course.backend.game.tictactoe.model;

public enum Player {
    X("Michał", 'X'),
    O("Tymek", 'O');

    private final String name;
    private final char symbol;

    private Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }
}
