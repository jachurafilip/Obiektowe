package lab3.Shapes;

public class Trojkat extends Shape {
    public Trojkat()
    {
        edges = 3;
    }
    public void draw()
    {
        System.out.println("  X  ");
        System.out.println(" XXX ");
        System.out.println("XXXXX");
        System.out.println("");
    }
}
