package pl.susfenix.course.backend.game.chess.logic;

import pl.susfenix.course.backend.game.chess.model.Pawn;
import pl.susfenix.course.backend.game.chess.model.Position;

public interface ChessApi {

    boolean isMovePossible();

    void initialize();

    void makeMove(Position position);



}
