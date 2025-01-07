package pl.susfenix.course.backend.game.tictactoe;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
/*

        Person tymekPerson = new Person("Tymek", "Rebacz", 20);

        Address address = new Address("22", "Rumainkowa", 18,"54-127");
        Person tymekPerson2 = new Person("Tymek", "Rebacz222", 20, address, address);

        Person person3 = Person.create("Tymek", "REbacz", 13);

        System.out.println("Tymek person: " + tymekPerson);
        System.out.println("Tymek person2: " + tymekPerson2.toString());
        System.out.println("address: " + address);
*/

       startGame();

    }

    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        char playerX = createPlayerX();
        char playerY = createPlayerO();
        char[] players = new char[]{playerX, playerY};
        int currentPlayerIndex = 0;
        char[][] createdBoard = createABoard();

        boolean isBoardFree = false;
        boolean isWinner = false;

        while (!isWinner || !isBoardFree) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
            printABoard(createdBoard);
            char currentPlayer = players[currentPlayerIndex];
            char[][] gameState = makeMove(createdBoard, currentPlayer, scanner);
            isBoardFree = hasEmptyField(createdBoard);
            isWinner = checkWinner(gameState, currentPlayer);
        }

        if (isWinner) {
            System.out.println("The game has ended, the winner player is: " + players[currentPlayerIndex]);
        } else if (!isBoardFree) {
            System.out.println("It's draw, the game has ended.");
        }
    }

    private static char createPlayerO() {
        return 'O';
    }

    private static char createPlayerX() {
        return 'X';
    }

    private static char[][] createABoard() {
        return new char[][]{
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
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

    private static char[][] makeMove(char[][] createdBoard, char currentPlayer, Scanner scanner) {

        int[] playerPosition = retrievePlayerPosition(createdBoard, scanner);
        int rowPosition = playerPosition[0];
        int colPosition = playerPosition[1];

        createdBoard[rowPosition][colPosition] = currentPlayer;
        return createdBoard;
    }

    private static int[] retrievePlayerPosition(char[][] createdBoard, Scanner scanner) {

        //Scanner scanner = new Scanner(System.in);

        int rowPosition = -1;
        int colPosition = -1;

        while (rowPosition == -1 || colPosition == -1) {

            System.out.println("Please give me row position from 1 to 3.");
            rowPosition = scanner.nextInt();

            System.out.println("Please give me column position from 1 to 3.");
            colPosition = scanner.nextInt();

            if (!isMovePossible(createdBoard, rowPosition - 1, colPosition - 1)) {
                System.out.println("Your move can NOT be done, please select other position.");
                rowPosition = -1;
                colPosition = -1;
            }
        }
        scanner = scanner.reset();
        //scanner.close();
        return new int[]{rowPosition - 1, colPosition - 1};
    }

    //TODO: refactor this
    private static boolean hasEmptyField(char[][] createdBoard) {

        for (int colIndex = 0; colIndex < 3; colIndex++) {

            if (createdBoard[colIndex][0] == ' ' || createdBoard[colIndex][1] == ' ' || createdBoard[colIndex][2] == ' ') {
                return true;
            }
        }
        return false;
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



