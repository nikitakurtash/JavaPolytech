import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    public static Map<String, String> load(String path) throws FileReadException, InvalidFileFormatException {
        Map<String, String> dict = new HashMap<>();
        try {
            List<String> lns = Files.readAllLines(Paths.get(path));
            for (String ln : lns) {
                String[] sep = ln.split("\\|");
                if (sep.length != 2) {
                    throw new InvalidFileFormatException("Invalid line: " + ln);
                }
                dict.put(sep[0].trim().toLowerCase(), sep[1].trim());
            }
        } catch (IOException e) {
            throw new FileReadException("Error read dictionary files: ", e);
        }
        return dict;
    }
}
