package pl.susfenix.course.backend.game.tictactoe.model;

public class Board {


    private final char[][] boardState;

    public Board(char[][] boardState) {
        this.boardState = boardState;
    }

    public Board(Board otherBoard) {
        char[][] newBoardState = new char[otherBoard.boardState.length][otherBoard.boardState.length];
        for (int currentRow = 0; currentRow < otherBoard.boardState.length; currentRow++){
            for (int currentCol = 0; currentCol < otherBoard.boardState.length; currentCol++){
                char currentValue = otherBoard.boardState[currentCol][currentRow];
                newBoardState[currentCol][currentRow] = currentValue;
            }
        }
        this.boardState = newBoardState;
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
