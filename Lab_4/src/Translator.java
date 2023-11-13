import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translator {
    private Map<String, String> dict;

    public Translator(Map<String, String> dict) {
        this.dict = dict;
    }

    public String rmSpace(String txt) {
        return txt.replaceAll("\\s+([.,!?;])", "$1");
    }

    public String translate(String txt) {
        Matcher eq = Pattern.compile("[\\w']+|[.,!?;]").matcher(txt);
        List<String> symb = new ArrayList<>();
        while (eq.find()) {
            symb.add(eq.group());
        }
        StringBuilder translation = new StringBuilder();
        int pos = 0;

        while (pos<symb.size()){
            String current = "";
            String best = null;
            int used = 0;

            for(int i = pos; i < symb.size(); i++) {
                String s = symb.get(i).toLowerCase();
                String s_punkt = s.replaceAll("[.,!?;]", "");
                current += (i>pos ? " " : "") + s_punkt;
                if (dict.containsKey(current)) {
                    best = dict.get(current);
                    used = i - pos + 1;
                }
            }
            if (best != null) {
                translation.append(best);
                pos += used;
            } else {
                translation.append(symb.get(pos));
                pos++;
            }

            if (pos < symb.size()) {
                translation.append(" ");
            }
        }
        return rmSpace(translation.toString());
    }
}