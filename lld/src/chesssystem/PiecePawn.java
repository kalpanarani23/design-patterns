package chesssystem;

public class PiecePawn extends Piece{
    public PiecePawn(boolean isWhitePiece) {
        super(isWhitePiece);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return true;
    }

    @Override
    public String getSymbol() {
        return "Pawn";
    }

    @Override
    public void move(Board board, Spot start, Spot end) {
//
    }
}
