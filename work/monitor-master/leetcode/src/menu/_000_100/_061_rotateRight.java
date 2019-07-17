package menu._000_100;

/**
 * @ClassName _061_rotateRight
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/16 9:39
 * @Version 1.0
 */
public class _061_rotateRight {

    // 组成圈，断开并改变head指向即可
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }
        int len = 0;
        ListNode cur = head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
            len++;
        }
        k %= len;
        // 此时，pre就是最后一个节点,组成环
        pre.next = head;
        // head向前移动 len - k 步，
        for (int i = 0; i < len - k - 1; i++) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode newHead = head.next;
        head.next = null;
        return newHead;
    }
}
