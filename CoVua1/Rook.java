package CoVua1;

public class Rook extends Piece {

    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }
    
    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int endX, int endY) {
        boolean pointCheck = board.validate(endX, endY);
        boolean angleCheck = super.getCoordinatesX() - endX == 0
                          || super.getCoordinatesY() - endY == 0;
        boolean endCheck = board.getAt(endX, endY) == null
                || !board.getAt(endX, endY).getColor().equals(super.getColor());
        boolean lineCheck = false;

        if (pointCheck && angleCheck && endCheck) {
            lineCheck = true;
            int x = super.getCoordinatesX();
            int y = super.getCoordinatesY();
            int moveX = (endX - x) == 0 ? 0 : (endX - x) / Math.abs(endX - x);
            int moveY = (endY - y) == 0 ? 0 : (endY - y) / Math.abs(endY - y);
            
            while (x + moveX != endX || y + moveY != endY) {
                x += moveX;
                y += moveY;
                if (board.getAt(x, y) != null) {
                    lineCheck = false;
                    break;
                }
            }
        }

        return lineCheck;
    }
}