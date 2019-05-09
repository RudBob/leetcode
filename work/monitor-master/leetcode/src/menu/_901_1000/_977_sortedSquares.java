package menu._901_1000;

import java.util.Arrays;

public class _977_sortedSquares {
    public int[] sortedSquaresByTwoIndex(int[] A) {
        // 双指针法.
        int head = 0;
        int last = A.length - 1;
        int[] res = new int[A.length];
        int resIndex = A.length - 1;
        while (resIndex != -1) {
            int h = A[head] * A[head];
            int l = A[last] * A[last];
            if (h < l) {
                last--;
                res[resIndex] = l;
            } else {
                head++;
                res[resIndex] = h;
            }
            resIndex--;
        }
        return res;
    }

    public int[] sortedSquaresBySort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
