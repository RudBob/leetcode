package menu._000_100;

/**
 * @ClassName _021_mergeTwoLists
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 13:59
 * @Version 1.0
 */
public class _021_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead;
        if (l1 == null) {
            newHead = l2;
        } else if (l2 == null) {
            newHead = l1;
        } else {
            if (l1.val < l2.val) {
                newHead = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                newHead = new ListNode(l2.val);
                l2 = l2.next;
            }
            newHead.next = mergeTwoLists(l1, l2);
        }
        return newHead;
    }
}
