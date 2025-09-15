package chesssystem;

public abstract class Piece {
    boolean isKilled = false;
    boolean isWhitePiece = false;

    public Piece(boolean isWhitePiece) {
        this.isWhitePiece = isWhitePiece;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public boolean isWhitePiece() {
        return isWhitePiece;
    }

    public void setWhitePiece(boolean whitePiece) {
        isWhitePiece = whitePiece;
    }

    public abstract boolean canMove(Board board, Spot start, Spot end);
    public abstract String getSymbol();
    public abstract void move(Board board, Spot start, Spot end);
}
