package chesssystem;

public class PieceKnight extends Piece{
    public PieceKnight(boolean isWhitePiece) {
        super(isWhitePiece);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return true;
    }

    @Override
    public String getSymbol() {
        return "KNIGHT";
    }

    @Override
    public void move(Board board, Spot start, Spot end) {
//
    }
}
