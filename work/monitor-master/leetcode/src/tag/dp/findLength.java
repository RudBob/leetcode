package tag.dp;

/**
 * @ClassName findLength
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/12 16:05
 * @Version 1.0
 */
public class findLength {
    /**
     * 使用dp数组.
     *
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int maxLen = 0;
        int[][] dp = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    if (i != 0 && j != 0) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        maxLen = maxLen < dp[i][j] ? dp[i][j] : maxLen;
                    } else {
                        dp[i][j] = 1;
                    }
                }
            }
        }
        return maxLen;
    }


    int len = 0;

    // 先写出暴力解法.
    public int findLength_01(int[] A, int[] B) {
        for (int bi = 0; bi < B.length - len; bi++) {
            findLen(A, B, bi);
        }
        return len;
    }


    private void findLen(int[] a, int[] b, int bi) {
        int len1 = 0;
        int b0 = bi;
        for (int ai = 0; ai < a.length && bi < b.length; ai++) {
            if (b[bi] == a[ai]) {
                len1++;
                bi++;
            } else if (len1 != 0) {
                if (len < len1) {
                    len = len1;
                }
                ai -= len1;
                len1 = 0;
                bi = b0;
            }
        }
        if (len1 != 0 && len < len1) {
            len = len1;
        }
    }
}
