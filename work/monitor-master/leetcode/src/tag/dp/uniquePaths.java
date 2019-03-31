package tag.dp;

/**
 * @ClassName uniquePaths
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/6 15:53
 * @Version 1.0
 */
public class uniquePaths {
    /**
     * 正着走
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }



    /**
     * 倒着走
     */
    public int uniquePaths01(int m, int n) {
        int[][] map = new int[m][n];
        map[0][0] = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = map[i + 1][j] + map[i][j + 1];
                }
            }
        }
        return map[0][0];
    }
}
