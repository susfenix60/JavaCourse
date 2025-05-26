package pl.susfenix.course.backend.game.tictactoe.logic.player;

import pl.susfenix.course.backend.game.tictactoe.logic.TicTacToeApi;

import java.util.Random;

public class DumbComputerPlayerMover {
    public int[] designatePosition(TicTacToeApi ticTacToeApi) {
        int[] playerPosition = new int[2];
        playerPosition[0] = -1;
        playerPosition[1] = -1;
        Random random = new Random();

        boolean isPossible = ticTacToeApi.isMovePossible(playerPosition[0], playerPosition[1]);

        while (!isPossible) {

            playerPosition[0] = random.nextInt(ticTacToeApi.getGameState().getBoard().getBoardState().length);
            playerPosition[1] = random.nextInt(ticTacToeApi.getGameState().getBoard().getBoardState().length);

            isPossible = ticTacToeApi.isMovePossible(playerPosition[0], playerPosition[1]);
        }
        return playerPosition;
    }
}
