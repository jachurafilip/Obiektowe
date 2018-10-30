package lab4.szyfrowanie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class main {
    public static void main(String[] argv)
    {
        int cypher = 0;
        int algorithm = 0;
        File in = new File(argv[0]);
        PrintWriter out = null;
        try
        {
            out = new PrintWriter(argv[1]);
        } catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("1. Cypher");
        System.out.println("2. Decypher");

        String choice = scan.nextLine();
        if(choice.equals("1")) cypher = 1;
        else if(choice.equals("2")) cypher = 2;
        else System.out.println("Podano złą wartość");

        System.out.println("1. ROT11");
        System.out.println("2. Polibiusz");
        choice = scan.nextLine();
        if(choice.equals("1")) algorithm = 1;
        else if (choice.equals("2")) algorithm = 2;

        if(algorithm==1)
        {
            if(cypher==1)
            {
                Cryptographer.cryptfile(in,out,new ROT11());
            }
            else if (cypher==2)
            {
                Cryptographer.decryptfile(in,out,new ROT11());
            }
        }
        else if(algorithm==2)
        {
            if(cypher==1)
            {
                Cryptographer.cryptfile(in,out,new Polibiusz());
            }
            else if (cypher==2)
            {
                Cryptographer.decryptfile(in,out,new Polibiusz());
            }
        }

    }
}
