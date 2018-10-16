package lab2.pkg1;

import lab2.pkg2.*;
public class Test {
    public static void main(String[] args)
    {
       B obj = new C(1,"a");

        obj.callIncrement();
        obj.callChangeName();

        System.out.println(obj.number);
        System.out.println(obj.name);
    }

}
