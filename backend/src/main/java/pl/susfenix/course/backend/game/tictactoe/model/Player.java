package pl.susfenix.course.backend.game.tictactoe.model;

public enum Player {
    X("Michał", 'X'),
    O("Tymek", 'O', PlayerType.HUMAN);



    private final String name;
    private final char symbol;
    private PlayerType type;

    private Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.type = PlayerType.HUMAN;
    }

    private Player(String name, char symbol, PlayerType playerType){
        this.name = name;
        this.symbol = symbol;
        this.type = playerType;
    }

    public PlayerType getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public char getSymbol() {
        return this.symbol;
    }
    public void setType(PlayerType type) {
        this.type = type;
    }
}
