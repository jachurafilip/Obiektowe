package lab2.pkg2;

import lab2.pkg1.*;

public class C extends B {
    public C(int number, String name)
    {
       super(number,name);
    }

    void ChangeName(String new_name)
    {
        name = new_name;
    }

}


