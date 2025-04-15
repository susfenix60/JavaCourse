package pl.susfenix.course.backend.game.tictactoe.model;

public class GameResult {
    private final GameStatus status;
    private final String message;

    public GameResult(GameStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public GameResult(GameResult otherResult) {
        this.status = otherResult.status;
        this.message = otherResult.message;

    }
    public GameStatus getStatus(){
        return this.status;
    }
    public String getMessage(){
        return this.message;
    }
}
