package menu._000_100;

/**
 * @ClassName _059_generateMatrix
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/16 9:26
 * @Version 1.0
 */
public class _059_generateMatrix {
    int[][] next = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public int[][] generateMatrix(int n) {
        int count = 1;
        int[][] matrix = new int[n][n];
        int x = 0, y = -1;
        do {
            for (int i = 0; i < 4; i++) {
                int X = x + next[i][0];
                int Y = y + next[i][1];
                while (X >= 0 && X < n && Y >= 0 && Y < n && matrix[X][Y] == 0) {
                    matrix[X][Y] = count++;
                    x = X;
                    y = Y;
                    X = x + next[i][0];
                    Y = y + next[i][1];
                }
            }
        } while (count <= n * n);

        return matrix;
    }
}
