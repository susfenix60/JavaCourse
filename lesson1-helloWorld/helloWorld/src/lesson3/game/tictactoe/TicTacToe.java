package lesson3.game.tictactoe;


public class TicTacToe {

    public static void main(String[] args) {

        startGame();

    }

    public static void startGame() {

        char playerX = createPlayerX();
        char playerY = createPlayerO();
        char[][] createdBoard = createABoard();
        printABoard(createdBoard);
        //isMovePossible(createdBoard, row, col);
        //checkWinner();


    }

    private static char createPlayerO() {
        return 'O';
    }

    private static char createPlayerX() {
        return 'X';
    }

    private static char[][] createABoard() {
        return new char[][]{
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'O', ' ', 'X'}
        };
    }

    private static void printABoard(char[][] board) {
        System.out.println("1 2 3");

        for (int currentIndex = 0; currentIndex < 3; currentIndex++) {
            for (int currentIndex2 = 0; currentIndex2 < 3; currentIndex2++) {
                char currentBoardValue = board[currentIndex][currentIndex2];
                System.out.print(currentBoardValue + "|");


            }
            System.out.println();
        }
        System.out.println("--------");
    }

    private static boolean isMovePossible(char[][] board, int row, int col) {
        if (row < 0 || row >= 3) {
            return false;
        }

        if (col < 0 || col >= 3) {
            return false;
        }
        char boardValue = board[row][col];
        if (boardValue == ' ') {
            return true;
        } else {
            return false;
        }

    }

    private static boolean checkWinner(char[][] board, char currentPlayer) {

        for (int currentIndex = 0; currentIndex < 3; currentIndex++) {

            if (board[currentIndex][0] == currentPlayer && board[currentIndex][1] == currentPlayer && board[currentIndex][2] == currentPlayer) {
                return true;
            }
            if (board[0][currentIndex] == currentPlayer && board[1][currentIndex] == currentPlayer && board[2][currentIndex] == currentPlayer) {
                return true;
            }
        }

        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        } else if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        } else {
            return false;
        }
    }
}


