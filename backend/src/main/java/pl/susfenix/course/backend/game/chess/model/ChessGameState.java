package pl.susfenix.course.backend.game.chess.model;

import java.util.Objects;

public class ChessGameState {

    private final Board board;
    private final Player currentPlayer;
    private final GameResult gameResult;

    public ChessGameState(Board board, Player currentPlayer, GameResult gameResult) {
        this.board = board;
        this.currentPlayer = currentPlayer;
        this.gameResult = gameResult;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessGameState that = (ChessGameState) o;
        return board.equals(that.board) && currentPlayer == that.currentPlayer && gameResult.equals(that.gameResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(board, currentPlayer, gameResult);
    }

    @Override
    public String toString() {
        return "ChessGameState{" +
                "board=" + board +
                ", currentPlayer=" + currentPlayer +
                ", gameResult=" + gameResult +
                '}';
    }
}

