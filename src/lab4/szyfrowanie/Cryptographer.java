package lab4.szyfrowanie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cryptographer {
    public static void cryptfile(File in, PrintWriter out, Algorithm algo)
    {
        Scanner scan = null;

        try
        {
            scan = new Scanner(in);
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        while (scan.hasNextLine())
        {
            Scanner scan2 = new Scanner(scan.nextLine());
            while (scan2.hasNext())
            {
                String s = scan2.next();
                out.print(algo.crypt(s));

            }
            out.println("");
        }
        out.close();
    }
    public static void decryptfile(File in, PrintWriter out, Algorithm algo)
    {
        Scanner scan = null;

        try
        {
            scan = new Scanner(in);
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        while (scan.hasNextLine())
        {
            Scanner scan2 = new Scanner(scan.nextLine());
            while (scan2.hasNext())
            {
                String s = scan2.next();
                out.print(algo.decrypt(s));

            }
            out.println("");
        }
        out.close();
    }

}
