package pl.susfenix.course.backend.game.tictactoe.logic.player;

import pl.susfenix.course.backend.game.tictactoe.logic.TicTacToeFacade;

import java.util.Random;

public class DumbComputerPlayerMover {
    public int[] designatePosition(TicTacToeFacade ticTacToeFacade) {
        int[] playerPosition = new int[2];
        playerPosition[0] = -1;
        playerPosition[1] = -1;
        Random random = new Random();

        boolean isPossible = ticTacToeFacade.isMovePossible(playerPosition[0], playerPosition[1]);

        while (!isPossible) {

            playerPosition[0] = random.nextInt(ticTacToeFacade.getGameState().getBoard().getBoardState().length);
            playerPosition[1] = random.nextInt(ticTacToeFacade.getGameState().getBoard().getBoardState().length);

            isPossible = ticTacToeFacade.isMovePossible(playerPosition[0], playerPosition[1]);
        }
        return playerPosition;
    }
}
