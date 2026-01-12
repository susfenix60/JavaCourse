package pl.susfenix.course.backend.game.chess.model;

import java.util.Objects;

public class GameResult {

    private final GameStatus status;
    private final String message;

    public GameResult(GameStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public GameStatus getStatus(){
        return this.status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return status == that.status && message.equals(that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message);
    }



}
