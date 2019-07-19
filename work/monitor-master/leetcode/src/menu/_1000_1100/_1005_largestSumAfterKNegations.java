package menu._1000_1100;

import java.util.Arrays;

/**
 * @ClassName _1005_largestSumAfterKNegations
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 16:13
 * @Version 1.0
 */
public class _1005_largestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int i = 0, res = 0;
        // 翻转所有负数
        // 找到负数中的最大值.
        int minValue = Integer.MAX_VALUE;
        while (K != 0 && i < A.length && A[i] < 0) {
            A[i] = -A[i];
            minValue = minValue > A[i] ? A[i] : minValue;
            res += A[i++];
            K--;
        }
        // K此时为奇数
        // 如果后面依然存在数的话
        if (K % 2 != 0 && i < A.length) {
            int min = Math.min(minValue, A[i]);
            res -= min * 2;
        }
        for (; i < A.length; i++) {
            res += A[i];
        }
        return res;
    }
}
