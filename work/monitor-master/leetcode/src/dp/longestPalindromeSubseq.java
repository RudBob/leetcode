package dp;

import java.util.Arrays;

/**
 * @ClassName longestPalindromeSubseq
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/14 11:42
 * @Version 1.0
 */
public class longestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        char[] ch = s.toCharArray();
        int[][] memo = new int[s.length() + 1][s.length() + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        int res = longestPalindromeSubseq(ch, 0, s.length() - 1, 0, memo);
        return res == 0 ? 1 : res;
    }

    private int longestPalindromeSubseq(char[] ch, int head, int last, int len, int[][] memo) {
        if (head < last) {
            if (memo[head][last] == -1) {
                if (ch[head] == ch[last]) {
                    memo[head][last] = longestPalindromeSubseq(ch, head + 1, last - 1, 2, memo);
                } else {
                    memo[head][last] = Math.max(longestPalindromeSubseq(ch, head + 1, last, 0, memo)
                            , longestPalindromeSubseq(ch, head, last - 1, 0, memo)
                    );
                }
            }
            return memo[head][last] + len;
        } else if (head == last) {
            memo[head][last] = 1;
            return len + memo[head][last];
        } else {
            return len;
        }
    }
}
