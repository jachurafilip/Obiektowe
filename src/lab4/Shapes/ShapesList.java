package lab4.Shapes;

import lab3.Shapes.Shape;

import java.util.Collections;
import java.util.LinkedList;

public class ShapesList {
    public ShapesList() {
        shapes = new LinkedList<>();
    }

    public LinkedList<Shape> shapes;

    public void addShape(Shape s) {
        shapes.add(s);
    }

    public void showShapes() {
        for (var s : shapes) {
            s.draw();
        }
    }

    public void sortList() {
        Collections.sort(shapes, new EdgesComparator());
    }
}
