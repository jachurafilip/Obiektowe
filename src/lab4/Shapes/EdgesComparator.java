package lab4.Shapes;

import lab3.Shapes.Shape;

import java.util.Comparator;

public class EdgesComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return o1.edges-o2.edges;
    }
}
