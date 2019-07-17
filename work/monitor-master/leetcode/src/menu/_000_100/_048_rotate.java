package menu._000_100;

/**
 * @ClassName _048_rotate
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/15 15:20
 * @Version 1.0
 */
public class _048_rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public void rotate1(int[][] matrix) {
        int[] temp = new int[matrix.length];
        rotate(matrix, temp, matrix.length, 0);
    }

    private void rotate(int[][] matrix, int[] temp, int n, int m) {
        if ((n + 1) / 2 - 1 < m) {
            return;
        }
        // 最上面的 i 是 m , j 的范围是[m, n - 1 - m)
        // 最左面的 j 是 m , i 的范围是[m, n - 1 - m)
        // 最下面的 i 是 n - 1 - m, j 的范围是[m, n - 1 - m)
        // 最右面的 j 是 n - 1 - m, i 的范围是[m, n - 1 - m)
        for (int i = 0; i < n - m - 1; i++) {
            temp[i] = matrix[m][i + m];
        }
        // 左面的向上面移动
        for (int i = m + 1, j = m; i < n - m; i++) {
            matrix[j][n - 1 - i] = matrix[i][j];
        }
        // 下面的向左面移动
        for (int j = m + 1, i = n - 1 - m; j < n - m; j++) {
            matrix[j][m] = matrix[i][j];
        }
        // 右面的向下面移动
        for (int i = m, j = n - 1 - m; i < n - m - 1; i++) {
            matrix[j][n - 1 - i] = matrix[i][j];
        }
        // 上面的向右面移动
        int j = n - 1 - m;
        for (int i = m; i < n - m - 1; i++) {
            matrix[i][j] = temp[i - m];
        }
        rotate(matrix, temp, n, m + 1);
    }
}
