package lab2.pkg1;

import lab2.pkg1.A;

public class B extends A {
    public B(int number, String name)
    {
        super(number,name);
    }
    void ChangeName(String new_name)
    {
        name = new_name;
    }
    protected void decrement()
    {
        number-=2;
    }
    protected void increment()
    {
        number+=2;
    }

}
