package recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 */
public class combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int pos = 1;
        combine(n, k, res, path, pos);
        return res;
    }

    private void combine(int n, int k, List<List<Integer>> res, List<Integer> path, int pos) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = pos; i <= n; i++) {
            path.add(i);
            combine(n, k, res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
