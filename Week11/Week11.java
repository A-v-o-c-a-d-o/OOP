package Week11;

import java.util.List;

public class Week11 {
    /** sort. */
    public static <T extends Comparable<T>> List<T> sortGeneric(List<T> a) {
        for (int i = 0; i < a.size(); i++) {
            int j = i;
            while (j > 0 && a.get(j).compareTo(a.get(j - 1)) < 0) {
                T t = a.get(j);
                a.set(j, a.get(j - 1));
                a.set(j - 1, t);
                j--;
            }
        }
        return a;
    }
}