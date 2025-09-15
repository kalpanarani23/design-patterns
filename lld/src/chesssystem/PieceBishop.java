package chesssystem;

public class PieceBishop extends Piece{
    public PieceBishop(boolean isWhitePiece) {
        super(isWhitePiece);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return true;
    }

    @Override
    public String getSymbol() {
        return "BISHOP";
    }

    @Override
    public void move(Board board, Spot start, Spot end) {
//
    }
}
