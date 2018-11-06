package lab5.photos;

import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Photo {
    public static String apikey = "82e61dba77d1addd993e973864714c4c";

    public static void RecongizePhoto(String photo, Indico indico, IndicoResult single) throws IOException, IndicoException
    {
        single = indico.imageRecognition.predict(photo);
        Map<String,Double> result = single.getImageRecognition();
        System.out.print(result);

    }

    public static void main(String[] argv) throws IndicoException
    {
        Indico indico = new Indico(apikey);
        String photo = "foto/bocian.jpg";
        IndicoResult indicoResult = null;
        try {
            RecongizePhoto(photo,indico,indicoResult);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }
}

