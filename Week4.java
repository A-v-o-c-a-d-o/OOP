public class Week4 {
    public static int max2Int(int a, int b) { return Math.max(a, b); }

    /** An especially short bit of Javadoc. */
    public static int minArray(int[] arr) {
        int ans = arr[0];
        for (int i: arr)
            if (i < ans)
                ans = i;
        return ans;
    }

    public static String calculateBMI(double weight, double height) {
        double IBM = (double) Math.round(10 * weight/(height*height)) / 10;

        if (IBM < 18.5)
            return "Thiếu cân";
        else if (IBM < 23)
            return "Bình thường";
        else if (IBM < 25)
            return "Thừa cân";
        else 
            return "Béo phì";
    }
}