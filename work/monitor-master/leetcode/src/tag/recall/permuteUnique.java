package tag.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        dfs(nums, res, 0);
        return res;
    }

    /**
     * 回溯
     *
     * @param nums 原数组
     * @param res  结果集
     * @param i    变化量
     */
    private void dfs(int[] nums, List<List<Integer>> res, int i) {
        if (i == nums.length - 1) {
            List<Integer> res0 = new ArrayList<>();
            for (int num : nums) {
                res0.add(num);
            }
            // 强行去重
            for (List<Integer> r0 : res) {
                if (r0.equals(res0)) {
                    return;
                }
            }
            res.add(res0);
        }
        for (int j = i; j < nums.length; j++) {

            swap(nums, i, j);
            dfs(nums, res, i + 1);
            swap(nums, i, j);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
