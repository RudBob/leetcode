package tag.recall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 第k个排列
 */
public class getPermutation {
    /**
     * 找到n ，k 之间的关系，进行计算。
     */
    int[] map = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        StringBuilder path = new StringBuilder();
        dfs(path, n, k, list);
        return path.toString();
    }

    private void dfs(StringBuilder path, int n, int k, List<Integer> list) {
        if (list.size() == 0) {
            return;
        }
        int counter = 0;
        while (k > map[n - 1]) {
            k -= map[n - 1];
            counter++;
        }
        path.append(list.get(counter));
        list.remove(counter);
        dfs(path, n - 1, k, list);
    }

    /**
     * 2.全排列后排序，之后得到值。
     */
    public String getPermutation02(int n, int k) {
        counter = 0;
        // 初始化目标数组
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<String> res = new ArrayList<>();
        int pos = 0;
        dfs(nums, n, k, pos, res);
        Collections.sort(res);
        return res.get(k - 1);
    }

    private int counter;

    private void dfs(int[] nums, int n, int k, int pos, List res) {
        if (n == pos) {
            String str = numsToStrBuilder(nums);
            res.add(str);
            counter++;
        }
        if (counter <= k + 1) {
            for (int i = pos; i < n; i++) {
                swap(nums, pos, i);
                dfs(nums, n, k, pos + 1, res);
                swap(nums, pos, i);
            }
        }
    }

    private void swap(int[] nums, int pos, int i) {
        int t = nums[pos];
        nums[pos] = nums[i];
        nums[i] = t;
    }

    private String numsToStrBuilder(int[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            stringBuilder.append(nums[i]);
        }
        return stringBuilder.toString();
    }
}
