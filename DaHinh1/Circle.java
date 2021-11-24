package DaHinh1;

class Circle extends Shape {
    protected double radius;

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

    public void setRadius(double radius) {
        this.radius = radius;
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
        return "Circle[radius=" + radius + ",color="
                + color + ",filled=" + filled + "]";
    }
}