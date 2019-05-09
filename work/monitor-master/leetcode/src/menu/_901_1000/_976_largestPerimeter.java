package menu._901_1000;

import java.util.Arrays;

public class _976_largestPerimeter {
    public int largestPerimeter1(int[] A) {
        int maxLen = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                for (int k = j + 1; k < A.length; k++) {
                    if (A[i] + A[j] > A[k] && A[i] + A[k] > A[j] && A[j] + A[k] > A[i]) {
                        maxLen = maxLen > A[i] + A[j] + A[k] ? maxLen : A[i] + A[j] + A[k];
                    }
                }
            }
        }
        return maxLen;
    }

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 0; i--) {

            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }

        }
        return 0;
    }
}
