package menu._601_700;

public class _695_maxAreaOfIsland {

    static int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] counted = new boolean[grid.length][grid[0].length];
        maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 是岛屿，并且没有被计算过
                if (grid[i][j] == 1 && !counted[i][j]) {
                    area = 1;
                    counted[i][j] = true;
                    maxAreaOfIsland(grid, counted, i, j);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }

    int area = 0;
    int[][] next = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    private void maxAreaOfIsland(int[][] grid, boolean[][] counted, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + next[i][0];
            int nextY = y + next[i][1];
            if (isLegal(grid, nextX, nextY) && grid[nextX][nextY] == 1 && !counted[nextX][nextY]) {
                area++;
                counted[nextX][nextY] = true;
                maxAreaOfIsland(grid, counted, nextX, nextY);
            }
        }
    }

    private boolean isLegal(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
