public class Solution {
    private int numerator;
    private int denominator = 1;

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    public int getNumerator() {
        return numerator;
    }

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    public int getDenominator() {
        return denominator;
    }

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            return;
        }
        this.denominator = denominator;
    }

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    public Solution(int numerator, int denominator) {
        if (denominator != 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
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

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    public void reduce() {
        int n = gcd(numerator, denominator);
        if (denominator < 0) {
            n = -n;
        }
        numerator /= n;
        denominator /= n;
    }

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    public Solution add(Solution a) {
        Solution ans = new Solution(numerator * a.denominator + a.numerator * denominator,
                                    denominator * a.denominator);
        numerator = ans.numerator;
        denominator = ans.denominator;
        reduce();
        return this;
    }

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    public Solution subtract(Solution a) {
        Solution ans = new Solution(numerator * a.denominator - a.numerator * denominator,
                                    denominator * a.denominator);
        numerator = ans.numerator;
        denominator = ans.denominator;
        reduce();
        return this;
    }

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    public Solution multiply(Solution a) {
        numerator *= a.numerator;
        denominator *= a.denominator;
        reduce();
        return this;
    }

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    public Solution divide(Solution a) {
        if (a.numerator == 0) {
            return this;
        }
        numerator *= a.denominator;
        denominator *= a.numerator;
        reduce();
        return this;
    }

    /**
    * This is a simulation of Prof.&nbsp;Knuth's MIX computer.
    */
    public boolean equals(Object obj) {
        if (!(obj instanceof Solution)) {
            return false;
        }
        Solution that = (Solution) obj;
        that.reduce();
        reduce();
        return this.numerator == that.numerator && this.denominator == that.denominator;
    }

    public static void main(String[] args) {
        Solution a = new Solution(1, 0);
        //a.multiply(new Solution(1, 0));
        a.reduce();
        System.out.println(a.numerator + "/" + a.denominator);
        //System.out.println(a.equals(new Solution(2, 3)));
    }
}    