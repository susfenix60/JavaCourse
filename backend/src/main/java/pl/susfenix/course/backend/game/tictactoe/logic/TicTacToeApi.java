package pl.susfenix.course.backend.game.tictactoe.logic;

import pl.susfenix.course.backend.game.tictactoe.model.TicTacToeGameState;

public interface TicTacToeApi {

   TicTacToeGameState getGameState();

   TicTacToeGameState makeMove(int rowPosition, int colPosition);

   boolean isMovePossible(int row, int col);

}
