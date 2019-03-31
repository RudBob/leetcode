package tag.dp;

/**
 * @ClassName findTargetSumWays
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/11 22:35
 * @Version 1.0
 */
public class findTargetSumWays {


    /**
     * 完全无法理解的最有解法
     */
    public int findTargetSumWays_others(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int[] max = new int[nums.length];
        max[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            max[i] = nums[i] + max[i + 1];
        }
        findTargetSumWays(nums, S, 0, 0, max);
        return count;
    }

    private void findTargetSumWays(int[] nums, int target, int sum, int index, int[] max) {
        if (index == nums.length) {
            if (target == sum) {
                count++;
            }
            return;
        }
        if ((sum > target && sum - max[index] > target) || (sum < target && sum + max[index] < target)) {
            return;
        }
        findTargetSumWays(nums, target, sum + nums[index], index + 1, max);
        nums[index] *= -1;
        findTargetSumWays(nums, target, sum + nums[index], index + 1, max);
    }
}
