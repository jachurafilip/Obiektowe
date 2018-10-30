package lab4.pracownicy;

import lab1.Pesel;

public abstract class Pracownik {
    public Pesel pesel;
    public double wyn_brutto;

    public Pracownik(String pesel, double placa)
    {
        this.pesel = new Pesel(pesel);
        wyn_brutto = placa;
    }
    public double brutto()
    {
        return wyn_brutto;
    }

    public void setBrutto(double wyn_brutto) {
        this.wyn_brutto = wyn_brutto;
    }

    public abstract double netto();
}
