package lab3.Shapes;

public class Szesciokat extends Shape{
    public Szesciokat()
    {
        edges = 6;
    }
    public void draw()
    {
        System.out.println("  XXX  ");
        System.out.println(" XXXXX ");
        System.out.println("XXXXXXX");
        System.out.println(" XXXXX ");
        System.out.println("  XXX  ");
        System.out.println("");
    }
}
