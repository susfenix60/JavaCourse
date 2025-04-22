package pl.susfenix.course.backend.game.tictactoe.logic;

import pl.susfenix.course.backend.game.tictactoe.model.Board;
import pl.susfenix.course.backend.game.tictactoe.model.GameResult;
import pl.susfenix.course.backend.game.tictactoe.model.Player;
import pl.susfenix.course.backend.game.tictactoe.model.TicTacToeGameState;

public class TicTacToeFactory {

    public static TicTacToeApi createInitial(){
        final Player[] allPlayers = Player.values();
        final char[][] boardState = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        Player startPlayer = Player.X;

        final Board board = new Board(boardState);
        final GameResult gameResult = GameResult.initial(startPlayer);
        final TicTacToeGameState gameState = new TicTacToeGameState(board, startPlayer,gameResult);
        return new  TicTacToeApi(gameState, allPlayers);
    }

}
