package Interface;

public class Point {
    private double pointX;
    private double pointY;
    
    public Point(double x, double y) {
        this.pointX = x;
        this.pointY = y;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    public double distance(Point other) {
        return Math.sqrt(Math.pow((pointX - other.getPointX()), 2)
                + Math.pow((pointY - other.getPointY()), 2));
    }

    @Override
    public String toString() {
        return "(" + String.format("%.2f", pointX)
            + "," + String.format("%.2f", pointY) + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;
        if (Double.doubleToLongBits(pointX) != Double.doubleToLongBits(other.pointX)) {
            return false;
        }
        if (Double.doubleToLongBits(pointY) != Double.doubleToLongBits(other.pointY)) {
            return false;
        }
        return true;
    }

    public double dh(Point other) {
        return (pointY - other.getPointY()) / (pointX - other.getPointX());
    }
}
