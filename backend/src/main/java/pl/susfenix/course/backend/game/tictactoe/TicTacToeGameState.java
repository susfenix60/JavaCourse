package pl.susfenix.course.backend.game.tictactoe;

import pl.susfenix.course.backend.game.tictactoe.model.Board;
import pl.susfenix.course.backend.game.tictactoe.model.Player;

public class TicTacToeGameState {
    private static final Player[] PLAYERS = Player.values();
    private Board board;
    private Player currentPlayer;

    public TicTacToeGameState(){
        this.board = new Board();
        this.currentPlayer = Player.X;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public Player nextPlayer() {
        int currentPlayerIndex = 0;
        for (int iterateIndex = 0; iterateIndex < PLAYERS.length; iterateIndex++){
            Player iteratePlayer = PLAYERS[iterateIndex];
            if (iteratePlayer.equals(this.currentPlayer)){
                currentPlayerIndex = iterateIndex;
            }
        }
        Player nextPlayer = PLAYERS[(currentPlayerIndex + 1) % PLAYERS.length];
        this.currentPlayer = nextPlayer;
        return this.currentPlayer;
    }
}
