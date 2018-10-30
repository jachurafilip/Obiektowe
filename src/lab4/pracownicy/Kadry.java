package lab4.pracownicy;

import java.util.LinkedList;

public class Kadry {
    public LinkedList<Pracownik> pracownicy;

    public void add(String pesel, double placa, boolean student)
    {
        if(student)
        {
            pracownicy.add(new Student(pesel,placa));
        }
        else
        {
            pracownicy.add(new PracownikEtatowy(pesel,placa));
        }
    }
    public boolean remove(String pesel)
    {
        boolean removed = false;
        for(var pracownik: pracownicy)
        {
         if(pracownik.pesel.getPesel()==pesel)
         {
             pracownicy.remove(pracownik);
             removed = true;
         }
        }
        return removed;
    }
    public double getBrutto(String pesel)
    {
        double result;
        for(var pracownik: pracownicy)
        {
            if(pracownik.pesel.getPesel()==pesel)
            {
                return pracownik.brutto();
            }
        }
        return -1;
    }
    public double getNetto(String pesel)
    {
        for(var pracownik: pracownicy)
        {
            if(pracownik.pesel.getPesel()==pesel)
            {
                return pracownik.netto();
            }
        }
        return -1;
    }
    public void setBrutto(String pesel, double brutto)
    {
        for(var pracownik: pracownicy)
        {
            if(pracownik.pesel.getPesel()==pesel)
            {
                pracownik.setBrutto(brutto);
            }
        }
    }
}
