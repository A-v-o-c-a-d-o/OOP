public class Solution {
    private int numerator;
    private int denominator = 1;

    /** An especially short bit of Javadoc. */
    public int getNumerator() {
        return numerator;
    }

    /** An especially short bit of Javadoc. */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /** An especially short bit of Javadoc. */
    public int getDenominator() {
        return denominator;
    }

    /** An especially short bit of Javadoc. */
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            return;
        }
        this.denominator = denominator;
    }

    /** An especially short bit of Javadoc. */
    public Solution(int numerator, int denominator) {
        if (denominator != 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    /** An especially short bit of Javadoc. */
    public Solution() {}

    /** An especially short bit of Javadoc. */
    private int gcd(int a, int b) {
        if (a > Integer.MAX_VALUE || b > Integer.MAX_VALUE) {
            return 1;
        }
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0) {
            return b;
        }
        if (a == b) {
            return a;
        }
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }

        return gcd(a, (b - a));
    }

    /** An especially short bit of Javadoc. */
    public Solution reduce() {
        int n = gcd(numerator, denominator);
        if (denominator < 0) {
            n = -n;
        }
        numerator /= n;
        denominator /= n;
        return this;
    }

    /** An especially short bit of Javadoc. */
    public Solution add(Solution a) {
        Solution ans = new Solution(numerator * a.getDenominator() + a.getNumerator() * denominator,
                                    denominator * a.getDenominator());
        ans = ans.reduce();
        numerator = ans.getNumerator();
        denominator = ans.getDenominator();
        return this;
    }

    /** An especially short bit of Javadoc. */
    public Solution subtract(Solution a) {
        Solution ans = new Solution(numerator * a.getDenominator() - a.getNumerator() * denominator,
                                    denominator * a.getDenominator());
        ans = ans.reduce();
        numerator = ans.getNumerator();
        denominator = ans.getDenominator();
        return this;
    }

    /** An especially short bit of Javadoc. */
    public Solution multiply(Solution a) {
        numerator *= a.getNumerator();
        denominator *= a.getDenominator();
        Solution ans = this.reduce();
        numerator = ans.getNumerator();
        denominator = ans.getDenominator();
        return this;
    }

    /** An especially short bit of Javadoc. */
    public Solution divide(Solution a) {
        if (a.getNumerator() == 0) {
            return this;
        }
        numerator *= a.getDenominator();
        denominator *= a.getNumerator();
        Solution ans = this.reduce();
        numerator = ans.getNumerator();
        denominator = ans.getDenominator();
        return this;
    }

    /** An especially short bit of Javadoc. */
    public boolean equals(Object obj) {
        if (!(obj instanceof Solution)) {
            return false;
        }
        Solution that = (Solution) obj;
        that = that.reduce();
        Solution t = this.reduce();
        numerator = t.getNumerator();
        denominator = t.getDenominator();
        return this.numerator == that.numerator && this.denominator == that.denominator;
    }

    /** An especially short bit of Javadoc. */
    public static void main(String[] args) {
        Solution a = new Solution(1, 2);
        //a.multiply(new Solution(4, 3));
        a.divide(new Solution(0, 2));
        a = a.reduce();
        System.out.println(a.getNumerator() + "/" + a.getDenominator());
        System.out.println(a.equals(new Solution(1, 2)));
    }
}    