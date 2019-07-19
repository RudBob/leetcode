package menu._000_100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName _004_longestPalindrome
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/17 16:12
 * @Version 1.0
 */
public class _004_longestPalindrome {
    // 中心扩散法(优化版).
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] range = new int[2];
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            i = find(c, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    // 找到以 i 或 i + 0.5 为轴的回文子串.
    private int find(char[] c, int low, int[] range) {
        int max = c.length - 1;
        int high = low;
        while (high < max && c[high + 1] == c[low]) {
            high++;
        }
        int result = high;
        // 中心扩散.
        while (low > 0 && high < max && c[low - 1] == c[high + 1]) {
            low--;
            high++;
        }
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        // 此时一定是 aaa, abbba, accbcca此类情况，直接跳过这些aaa,abbba,accbcca,进入下一个字符即可。
        return result;
    }
    // 动态规划
    public String longestPalindrome2(String s) {
        if (s.length() == 0) {
            return "";
        }
        int resIdx = 0;
        Queue<Integer> changedIdxs = new LinkedList<>();
        char[] chars = s.toCharArray();
        int[] len = new int[chars.length];
        // 奇数长度
        Arrays.fill(len, 1);
        for (int i = 1; i < chars.length; i++) {
            changedIdxs.add(i);
        }
        resIdx = getResIdx(changedIdxs, chars, len, resIdx);

        // 偶数长度
        int maxLen = len[resIdx];
        int resIdx2 = 0;
        Arrays.fill(len, 0);
        // 再找一遍偶数的可能.
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                changedIdxs.add(i - 1);
                len[i - 1] = 2;
                resIdx2 = i - 1;
            }
        }
        resIdx2 = getResIdx(changedIdxs, chars, len, resIdx2);

        if (maxLen < len[resIdx2]) {
            resIdx = resIdx2;
            maxLen = len[resIdx2];
        }

        // resIdx 是起始坐标，len[idx] 是字符长度.
        return s.substring(resIdx, resIdx + maxLen);
    }

    private int getResIdx(Queue<Integer> changedIdxs, char[] chars, int[] len2, int resIdx2) {
        while (changedIdxs.size() != 0) {
            //  找到对应的idx.
            int idx = changedIdxs.remove() - 1;
            if (idx >= 0 && idx < chars.length - 1 && idx + 1 + len2[idx + 1] < chars.length &&
                    chars[idx] == chars[idx + 1 + len2[idx + 1]]) {
                // 变化，值改变.
                len2[idx] = len2[idx + 1] + 2;
                resIdx2 = idx;
                changedIdxs.add(idx);
            }
        }
        return resIdx2;
    }
    // 中心扩散法
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] sChars = s.toCharArray();
        // 找对称轴
        SubCharArrIndex sub = new SubCharArrIndex(0, 0);
        for (int i = 0; i < sChars.length * 2 - 1; i++) {
            // 对称轴
            if (i % 2 == 1) {
                // 奇数，则长度为偶数.
                getMaxLength(sChars, i / 2, i / 2 + 1, sub);
            } else {
                // 偶数， 则长度为奇数.
                getMaxLength(sChars, i / 2, i / 2, sub);
            }
        }
        String res = new String(sChars, sub.head, sub.last - sub.head + 1);
        return res;
    }

    private void getMaxLength(char[] sChars, int headIndex, int lastIndex, SubCharArrIndex sub) {
        while (headIndex >= 0 && lastIndex < sChars.length) {
            if (sChars[headIndex] != sChars[lastIndex]) {
                break;
            }
            headIndex--;
            lastIndex++;
        }
        if (--lastIndex >= ++headIndex && sub.isLess(headIndex, lastIndex)) {
            sub.head = headIndex;
            sub.last = lastIndex;
        }
    }

}

class SubCharArrIndex {
    int head;
    int last;

    public SubCharArrIndex(int head, int last) {
        this.head = head;
        this.last = last;
    }

    public boolean isLess(int head, int last) {
        return (last - head) > (this.last - this.head);
    }
}


