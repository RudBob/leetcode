package others.day01;

public class addTwoNumbers {
    /**
     * 使用四则运算的基本知识，从后向前累加，直到三个listNode都为null为止。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode res = node;
        // 首先，声明一个进位数值的存储listNode
        ListNode tempRes = new ListNode(0);
        // 跳出条件使用break。
        while (true) {
            // 使用 int 值 存储当前的val。
            int l1_int, l2_int;
            // 如果node为null,那么val = 0;
            if (l1 == null) {
                l1_int = 0;
            } else {
                // 不为null,则节点后移。
                l1_int = l1.val;
                l1 = l1.next;
            }
            // 同上l1。
            if (l2 == null) {
                l2_int = 0;
            } else {
                l2_int = l2.val;
                l2 = l2.next;
            }
            // 给结果node赋值。
            int nodeValAddRes = l1_int + l2_int + tempRes.val;
            int resVal = nodeValAddRes % 10;
            node.val = resVal;
            // 判断是否要跳出.
            if (nodeValAddRes < 10 && l1 == null && l2 == null) {
                break;
            }
            // 结果listNode后移，进位listNode也继续后移
            node.next = new ListNode(0);
            node = node.next;
            tempRes.next = new ListNode(nodeValAddRes / 10);
            tempRes = tempRes.next;
        }

        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}