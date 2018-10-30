package lab4.pracownicy;

public class PracownikEtatowy extends Pracownik {
    public PracownikEtatowy(String pesel, double placa)
    {
        super(pesel, placa);
    }
    public double netto()
    {
        return 0.65*wyn_brutto;
    }
}
