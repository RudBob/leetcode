package tag.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName combinationSum4
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/11 18:26
 * @Version 1.0
 */
public class combinationSum4 {
    /**
     * 简单递归
     */
    public int combinationSum4_1(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += combinationSum4_1(nums, target - num);
            }
        }
        return res;
    }

    /**
     * 记忆化搜索
     */
    private int[] memo;

    public int combinationSum4_2(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return search(nums, target);
    }

    private int search(int[] nums, int target) {
        if (memo[target] != -1) {
            return memo[target];
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += search(nums, target - num);
            }
        }
        memo[target] = res;
        return res;
    }

    public int combinationSum4_my(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        return combinationSum(nums, target, map);
    }

    private int combinationSum(int[] nums, int target, Map<Integer, Integer> map) {
        if (target < 0) {
            return 0;
        } else if (target == 0) {
            return 1;
        }
        int res = 0;
        if (map.get(target) == null) {
            for (int i = 0; i < nums.length; i++) {
                res += combinationSum(nums, target - nums[i], map);
            }
            map.put(target, res);
        }
        return map.get(target);
    }

    /**
     * 动态规划
     */
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        memo[0] = 1;
        for (int i = 0; i < target; i++) {
            for (int num : nums) {
                if (i + num <= target) {
                    memo[i + num] += memo[i];
                }
            }
        }
        return memo[target];
    }
}
