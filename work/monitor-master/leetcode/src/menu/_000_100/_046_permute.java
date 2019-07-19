package menu._000_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _046_permute
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/17 14:52
 * @Version 1.0
 */
public class _046_permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        permute(nums, res, path, 0);
        return res;
    }

    private void permute(int[] nums, List<List<Integer>> res, List<Integer> path, int idx) {
        if (idx == nums.length) {
            List<Integer> temp = new ArrayList<>(path);
            res.add(temp);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            swap(nums, i, idx);
            permute(nums, res, path, idx + 1);
            swap(nums, i, idx);
            path.remove(path.size() - 1);
        }
    }

    private void swap(int[] nums, int i, int idx) {
        int t = nums[i];
        nums[i] = nums[idx];
        nums[idx] = t;
    }
}
