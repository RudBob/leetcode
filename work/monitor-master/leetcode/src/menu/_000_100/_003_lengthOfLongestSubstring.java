package menu._000_100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _003_lengthOfLongestSubstring {
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();
        Set<Character> characters = new HashSet<>();
        int max = chs.length == 0 ? 0 : 1;
        for (int right = 0, left = 0; right < chs.length; right++) {
            while (characters.contains(chs[right])) {
                characters.remove(chs[left++]);
            }
            characters.add(chs[right]);
            int len = characters.size();
            max = len > max ? len : max;
        }
        return max;
    }

    // 动规.
    public int lengthOfLongestSubstring1(String s) {
        char[] chs = s.toCharArray();
        // 字符再指定长度中不会重复
        int[] noAgainLen = new int[chs.length];
        // init idx
        initNoRepeatLen(chs, noAgainLen);
        // 遍历noAgainLen
        int maxLen = 0;
        for (int i = noAgainLen.length - 2; i >= 0; i--) {
            // 如果前者的值比后者的值+1还要大，那么替换.
            noAgainLen[i] = noAgainLen[i] > noAgainLen[i + 1] + 1 ? noAgainLen[i + 1] + 1 : noAgainLen[i];
            maxLen = maxLen < noAgainLen[i] ? noAgainLen[i] : maxLen;
        }
        return maxLen == 0 ? s.length() : maxLen;
    }

    private void initNoRepeatLen(char[] chs, int[] noAgainLen) {
        for (int i = 0; i < chs.length; i++) {
            noAgainLen[i] = chs.length - i;
        }
        Map<Character, Integer> chToPreIdx = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            // 如果之前出现过，更新其所在nextIdx
            if (chToPreIdx.get(chs[i]) != null) {
                int preIdx = chToPreIdx.get(chs[i]);
                noAgainLen[preIdx] = i - preIdx;
            }
            chToPreIdx.put(chs[i], i);
        }
    }
}
