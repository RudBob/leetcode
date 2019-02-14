package dp;

public class uniquePathsWithObstacles {

    // 正着走
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] countPath = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    countPath[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    countPath[0][0] = 1;
                } else if (i == 0) {
                    countPath[0][j] = countPath[0][j - 1];
                } else if (j == 0) {
                    countPath[i][0] = countPath[i - 1][0];
                } else {
                    countPath[i][j] = countPath[i - 1][j] + countPath[i][j - 1];
                }
            }
        }
        return countPath[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
