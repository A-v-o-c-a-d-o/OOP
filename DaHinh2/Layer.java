package DaHinh2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Layer {
    private List<Shape> shapes;

    public Layer() {
        shapes = new LinkedList<>();
    }

    /** add shape. */
    public void addShape(Shape a) {
        if (a != null) {
            shapes.add(a);
        }
    }

    /** remove all circle. */
    public void removeCircles() {
        shapes.removeIf(i -> i instanceof Circle);
    }

    /** get all infomation. */
    public String getInfo() {
        String ans = "Layer of crazy shapes:\n";
        for (Shape i: shapes) {
            ans += i + "\n";
        }
        return ans;
    }

    /** remove duplicates shape. */
    public void removeDuplicates() {
        Set<Shape> s = new HashSet<>();
        for (Shape i: shapes) {
            s.add(i);
        }
        shapes = new LinkedList<>();
        for (Shape i: s) {
            shapes.add(i);
        }
    }
}