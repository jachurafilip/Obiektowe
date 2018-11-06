package lab5.subtitles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Delay {
    public static void main(String[] argv)
    {
        try
        {
            File input = new File(argv[0]);
            Scanner scan = new Scanner(input);
            PrintWriter output = new PrintWriter(argv[1]);

            delay(scan, output, Integer.parseInt(argv[2]),Integer.parseInt(argv[3]));


        }
        catch (ArrayIndexOutOfBoundsException ex)
        {
            System.out.println("Program parameteres must be: input file, output file, delay, fps");
        }
        catch (WrongFramesException | WrongFormatException | IllegalArgumentException| FileNotFoundException ex)
        {
            System.err.println(ex.getMessage());
        }
        catch (Throwable ex)
        {
            System.err.print("Thrown unknown exception");
            System.err.println("on lane"+ex.getStackTrace()[0].getLineNumber());
        }

    }

    public static void delay(Scanner scanner, PrintWriter output, int delay, int fps)
            throws WrongFormatException, WrongFramesException, IllegalArgumentException
    {

        if(fps<1)
        {
            throw new IllegalArgumentException("FPS must be positive");
        }

        Pattern pattern = Pattern.compile("\\{(\\d+)\\}\\{(\\d+)\\}(.+)");

        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            Matcher matcher = pattern.matcher(line);
            if(matcher.find())
            {
                int start = Integer.parseInt(matcher.group(1))+(delay*fps/1000);
                int end = Integer.parseInt(matcher.group(2))+(delay*fps/1000);
                if(end<start) throw new WrongFramesException(line);
                StringBuilder result = new StringBuilder();
                result.append("{").append(start).append("}{").append(end).append("}").append(matcher.group(3));
                output.println(result.toString());
            }
            else throw new WrongFormatException(line);
        }
    }
}
