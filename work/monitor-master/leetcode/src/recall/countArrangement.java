package recall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 暴力，击败了1%。
 */
public class countArrangement {
    int res = 0;
    HashMap<Integer, List<Integer>> info = new HashMap();

    public int countArrangement(int N) {
        res = 0;
        info = new HashMap<>();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = i + 1;
            info.put(i + 1, new ArrayList<>());
        }
        dfs(a, N, 0);
        return res;
    }

    private void dfs(int[] a, int n, int i) {
        if (i == n - 1 && judge(a)) {
            res++;
        }
        for (int j = i; j < n; j++) {
            swap(a, i, j);
            if (!containError(a, i)) {
                dfs(a, n, i + 1);
            }
            swap(a, i, j);
        }
    }

    private boolean containError(int[] a, int i) {
        ArrayList<Integer> list = (ArrayList<Integer>) info.get(i + 1);
        return list.contains(a[i]);
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public boolean judge(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] % (i + 1) != 0 && (i + 1) % a[i] != 0) {
                ArrayList<Integer> list = (ArrayList<Integer>) info.get(i + 1);
                list.add(a[i]);
                return false;

            }
        }
        return true;
    }
}
