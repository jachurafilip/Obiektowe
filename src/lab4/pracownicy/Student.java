package lab4.pracownicy;

import lab1.Pesel;

public class Student extends Pracownik {
    public Student(String pesel,double placa)
    {
        super(pesel,placa);
    }

    public double netto()
    {
        return wyn_brutto*0.81;
    }



}
