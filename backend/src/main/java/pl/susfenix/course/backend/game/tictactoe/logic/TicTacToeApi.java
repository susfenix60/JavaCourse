package pl.susfenix.course.backend.game.tictactoe.logic;

import pl.susfenix.course.backend.game.tictactoe.model.*;

import java.util.Scanner;

public class TicTacToeApi {
    private TicTacToeGameState gameState;
    private final Player[] allPlayers;

    public TicTacToeApi(TicTacToeGameState gameState, Player[] allPlayers) {
        this.gameState = gameState;
        this.allPlayers = allPlayers;
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
        GameResult newGameResult = checkWinner(newBoard, this.gameState.getCurrentPlayer(), newPlayer);
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
        for (int iterateIndex = 0; iterateIndex < allPlayers.length; iterateIndex++) {
            Player iteratePlayer = allPlayers[iterateIndex];
            if (iteratePlayer.equals(this.gameState.getCurrentPlayer())) {
                currentPlayerIndex = iterateIndex;
            }
        }
        Player nextPlayer = allPlayers[(currentPlayerIndex + 1) % allPlayers.length];
        return nextPlayer;
    }

    private GameResult checkWinner(Board board, Player currentPlayer, Player newPlayer) {
        char[][] boardState = board.getBoardState();
        char symbol = currentPlayer.getSymbol();

        for (int currentIndex = 0; currentIndex < 3; currentIndex++) {

            if (boardState[currentIndex][0] == symbol && boardState[currentIndex][1] == symbol && boardState[currentIndex][2] == symbol) {
                return GameResult.winner(currentPlayer);
            }
            if (boardState[0][currentIndex] == symbol && boardState[1][currentIndex] == symbol && boardState[2][currentIndex] == symbol) {
                return GameResult.winner(currentPlayer);
            }
        }

        if (boardState[0][0] == symbol && boardState[1][1] == symbol && boardState[2][2] == symbol) {
            return GameResult.winner(currentPlayer);
        } else if (boardState[0][2] == symbol && boardState[1][1] == symbol && boardState[2][0] == symbol) {
            return GameResult.winner(currentPlayer);
        } else {
            if (hasEmptyField()){
                return GameResult.inGame(newPlayer);
            }
            return GameResult.draw();
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

