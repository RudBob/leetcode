package menu._000_100;

/**
 * @ClassName _024_swapPairs
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/16 14:18
 * @Version 1.0
 */
public class _024_swapPairs {
    // 前节点: 指向原后节点的next
    // 后节点：只想前节点.
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = newHead;
        while (cur != null && cur.next != null && cur.next.next != null) {
            cur = swap(cur);
        }
        return newHead.next;
    }

    private ListNode swap(ListNode cur) {
        // 交换两个节点，cur.next和cur.next.next，并把
        ListNode pre = cur.next;
        ListNode rear = cur.next.next;
        pre.next = rear.next;
        rear.next = pre;
        cur.next = rear;
        return pre;
    }
}
