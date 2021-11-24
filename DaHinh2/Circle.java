package DaHinh2;

public class Circle extends Shape {
    protected double radius;
    protected Point center;

    public double getRadius() {
        return radius;
    }

    public Circle() {}

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    /** create. */
    public Circle(Point center, double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
        this.center = center;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    @Override
    public double getArea() {
        return 3.141592653589793 * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 3.141592653589793 * radius * 2;
    }

    public String toString() {
        return "Circle[center=" + center + ",radius=" + radius + ",color="
                + color + ",filled=" + filled + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((center == null) ? 0 : center.hashCode());
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
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
        Circle other = (Circle) obj;
        if (center == null) {
            if (other.center != null) {
                return false;
            }
        } else if (!center.equals(other.center)) {
            return false;
        }
        if (Math.abs(radius - other.radius) > 0.001) {
            return false;
        }
        return true;
    }
}