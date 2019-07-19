package menu._201_300;

/**
 * @ClassName _213_rob2
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 14:11
 * @Version 1.0
 */
public class _213_rob2 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }
        return Math.max(rob(nums, 0), rob(nums, 1));
    }

    public int rob(int[] nums, int head) {
        int last = head == 0 ? 1 : 0;
        //对于前 index - 1 家，找到一个最大值.
        int[] maxRob = new int[nums.length];
        int[] maxValue = new int[nums.length];
        maxRob[head] = nums[head];
        maxRob[head + 1] = nums[head + 1];
        maxValue[head + 1] = nums[head];
        for (int i = head + 2; i < nums.length - last; i++) {
            maxRob[i] = nums[i] + maxValue[i - 1];
            maxValue[i] = Math.max(maxValue[i - 1], maxRob[i - 1]);
        }
        return Math.max(maxValue[nums.length - last - 1], maxRob[nums.length - last - 1]);
    }
}
