package pl.susfenix.course.frontend.console.game.tictactoe;

import pl.susfenix.course.backend.game.tictactoe.logic.TicTacToeFacade;
import pl.susfenix.course.backend.game.tictactoe.logic.TicTacToeFactory;
import pl.susfenix.course.backend.game.tictactoe.model.GameStatus;
import pl.susfenix.course.backend.game.tictactoe.model.Player;
import pl.susfenix.course.backend.game.tictactoe.model.TicTacToeGameState;
import pl.susfenix.course.frontend.console.layout.ScannerHolder;

import java.util.Scanner;

public class TicTacToeConsole {
    private final TicTacToeFacade ticTacToeFacade;

    public TicTacToeConsole() {
        this.ticTacToeFacade = TicTacToeFactory.createInitial();
    }

    public void start() {
        TicTacToeGameState gameState = ticTacToeFacade.getGameState();

        Player playerBeforeMove = null;
        while (gameState.getGameResult().getStatus().equals(GameStatus.IN_GAME) || gameState.getGameResult().getStatus().equals(GameStatus.INICIALAZED)) {
            playerBeforeMove = gameState.getCurrentPlayer();
            System.out.println(gameState.getBoard());
            Player currentPlayer = gameState.getCurrentPlayer();
            System.out.println("Current player is " + currentPlayer);

            int[] playerPosition = retrievePlayerPosition();
            gameState = this.ticTacToeFacade.makeMove(playerPosition[0], playerPosition[1]);
        }

        System.out.println(gameState.getBoard());

        if (gameState.getGameResult().getStatus().equals(GameStatus.WINNER)) {
            System.out.println("The game has ended, the winner player is: " + playerBeforeMove.getSymbol());
        } else if (gameState.getGameResult().getStatus().equals(GameStatus.DRAW)) {
            System.out.println("It's draw, the game has ended.");
        }
        System.out.println(gameState.getGameResult().getMessage());
    }

    private int[] retrievePlayerPosition(){

        Scanner scanner = ScannerHolder.getScanner();

        int rowPosition = -1;
        int colPosition = -1;

        while (rowPosition == -1 || colPosition == -1) {

            System.out.print("Please give me row position from 1 to 3.  ");
            rowPosition = scanner.nextInt();

            System.out.print ("Please give me column position from 1 to 3.  ");
            colPosition = scanner.nextInt();

            if (!this.ticTacToeFacade.isMovePossible(rowPosition - 1, colPosition - 1)) {
                System.out.println("Your move can NOT be done, please select other position.");
                rowPosition = -1;
                colPosition = -1;
            }
        }
        scanner.reset();
        return new int[]{rowPosition - 1, colPosition - 1};
    }
}
