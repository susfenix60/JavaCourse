package pl.susfenix.course.backend.game.tictactoe.model;

public class Board {
    private static final char[][] INITIAL_STATE = new char[][]{
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    private char[][] boardState = INITIAL_STATE;
    public Board(){
        this.boardState = INITIAL_STATE;
    }
}
