package recall.combinationSum;

import java.util.ArrayList;
import java.util.List;

public class combinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int pos = 1;
        dfs(k, n, res, path, pos);
        return res;
    }

    private void dfs(int k, int n, List<List<Integer>> res, List<Integer> path, int pos) {
        if (k == path.size()) {
            int sum = 0;
            for (Integer p0 : path) {
                sum += p0;
            }
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
        }
        for (int i = pos; i < 10; i++) {
            path.add(i);
            dfs(k, n, res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
