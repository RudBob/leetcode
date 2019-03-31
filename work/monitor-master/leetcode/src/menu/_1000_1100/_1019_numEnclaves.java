package menu._1000_1100;

public class _1019_numEnclaves {

    public int numEnclaves(int[][] A) {
        // 一个深搜，之后一个遍历
        // 找到所有第一排和最后一排的 陆地，将其相连的陆地置为 2
        for (int j = 0; j < A[0].length; j++) {
            if (A[0][j] == 1) {
                dfs(0, j, A);
            }
        }
        for (int j = 0; j < A[A.length - 1].length; j++) {
            if (A[A.length - 1][j] == 1) {
                dfs(A.length - 1, j, A);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 1) {
                dfs(i, 0, A);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i][A[0].length - 1] == 1) {
                dfs(i, A[0].length - 1, A);
            }
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    int[][] next = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    private void dfs(int i, int j, int[][] a) {
        a[i][j] = 2;
        for (int k = 0; k < 4; k++) {
            int nextI = i + next[k][0];
            int nextJ = j + next[k][1];
            if (nextI >= 0 && nextJ >= 0 && nextJ < a[0].length && nextI < a.length && a[nextI][nextJ] == 1) {
                dfs(nextI, nextJ, a);
            }
        }
    }
}
