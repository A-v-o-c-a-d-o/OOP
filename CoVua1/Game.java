// package CoVua1;

import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory;
    
    public Game(Board board) {
        this.board = board;
    }

    public void movePiece(Piece piece, int x, int y) {
        if (!board.getPieces().contains(piece)) {
            return;
        }
        if (!piece.canMove(board, x, y)) {
            return;
        }
        int startX = piece.getCoordinatesX();
        int startY = piece.getCoordinatesY();
        board.removeAt(startX, startY);
        piece.setCoordinatesX(x);
        piece.setCoordinatesY(y);
        if (board.getAt(x, y) != null && !board.getAt(x, y).getColor().equals(piece.getColor())) {
            Piece killedPiece = board.getAt(x, y);        
            board.addPiece(piece);
            moveHistory.add(new Move(startX, startY, x, y, piece, killedPiece));
        } else {
            board.addPiece(piece);
            moveHistory.add(new Move(startX, startY, x, y, piece));
        }


    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }    
}
