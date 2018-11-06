package lab5.subtitles;

public class WrongFramesException extends Exception {
    public WrongFramesException(String line)
    {
        super("Wrong frames order on line ".concat(line));
    }
}
