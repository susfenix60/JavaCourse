package pl.susfenix.course.backend.game.chess.logic;

import pl.susfenix.course.backend.game.chess.model.*;

public class ChessFacade implements ChessApi {

    private ChessGameState gameState;
    //private final Player[] allPlayers;

    public static void main (String[]args){

        new ChessFacade().initialize();


    }


    @Override
    public void initialize() {


        Pawn[][] grid = new Pawn[8][8];
        Board board = new Board(grid);

        for (int currentColIndex = 0; currentColIndex < 8; currentColIndex++){
            for (int currentRowIndex = 0; currentRowIndex < 8; currentRowIndex++){
                Position position = new Position(currentColIndex, currentRowIndex);
                board.clear(position);
            }
        }

        for (int currentColIndex = 0; currentColIndex < 3; currentColIndex++){
            for (int currentRowIndex = 0; currentRowIndex < 8; currentRowIndex++){

                if ((currentRowIndex + currentColIndex) %2 == 0){

                    Position position = new Position(currentColIndex, currentRowIndex);
                    Pawn pawn = new Pawn(Player.BLACK, position);
                    board.setPosition(position, pawn);

                }
            }
        }

        for (int currentColIndex = 5; currentColIndex < 8; currentColIndex++){
            for (int currentRowIndex = 0; currentRowIndex < 8; currentRowIndex++){

                if ((currentRowIndex + currentColIndex) %2 == 0){

                    Position position = new Position(currentColIndex, currentRowIndex);
                    Pawn pawn = new Pawn(Player.WHITE, position);
                    board.setPosition(position, pawn);

                }
            }
        }

        Player player = Player.WHITE;
        GameStatus status = GameStatus.INICIALAZED;
        GameResult gameResult = new GameResult(status,"new game inicialized");
        this.gameState = new ChessGameState(board, player, gameResult);

    }

    @Override
    public boolean isMovePossible() {
        return false;
    }

    @Override
    public void makeMove(Position position) {

    }



}