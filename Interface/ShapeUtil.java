package Interface;

import java.util.List;

public class ShapeUtil {
    /** create. */
    public String printInfo(List<GeometricObject> shapes) {
        String ans = "Circle:\n";
        for (Object i: shapes) {
            if (i instanceof Circle) {
                Circle j = (Circle) i;
                ans += j.getInfo() + "\n";
            }
        }
        ans += "Triangle:\n";
        for (Object i: shapes) {
            if (i instanceof Triangle) {
                Triangle j = (Triangle) i;
                ans += j.getInfo() + "\n";
            }
        }
        return ans;
    }
}
