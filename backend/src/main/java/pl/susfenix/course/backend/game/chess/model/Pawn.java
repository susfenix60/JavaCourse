package pl.susfenix.course.backend.game.chess.model;

import java.util.Objects;

public class Pawn {

    private final PawnType pawnType;
    private final Player owner;
    private final Position position;

    public Pawn(PawnType pawnType, Player owner, Position position) {
        this.pawnType = pawnType;
        this.owner = owner;
        this.position = position;
    }

    public Pawn(Player owner, Position position) {

        this(PawnType.NORMAL, owner, position);

    }

    public PawnType getPawnType() {
        return pawnType;
    }

    public Player getOwner() {
        return owner;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pawn pawn = (Pawn) o;
        return pawnType == pawn.pawnType && owner == pawn.owner && position.equals(pawn.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pawnType, owner, position);
    }

    @Override
    public String toString() {
        return "Pawn{" +
                "pawnType=" + pawnType +
                ", owner=" + owner +
                ", position=" + position +
                '}';
    }

    public static Pawn createForWhitePlayer (Position position) {

        return new Pawn(Player.WHITE, position);


    }
    public static Pawn createForBlackPlayer (Position position){

        return new Pawn(Player.BLACK, position);


    }


}
