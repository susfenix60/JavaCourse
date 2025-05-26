package pl.susfenix.course.backend.game.tictactoe.logic;

import pl.susfenix.course.backend.game.tictactoe.logic.player.DumbComputerPlayerMover;
import pl.susfenix.course.backend.game.tictactoe.logic.player.SmartComputerPlayerMover;
import pl.susfenix.course.backend.game.tictactoe.model.*;

public class TicTacToeFactory {

    public static TicTacToeApi createInitial(){
        return createInitial("", "");
    }
    public static TicTacToeApi createInitial(String token, String endpoint){

        final Player[] allPlayers = Player.values();
        final char[][] boardState = new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        Player startPlayer = Player.X;
        startPlayer.setType(PlayerType.SMART_COMPUTER);
        allPlayers[1].setType(PlayerType.SMART_COMPUTER);

        final Board board = new Board(boardState);
        final GameResult gameResult = GameResult.initial(startPlayer);
        final TicTacToeGameState gameState = new TicTacToeGameState(board, startPlayer,gameResult);

        DumbComputerPlayerMover dumbComputerPlayerMover = new DumbComputerPlayerMover();
        SmartComputerPlayerMover smartComputerPlayerMover = new SmartComputerPlayerMover(token, endpoint, dumbComputerPlayerMover);
        return new TicTacToeApi(gameState, allPlayers, smartComputerPlayerMover, dumbComputerPlayerMover);

    }

}
