package dp;

/**
 * @ClassName stoneGame
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/5 19:40
 * @Version 1.0
 */
public class stoneGame {
    public boolean stoneGame(int[] piles) {
        int size = piles.length;
        int[][] dp = new int[size][size];
        // 在
        for (int i = 0; i < size; i++) {
            dp[i][i] = piles[i];
        }
        //
        for (int l = 2; l <= size; l++) {
            for (int i = 0; i <= size - l; i++) {
                int j = i + l - 1;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][size - 1] > 0;
    }
    // 或者数学推导：先手必胜
}
