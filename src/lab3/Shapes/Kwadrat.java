package lab3.Shapes;

public class Kwadrat extends Shape {
    public void draw()
    {
        for(int i =0; i<11;i++)
        {
            for(int j=0; j<11;j++)
            {
                System.out.print("X");
            }
            System.out.println("");
        }
    }

}
