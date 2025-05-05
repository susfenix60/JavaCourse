package pl.susfenix.course.frontend.console.game.tictactoe;

import pl.susfenix.course.backend.game.lotto.object.logic.LottoApi;
import pl.susfenix.course.backend.game.tictactoe.logic.TicTacToeApi;
import pl.susfenix.course.backend.game.tictactoe.logic.TicTacToeFactory;
import pl.susfenix.course.backend.game.tictactoe.model.GameStatus;
import pl.susfenix.course.backend.game.tictactoe.model.Player;
import pl.susfenix.course.backend.game.tictactoe.model.TicTacToeGameState;
import pl.susfenix.course.frontend.console.layout.ScannerHolder;

import java.util.Scanner;

public class TicTacToeConsole {
    private final TicTacToeApi ticTacToeApi;

    public TicTacToeConsole() {
        this.ticTacToeApi = TicTacToeFactory.createInitial();
    }

    public void start() {
        TicTacToeGameState gameState = ticTacToeApi.getGameState();

        Player playerBeforeMove = null;
        while (gameState.getGameResult().getStatus().equals(GameStatus.IN_GAME) || gameState.getGameResult().getStatus().equals(GameStatus.INICIALAZED)) {
            playerBeforeMove = gameState.getCurrentPlayer();
            System.out.println(gameState.getBoard());
            Player currentPlayer = gameState.getCurrentPlayer();
            System.out.println("Current player is " + currentPlayer);

            int[] playerPosition = retrievePlayerPosition();
            gameState = this.ticTacToeApi.makeMove(playerPosition[0], playerPosition[1]);
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

            if (!this.ticTacToeApi.isMovePossible(rowPosition - 1, colPosition - 1)) {
                System.out.println("Your move can NOT be done, please select other position.");
                rowPosition = -1;
                colPosition = -1;
            }
        }
        scanner.reset();
        return new int[]{rowPosition - 1, colPosition - 1};
    }
}
