package tag.string;

import java.util.*;

public class mostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 首先处理段落
        char[] a = paragraph.toCharArray();
        // removeSymbol
        int len = removeSymbol(a);
        StringBuilder tempStr = new StringBuilder();
        for (int i = 0; i < len; i++) {
            tempStr.append(a[i]);
        }
        String thePa = tempStr.toString();
        // 通过空格分离
        String[] words = thePa.split(" ");
        boolean[] flag = new boolean[words.length];
        // 所有被禁用的单词都被置为true
        removeBannedWord(banned, words, flag);
        return findMostWords(words, flag);
    }

    private String findMostWords(String[] words, boolean[] flag) {
        Map<String, Integer> count = new HashMap<>(words.length * 2);
        for (int i = 0; i < words.length; i++) {
            if (flag[i]) {
                continue;
            }
            Integer countNum = count.get(words[i]);
            if (countNum == null) {
                count.put(words[i], 1);
            } else {
                count.put(words[i], countNum + 1);
            }
        }
        String mostStr = null;
        int maxCount = 0;
        for (int i = 0; i < words.length; i++) {
            if (flag[i]) {
                continue;
            }
            Integer countNum = count.get(words[i]);
            if (countNum > maxCount) {
                maxCount = countNum;
                mostStr = words[i];
            }
        }
        return mostStr;
    }

    private void removeBannedWord(String[] banned, String[] words, boolean[] flag) {
        Set<String> bannedWords = new HashSet<>(banned.length);
        Collections.addAll(bannedWords, banned);
        for (int i = 0; i < words.length; i++) {
            if (!flag[i] && bannedWords.contains(words[i])) {
                flag[i] = true;
            }
        }
    }

    private int removeSymbol(char[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            if (Character.isLetter(a[i])) {
                a[i] = Character.toLowerCase(a[i]);
            } else if (a[i] != ' ') {
                // 避免那些只有符号作为分割单词的标志，将其改为空格.
                if (i < len - 1 && i > 0 && Character.isLetter(a[i - 1]) && Character.isLetter(a[i + 1])) {
                    a[i] = ' ';
                } else {
                    // 移除这个char，下标改变
                    for (int j = i; j < len - 1; j++) {
                        a[j] = a[j + 1];
                    }
                    len--;
                }
            }
        }
        return len;
    }
}
