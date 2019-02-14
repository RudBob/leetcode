package recall.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int pos = 0;
        int sum = 0;
        Arrays.sort(candidates);
        dfs(candidates, target, res, path, pos, sum);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int pos, int sum) {
        //去除重复的list
        if (sum == target) {
            for (List<Integer> res0 : res) {
                if (res0.equals(path)) {
                    return;
                }
            }
            res.add(new ArrayList<>(path));
        }
        // 剪枝及递归的底部
        if (sum >= target) {
            return;
        }
        // 回溯
        for (int i = pos; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target, res, path, i + 1, sum + candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
