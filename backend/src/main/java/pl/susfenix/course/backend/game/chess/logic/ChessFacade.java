package pl.susfenix.course.backend.game.chess.logic;

import pl.susfenix.course.backend.game.chess.model.*;

public class ChessFacade implements ChessApi {

    private ChessGameState gameState;
    //private final Player[] allPlayers;

    @Override
    public void initialize() {

        Pawn[][] grid = new Pawn[8][8];
        Board board = new Board(grid);
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
