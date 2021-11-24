// package CoVua1;

import java.util.ArrayList;

public class Board {
    public final int WIDTH = 8;
    public final int HEIGHT = 8;
    private ArrayList<Piece> pieces;
    
    public Board() {}

    public void addPiece(Piece piece) {
        if (!validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            return;
        }
        if (getAt(piece.getCoordinatesX(), piece.getCoordinatesY()) != null) {
            if (getAt(piece.getCoordinatesX(), piece.getCoordinatesY()).getColor().equals(piece.getColor())) {
                return;
            } else {
                removeAt(piece.getCoordinatesX(), piece.getCoordinatesY());
            }
        }
        pieces.add(piece);
    }
    
    public boolean validate(int x, int y) {
        return x > 0 && y > 0 && x <= WIDTH && y <= HEIGHT;
    }

    public void removeAt(int x, int y) {
        if (!validate(x, y)) {
            return;
        }
        for (Piece i: pieces) {
            if (i.getCoordinatesX() == x && i.getCoordinatesY() == y) {
                pieces.remove(i);
                break;
            }
        }
    }

    public Piece getAt(int x, int y) {
        if (!validate(x, y)) {
            return null;
        }
        for (Piece i: pieces) {
            if (i.getCoordinatesX() == x && i.getCoordinatesY() == y) {
                return i;
            }
        }
        return null;
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
