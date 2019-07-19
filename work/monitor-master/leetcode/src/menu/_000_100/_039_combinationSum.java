package menu._000_100;

import java.util.ArrayList;
import java.util.List;

public class _039_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int pos = 0;
        int sum = 0;
        dfs(candidates, target, res, path, pos, sum);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> path, int pos, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
        }
        if (sum >= target) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target, res, path, i, sum + candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
