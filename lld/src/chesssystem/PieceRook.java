package chesssystem;

public class PieceRook extends Piece{
    public PieceRook(boolean isWhitePiece) {
        super(isWhitePiece);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return true;
    }

    @Override
    public String getSymbol() {
        return "Rook";
    }

    @Override
    public void move(Board board, Spot start, Spot end) {
//t
    }
}
