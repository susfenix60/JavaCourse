package pl.susfenix.course.backend.game.tictactoe.logic;

import pl.susfenix.course.backend.game.tictactoe.model.*;

import java.util.Scanner;

public class TicTacToeApi {
    private static final Player[] PLAYERS = Player.values();
    private TicTacToeGameState gameState;

    public TicTacToeApi() {
        this.gameState = new TicTacToeGameState();
    }

    public TicTacToeGameState getGameState() {
        return this.gameState;
    }

    public TicTacToeGameState makeMove(int rowPosition, int colPosition) {

        if (!isMovePossible(rowPosition, colPosition)) {
            throw new IllegalArgumentException("Yor move can NOT be done.");
        }
        Board newBoard = new Board(gameState.getBoard());
        newBoard.getBoardState()[rowPosition][colPosition] = gameState.getCurrentPlayer().getSymbol();

        Player newPlayer = nextPlayer();
        GameResult newGameResult = checkWinner();
        this.gameState = new TicTacToeGameState(newBoard, newPlayer, newGameResult);
        return this.gameState;
    }

    private boolean isMovePossible(int row, int col) {

        if (row < 0 || row >= 3) {
            return false;
        }

        if (col < 0 || col >= 3) {
            return false;
        }
        char[][] board = this.gameState.getBoard().getBoardState();
        char boardValue = board[row][col];
        if (boardValue == ' ') {
            return true;
        } else {
            return false;
        }

    }

    private Player nextPlayer() {
        int currentPlayerIndex = 0;
        for (int iterateIndex = 0; iterateIndex < PLAYERS.length; iterateIndex++) {
            Player iteratePlayer = PLAYERS[iterateIndex];
            if (iteratePlayer.equals(this.gameState.getCurrentPlayer())) {
                currentPlayerIndex = iterateIndex;
            }
        }
        Player nextPlayer = PLAYERS[(currentPlayerIndex + 1) % PLAYERS.length];
        return nextPlayer;
    }

    private GameResult checkWinner() {
        char[][] board = this.gameState.getBoard().getBoardState();
        char symbol = this.gameState.getCurrentPlayer().getSymbol();

        for (int currentIndex = 0; currentIndex < 3; currentIndex++) {

            if (board[currentIndex][0] == symbol && board[currentIndex][1] == symbol && board[currentIndex][2] == symbol) {
                return new GameResult(GameStatus.WINNER, "The winner is: " + symbol);
            }
            if (board[0][currentIndex] == symbol && board[1][currentIndex] == symbol && board[2][currentIndex] == symbol) {
                return new GameResult(GameStatus.WINNER, "The winner is: " + symbol);
            }
        }

        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return new GameResult(GameStatus.WINNER, "The winner is: " + symbol);
        } else if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return new GameResult(GameStatus.WINNER, "The winner is: " + symbol);
        } else {
            if (hasEmptyField()){
                return new GameResult(GameStatus.IN_GAME, "Next turn, current player is: " + symbol);
            }
            return new GameResult(GameStatus.DRAW, "The game has ended with a draw.");
        }
    }
    private boolean hasEmptyField() {
        char[][] createdBoard = this.gameState.getBoard().getBoardState();

        for (int colIndex = 0; colIndex < createdBoard.length; colIndex++) {

            for (int rowIndex = 0; rowIndex < createdBoard.length; rowIndex++) {
                if (createdBoard[colIndex][rowIndex] == ' ') {
                    return true;
                }
            }
        }
        return false;
    }
}

