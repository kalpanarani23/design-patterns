package chesssystem;

public class PieceKing extends Piece {
    public PieceKing(boolean isWhitePiece) {
        super(isWhitePiece);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return true;
    }

    @Override
    public String getSymbol() {
        return "KING";
    }

    @Override
    public void move(Board board, Spot start, Spot end) {
//
    }
}
