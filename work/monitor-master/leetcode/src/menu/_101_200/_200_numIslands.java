package menu._101_200;

public class _200_numIslands {

    public int numIslands(char[][] A) {
        int countIsland = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == '1' ) {
                    countIsland++;
                    // 第一座岛
                    countIsland(A, i, j);
                }
            }
        }
        return countIsland;
    }

    int[][] next = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    private void countIsland(char[][] a, int x, int y) {
        if (a[x][y] == '1') {
            a[x][y] = '2';
        }
        // 深搜
        for (int i = 0; i < 4; i++) {
            int newX = x + next[i][0];
            int newY = y + next[i][1];
            if (isValid(newX, newY, a) && a[newX][newY] == '1') {
                countIsland(a, newX, newY);
            }
        }
    }
    private boolean isValid(int newX, int newY, char[][] a) {
        return newX >= 0 && newY >= 0 && newX < a.length && newY < a[newX].length;
    }
}
