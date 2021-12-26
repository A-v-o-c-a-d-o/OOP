package NgoaiLe1;

public class Division extends BinaryExpression {
    Division(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String toString() {
        return "(" + left + " / " + right + ")";
    }

    @Override
    public double evaluate() {
        if (right.evaluate() == 0) {
            throw new ArithmeticException("Lỗi chia cho 0");
        } else {
            return left.evaluate() / right.evaluate();
        }
    }
}
