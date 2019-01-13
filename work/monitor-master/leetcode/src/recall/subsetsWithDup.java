package recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int pos = 0;
        Arrays.sort(nums);
        dfs(nums, res, path, pos);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int pos) {
        //去重
        res.add(new ArrayList<>(path));
        // 回溯
        for (int i = pos; i < nums.length; i++) {
            // 去重，因为排序了，只要第一个数字出，后面的跳过。
            if (i > pos && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
