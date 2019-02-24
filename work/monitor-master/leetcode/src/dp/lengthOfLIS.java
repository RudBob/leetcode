package dp;

/**
 * @ClassName lengthOfLIS
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/14 20:49
 * @Version 1.0
 */
public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        // 从后向前数，对于每个数，都要去找
        int[] maxLen = new int[nums.length];
        maxLen[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            int tempRes = countLen(nums, i, 1, maxLen);
            if (tempRes > res) {
                res = tempRes;
            }
        }
        return res;
    }

    private int countLen(int[] nums, int i, int len, int[] maxLen) {
        int thisLen = 1;
        for (int j = i - 1; j >= 0; j--) {
            if (nums[j] < nums[i]) {
                if (maxLen[j] + 1 > thisLen) {
                    thisLen = maxLen[j] + 1;
                }
            }
        }
        maxLen[i] = thisLen;
        return maxLen[i];
    }
}
