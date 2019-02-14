package dp;

/**
 * @ClassName minFallingPathSum
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/8 14:44
 * @Version 1.0
 */
public class minFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] += getMin(A, i + 1, j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A[0].length; i++) {
            if (min > A[0][i]) {
                min = A[0][i];
            }
        }
        return min;
    }

    private int getMin(int[][] a, int i, int j) {
        if (j == 0) {
            return Math.min(a[i][j], a[i][j + 1]);
        } else if (j == a[i].length - 1) {
            return Math.min(a[i][j], a[i][j - 1]);
        }
        return Math.min(Math.min(a[i][j], a[i][j - 1]), a[i][j + 1]);
    }
}
