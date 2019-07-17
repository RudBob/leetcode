package menu._000_100;

/**
 * @ClassName _019_removeNthFromEnd
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/15 14:02
 * @Version 1.0
 */
public class _019_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 删除倒数第n 个节点,只需要提前偏移n位即可
        // 使用双指针
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode left = preHead;
        ListNode right = preHead;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return preHead.next;
    }
}
