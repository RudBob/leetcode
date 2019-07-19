package menu._000_100;

/**
 * @ClassName _001_twoSum
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/17 14:56
 * @Version 1.0
 */
public class _001_twoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            res[0] = i;
            int temp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (temp == nums[j]) {
                    res[1] = j;
                    return res;
                }
            }
        }

        return res;
    }
}
