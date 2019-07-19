package menu._801_900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _870_advantageCount {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        List<Integer> a = new ArrayList<>();
        for (int a0 : A) {
            a.add(a0);
        }
        int[] res = new int[A.length];
        for (int i = 0, len = B.length; i < len; i++) {
            res[i] = find(a, B[i], 0, a.size() - 1);
        }
        return res;
    }

    private int find(List<Integer> a, int target, int head, int last) {
        if (a.get(last) <= target || a.get(head) > target) {
            int res = a.get(head);
            a.remove(head);
            return res;
        }
        while (a.get(head) <= target && a.get(last) > target) {
            if (last - head == 1) {
                int res = a.get(last);
                a.remove(last);
                return res;
            }
            int mid = (head + last) / 2;
            if (a.get(mid) <= target) {
                head = mid;
            } else {
                last = mid;
            }
        }
        return 0;
    }
}
