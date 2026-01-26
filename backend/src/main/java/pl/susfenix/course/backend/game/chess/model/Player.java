package pl.susfenix.course.backend.game.chess.model;

public enum Player {

    WHITE("biały"), BLACK("czarny");
    private final String name;

    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }

}
