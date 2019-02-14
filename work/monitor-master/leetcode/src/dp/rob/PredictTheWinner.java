package dp.rob;

/**
 * @ClassName PredictTheWinner
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/10 14:13
 * @Version 1.0
 */
public class PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        // 偶数时，先手必胜
        if (nums.length % 2 == 0) {
            return true;
        }
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int l = 1; l < nums.length; l++) {
            for (int i = 0; i < nums.length - l; i++) {
                int j = i + l;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
}
