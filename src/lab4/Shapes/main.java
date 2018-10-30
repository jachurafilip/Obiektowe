package lab4.Shapes;

import lab3.Shapes.Kwadrat;
import lab3.Shapes.Szesciokat;
import lab3.Shapes.Trojkat;


public class main {
    public static void main(String[] argv) {

        ShapesList shapes = new ShapesList();
        Kwadrat K = new Kwadrat();
        Trojkat T = new Trojkat();
        Szesciokat S = new Szesciokat();
        shapes.addShape(K);
        shapes.addShape(T);
        shapes.addShape(S);
        System.out.println("Przed sortowaniem: ");
        shapes.showShapes();
        shapes.sortList();
        System.out.println("Po sortowaniu: ");
        shapes.showShapes();

    }
}
