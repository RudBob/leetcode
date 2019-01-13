package recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
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

    /**
     * 没看懂
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(nums[0]);
        result.add(list1);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> res0 = new ArrayList<List<Integer>>();
            for (List<Integer> list : result) {
                for (int j = 0; j <= list.size(); j++) {
                    List<Integer> list2 = new ArrayList<Integer>();
                    list2.addAll(list);
                    list2.add(j, nums[i]);
                    res0.add(list2);
                }
            }
            result = res0;
        }
        return result;
    }
}
