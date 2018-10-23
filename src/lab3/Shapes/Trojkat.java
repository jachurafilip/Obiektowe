package lab3.Shapes;

public class Trojkat extends Shape {
    public void draw()
    {
        for (int i=0;i<6;i++)
        {
            for(int j=0;j<i;j++)
            {
                System.out.print("X");
            }
         System.out.println("");
        }
    }
}
