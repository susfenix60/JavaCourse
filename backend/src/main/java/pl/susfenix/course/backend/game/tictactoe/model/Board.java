package pl.susfenix.course.backend.game.tictactoe.model;

import java.util.Arrays;

public class Board {
    private static final char[][] INITIAL_STATE = new char[][]{
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    private char[][] boardState = INITIAL_STATE;

    public Board() {
        this.boardState = INITIAL_STATE;
    }

    public Board(Board otherBoard) {
        this.boardState = Arrays.copyOf(otherBoard.getBoardState(), otherBoard.getBoardState().length);
    }

    public char[][] getBoardState() {
        return this.boardState;
    }

    @Override
    public String toString() {

        String result = "1 2 3";

        for (int currentIndex = 0; currentIndex < 3; currentIndex++) {
            for (int currentIndex2 = 0; currentIndex2 < 3; currentIndex2++) {
                char currentBoardValue = this.boardState[currentIndex][currentIndex2];
                result = result + currentBoardValue + "|";

            }
            result = result + "\n";
        }
        result += "--------";
        return result;
    }
}
