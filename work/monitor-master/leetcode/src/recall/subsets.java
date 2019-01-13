package recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 */
public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> res0 = new ArrayList<>();
        int len = nums.length;
        subsets(res, res0, nums, 0, len);
        return res;
    }

    private void subsets(List<List<Integer>> res, List<Integer> res0, int[] nums, int i, int len) {
        // 深拷贝
        res.add(new ArrayList<>(res0));
        for (int j = i; j < len; j++) {
            res0.add(nums[j]);
            subsets(res, res0, nums, j + 1, len);
            res0.remove(res0.size() - 1);
        }
    }

}
