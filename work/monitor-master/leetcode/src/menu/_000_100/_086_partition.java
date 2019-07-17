package menu._000_100;

/**
 * @ClassName _086_partition
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/16 10:56
 * @Version 1.0
 */
public class _086_partition {
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode lessHead = new ListNode(-1);
        ListNode lessCur = lessHead;
        ListNode moreHead = new ListNode(-1);
        ListNode moreCur = moreHead;
        while (cur != null) {
            if (cur.val >= x) {
                moreCur.next = new ListNode(cur.val);
                moreCur = moreCur.next;
            } else {
                lessCur.next = new ListNode(cur.val);
                lessCur = lessCur.next;
            }
            cur = cur.next;
        }
        lessCur.next = moreHead.next;
        return lessHead.next;

    }
}
