package menu._000_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName _040_combinationSum2
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 15:14
 * @Version 1.0
 */
public class _040_combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, 0, target, new ArrayList<Integer>(), res);
        return res;
    }

    private void backTrack(int[] arr, int idx, int tar, List<Integer> cur, List<List<Integer>> res) {
        if (tar == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        int pre = -1;
        for (int i = idx; i < arr.length && arr[i] <= tar; i++) {
            if (arr[i] != pre) {
                cur.add(arr[i]);
                backTrack(arr, i + 1, tar - arr[i], cur,res);
                pre = cur.remove(cur.size() - 1);
            }
        }
    }
}
