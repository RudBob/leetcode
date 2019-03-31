package tag.dp.rob;

/**
 * @ClassName rob
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/5 10:01
 * @Version 1.0
 */
public class rob {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //对于前 index - 1家，找到一个最大值.
        int[] maxRob = new int[nums.length];
        int[] maxValue = new int[nums.length];
        maxRob[0] = nums[0];
        maxRob[1] = nums[1];
        maxValue[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            maxRob[i] = nums[i] + maxValue[i - 1];
            maxValue[i] = Math.max(maxValue[i - 1], maxRob[i - 1]);
        }
        return Math.max(maxValue[nums.length - 1], maxRob[nums.length - 1]);
    }
}
