package chesssystem;

public class PieceQueen extends Piece{
    public PieceQueen(boolean isWhitePiece) {
        super(isWhitePiece);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return true;
    }

    @Override
    public String getSymbol() {
        return "QUEEN";
    }

    @Override
    public void move(Board board, Spot start, Spot end) {
//
    }
}
