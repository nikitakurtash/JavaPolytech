import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            Map<String, String> dict = Dictionary.load("src/dictionary.txt");
            Translator translator = new Translator(dict);
            String for_translation = new String(Files.readAllBytes(Paths.get("src/input.txt")));
            String translated = translator.translate(for_translation);
            System.out.println(translated);
        } catch (InvalidFileFormatException | FileReadException e) {
            System.err.println("E: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error read file: " + e.getMessage());
        }
    }
}