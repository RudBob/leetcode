package menu._1000_1100;

import java.util.LinkedList;
import java.util.Queue;

public class _1004_longestOnes {

    //1004
    public int longestOnes(int[] A, int K) {
        if (K == 0) {
            // 找最长的 一串
            int maxLen = 0;
            int len = 0;

            for (int i = 0; i < A.length; i++) {
                if (A[i] == 1) {
                    len++;
                } else {
                    if (len > maxLen) {
                        maxLen = len;
                    }
                    len = 0;
                }
            }
            return maxLen;
        }
        Queue<Integer> queue = new LinkedList<>();
        // 从前往后遍历改变
        // 首先先尽力改变
        int maxLen = 0;
        int i = 0;
        while (i < A.length && queue.size() < K) {
            if (A[i] == 0) {
                queue.add(i);
                A[i] = 1;
            }
            i++;
        }
        if (i == A.length) {
            int indexFirstOne = queue.peek();
            int len = findPreLen(indexFirstOne, A) + findLasrLen(A, indexFirstOne) + 1;
            if (len > maxLen) {
                maxLen = len;
            }
        }
        while (i < A.length) {
            // 找最长的一
            int indexFirstOne = queue.peek();
            int len = findPreLen(indexFirstOne, A) + findLasrLen(A, indexFirstOne) + 1;
            if (len > maxLen) {
                maxLen = len;
            }
            int k = queue.remove();
            A[k] = 0;
            while (i < A.length && A[i] != 0) {
                i++;
            }
            if (i == A.length) {
                return maxLen;
            } else {
                queue.add(i);
                A[i] = 1;
                i++;
            }
        }
        return maxLen;
    }

    private int findLasrLen(int[] a, int indexFirstOne) {
        int count = 0;
        for (int i = indexFirstOne + 1; i < a.length && a[i] == 1; i++) {
            count++;
        }
        return count;
    }

    private int findPreLen(int indexFirstOne, int[] a) {
        int count = 0;
        for (int i = indexFirstOne - 1; i >= 0 && a[i] == 1; i--) {
            count++;
        }
        return count;
    }
}
