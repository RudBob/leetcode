package menu._1000_1100;

public class _1018_nextLargerNodes {

    public int[] nextLargerNodes(ListNode head) {
        // 首先，将链表转数组，然后动态规划.
        int len = 0;
        ListNode count = head;
        while (count != null) {
            len++;
            count = count.next;
        }

        int[] val = new int[len];
        count = head;
        int i = 0;
        while (count != null) {
            val[i++] = count.val;
            count = count.next;
        }
        // 动态规划
        return getNextLargerNodes(val);
    }

    private int[] getNextLargerNodes(int[] val) {
        int[] ans = new int[val.length];
        int[] idx = new int[val.length];
        idx[val.length - 1] = -1;
        ans[val.length - 1] = 0;
        // 从后向前看，
        for (int i = val.length - 2; i >= 0; i--) {
            getNext(idx, ans, i, val, i + 1);
        }
        return ans;
    }

    private void getNext(int[] idx, int[] ans, int i, int[] val, int j) {

        if (val[j] > val[i]) {
            idx[i] = j;
            ans[i] = val[j];
        } else {
            if (idx[j] == -1) {
                idx[i] = -1;
                ans[i] = 0;
                return;
            }
            getNext(idx, ans, i, val, idx[j]);
        }
    }

}
