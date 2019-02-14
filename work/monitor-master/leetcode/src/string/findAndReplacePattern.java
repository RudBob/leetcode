package string;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName findAndReplacePattern
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/27 10:24
 * @Version 1.0
 */
public class findAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>(words.length);
        for (String word : words) {
            if (likePattern(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean likePattern(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        char[] wordChars = word.toCharArray();
        boolean[] flagOfLetter = new boolean[26];
        boolean[] flagOfWord = new boolean[wordChars.length];
        for (int i = 0; i < word.length(); i++) {
            int indexOfLetter = pattern.charAt(i) - 'a';
            if (!flagOfWord[i] && !flagOfLetter[indexOfLetter]) {
                char k = wordChars[i];
                flagOfLetter[indexOfLetter] = true;
                // 如果这个字母已经被转化过，那么结束.
                for (int j = i; j < word.length(); j++) {
                    if (wordChars[j] == k && !flagOfWord[j]) {
                        flagOfWord[j] = true;
                        wordChars[j] = pattern.charAt(i);
                    }
                }
            }
        }
        for (int i = 0; i < word.length(); i++) {
            if (wordChars[i] != pattern.charAt(i)) {
                return false;
            }
        }
        return true;

    }
}
