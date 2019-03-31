package tag.dp;

import java.util.List;

/**
 * @ClassName wordBreak
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/16 13:46
 * @Version 1.0
 */
public class wordBreak {
    /**
     * 动态规划.
     */

    /**
     * 动态规划.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] canSege = new boolean[s.length()];
        // 把 0 作为起始点.
        canSege[0] = true;
        // 外层为子串的结束下标的后一位.
        for(int endIndexPlus = 1, len = s.length(); endIndexPlus <= len; endIndexPlus++){
            // 子串的头部，当然要小于尾部的后一位。
            for(int beginIndex = 0; beginIndex < endIndexPlus; beginIndex++){
                // 字串的头部之前必须是可以呗拆解为字典中值的组合
                // 子串如果在字典中存在，那么说明在(0,endIndex)组成的串中，可以被拆解为字典.
                if(canSege[beginIndex] &&
                        wordDict.contains(
                                s.substring(beginIndex,endIndexPlus)
                        )
                ){
                    canSege[endIndexPlus] = true;
                    break;
                }
            }
        }
        return canSege[s.length()];

    }

    /**
     * 暴力虽好，但是超时严重
     */
    public boolean wordBreak2(String s, List<String> wordDict) {
        return wordBreak2(s, wordDict, 0);
    }

    private boolean wordBreak2(String s, List<String> wordDict, int i) {
        if (i == s.length()) {
            return true;
        }
        boolean res = false;
        for (String word : wordDict) {
            int nextIndex = isWord(word, s, i);
            if (nextIndex != -1) {
                res = wordBreak2(s, wordDict, nextIndex);
                if (res) {
                    return true;
                }
            }
        }
        return res;

    }

    private int isWord(String word, String s, int i) {
        int wordIndex = 0;
        for (int j = i, sLen = s.length(), wordLen = word.length();
             j < sLen && wordIndex < wordLen; j++, wordIndex++) {
            if (s.charAt(j) != word.charAt(wordIndex)) {
                return -1;
            }
        }
        if (wordIndex < word.length()) {
            return -1;
        }
        return i + word.length();
    }
}
