// package CoVua1;

public class Bishop extends Piece {
    public Bishop(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Bishop(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMove(Board board, int endX, int endY) {
        boolean pointCheck = board.validate(endX, endY);
        boolean angleCheck = Math.abs(super.getCoordinatesX() - endX) == Math.abs(super.getCoordinatesY() - endY);
        boolean endCheck = board.getAt(endX, endY) == null || !board.getAt(endX, endX).getColor().equals(super.getColor());
        boolean lineCheck = false;

        if (pointCheck && angleCheck && endCheck) {
            lineCheck = true;
            int x = super.getCoordinatesX();
            int y = super.getCoordinatesY();
            int moveX = (endX - x)/Math.abs(endX - x);
            int moveY = (endY - y)/Math.abs(endY - y);
            
            while (x != endX || y != endY) {
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