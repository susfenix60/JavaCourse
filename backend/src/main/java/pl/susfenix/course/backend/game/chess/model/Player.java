package pl.susfenix.course.backend.game.chess.model;

public enum Player {

    WHITE("biały"), BLACK("czarny");
    private final String name;

    Player(String name) {
        this.name = name;
    }
}
