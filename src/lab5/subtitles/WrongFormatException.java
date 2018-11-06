package lab5.subtitles;

public class WrongFormatException extends Exception {
    public WrongFormatException(String line)
    {
        super("Wrong format on line number".concat(line));
    }
}
