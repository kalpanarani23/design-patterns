package chesssystem;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;
    Player[] players = new Player[2];
    Player currPlayer;
    GameStatus gameStatus;
    List<Move> movesPlayed = new ArrayList<>();
    int currMoveIndex;

    Game(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;
        gameStatus = GameStatus.ACTIVE;
        board.resetBoard();
        board.displayBoard();
        currMoveIndex = 0;
    }

    public void displayGameBoard() {
        board.displayBoard();
    }


    public List<Integer> getPosition(String spot) {
        int spotRow = 8 - (spot.charAt(0) - '0');
        int spotCol = spot.charAt(1) - 'a';
        List<Integer> positions = new ArrayList<>();
        positions.add(spotRow);
        positions.add(spotCol);
        return positions;
    }


    public boolean processMove(Player curr, String start, String end) {
        List<Integer> startMove = getPosition(start);
        List<Integer> endMove = getPosition(end);
        Spot startSpot = board.getSpot(startMove.get(0), startMove.get(1));
        Spot endSpot = board.getSpot(endMove.get(0), endMove.get(1));
        Piece currPiece = startSpot.getPiece();

        Move move = new Move(curr, startSpot, endSpot, currPiece);
        if (currPiece.canMove(board, startSpot, endSpot)) {
            currPiece.move(board, startSpot, endSpot);
            endSpot.setPiece(currPiece);
            startSpot.setPiece(null);
            currMoveIndex++;
        } else {
            move.isValidMove();
        }

        movesPlayed.add(move);
        board.displayBoard();
        return true;
    }


    public void undo() {
        currMoveIndex--;
        Move lastMove = movesPlayed.get(currMoveIndex);
        if (lastMove != null) {
            lastMove.getPieceMoved().move(board, lastMove.getEnd(), lastMove.getStart());
            lastMove.getStart().setPiece(lastMove.getPieceMoved());
            lastMove.getEnd().setPiece(lastMove.getPieceKilled());
            board.displayBoard();
        }
    }
}
