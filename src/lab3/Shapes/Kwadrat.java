package lab3.Shapes;

public class Kwadrat extends Shape {
    public Kwadrat()
    {
        edges = 4;
    }
    public void draw()
    {
        for(int i =0; i<3;i++)
        {
            for(int j=0; j<5;j++)
            {
                System.out.print("X");
            }
            System.out.println("");
        }
        System.out.println("");
    }

}
