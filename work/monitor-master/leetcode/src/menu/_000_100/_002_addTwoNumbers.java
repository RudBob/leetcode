package menu._000_100;

/**
 * @ClassName _002_addTwoNumbers
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/17 15:07
 * @Version 1.0
 */
public class _002_addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 直接相加每一位的值.
        ListNode cur = new ListNode(-1);
        ListNode resHead = cur;
        int next = 0, v;
        while (l1 != null || l2 != null) {
            v = next;
            if (l2 != null) {
                v += l2.val;
                l2 = l2.next;
            }
            if (l1 != null) {
                v += l1.val;
                l1 = l1.next;
            }
            cur.next = new ListNode(v % 10);
            cur = cur.next;
            next = v / 10;
        }
        if (next != 0) {
            cur.next = new ListNode(next);
        }
        return resHead.next;
    }
}
