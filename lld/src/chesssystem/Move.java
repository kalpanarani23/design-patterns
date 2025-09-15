package chesssystem;

public class Move {
    Player player;
    Spot start;
    Spot end;
    Piece pieceMoved;
    Piece pieceKilled;
    boolean isValidMove;
    private boolean castlingMove = false;

    public boolean isCastlingMove() {
        return castlingMove;
    }

    public void setCastlingMove(boolean castlingMove) {
        this.castlingMove = castlingMove;
    }

    public Move(Player pPlayer, Spot pStartSpot, Spot pEndSpot, Piece piece) {
        player = pPlayer;
        start = pStartSpot;
        end = pEndSpot;
        pieceMoved = piece;
        pieceKilled = null;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Spot getStart() {
        return start;
    }

    public void setStart(Spot start) {
        this.start = start;
    }

    public Spot getEnd() {
        return end;
    }

    public void setEnd(Spot end) {
        this.end = end;
    }

    public Piece getPieceMoved() {
        return pieceMoved;
    }

    public void setPieceMoved(Piece pieceMoved) {
        this.pieceMoved = pieceMoved;
    }

    public Piece getPieceKilled() {
        return pieceKilled;
    }

    public void setPieceKilled(Piece pieceKilled) {
        this.pieceKilled = pieceKilled;
    }

    public boolean isValidMove() {
        return isValidMove;
    }

    public void setValidMove(boolean validMove) {
        isValidMove = false;
    }
}
