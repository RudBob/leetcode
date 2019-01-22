package string.easy.day01;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName uniqueMorseRepresentations
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/20 10:52
 * @Version 1.0
 */
public class uniqueMorseRepresentations {
    String[] morseMap = {".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..", "--"
            , "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[words.length];
        Set<String> res = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            int len = words[i].length();
            for (int j = 0; j < len; j++) {
                sb.append(morseMap[words[i].charAt(j) - 'a']);
            }
            res.add(sb.toString());
        }
        return res.size();
    }
}
