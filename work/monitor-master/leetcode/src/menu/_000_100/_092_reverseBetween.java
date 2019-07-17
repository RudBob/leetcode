package menu._000_100;

import java.util.Stack;

/**
 * @ClassName _092_reverseBetween
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/16 11:26
 * @Version 1.0
 */
public class _092_reverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = new ListNode(-1);
        cur.next = head;
        for (int i = 1; i < m; i++) {
            cur = cur.next;
        }
        ListNode pre = cur;
        cur = cur.next;
        ListNode newHead = pre;
        for (int i = m; i <= n; i++) {
            stack.push(cur);
            cur = cur.next;
        }
        ListNode end = cur;
        for (int i = m; i <= n; i++) {
            pre.next = stack.pop();
            pre = pre.next;
        }
        pre.next = end;
        return m == 1 ? newHead.next : head;
    }
}
