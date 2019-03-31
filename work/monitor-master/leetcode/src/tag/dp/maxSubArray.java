package tag.dp;

public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int now, max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            now = pre > 0 ? pre + nums[i] : nums[i];
            pre = now;
            if (max < now) {
                max = now;
            }
        }
        return max;
    }
}
