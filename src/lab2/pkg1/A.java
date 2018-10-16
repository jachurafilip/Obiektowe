package lab2.pkg1;
import java.util.*;
public class A {
    protected int number;
    protected String name;

    public A(int _number, String _name)
    {
      number = _number;
      name = _name;
    }

    public void callDecrement()
    {
        this.decrement();
    }
    public void callChangeName()
    {
        Scanner read = new Scanner(System.in);
        System.out.print("Podaj nową nazwę obiektu: \n");
        String name = read.nextLine();
        this.changeName(name);
    }
    public void callIncrement()
    {
        this.increment();
    }

    protected void increment()
    {
        number++;
    }
    protected void decrement()
    {
        number--;
    }
    protected void changeName(String new_name)
    {
        name = new_name;
    }


}
