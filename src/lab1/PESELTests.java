package lab1;

import java.util.Scanner;

public class PESELTests {
    public static void main(String[] args){
        String pesel;
		System.out.println("Podaj pesel");
		Scanner read = new Scanner(System.in);
		pesel = read.nextLine();
		if(Pesel.check(pesel)) System.out.println("Dobry pesel");
		else System.out.println("Zly pesel");
        }
    }