package menu._101_200;

public class _148_sortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        new _148_sortList().sortList(head);
        System.out.println();
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
//        if (head == null) {
//            return head;
//        }
//        // 得到链表尾
//        ListNode last = head;
//        while (last.next != null) {
//            last = last.next;
//        }
//        return quickSort(head, last);
    }

    ListNode mergeSort(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        //快慢指针找到中值，然后断开.
        ListNode midNode = getMidNode(node);
        ListNode l1 = mergeSort(node);
        ListNode l2 = mergeSort(midNode);
        return merge(l1, l2);
    }

    private ListNode getMidNode(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        ListNode midNode = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            midNode = slow;
            slow = slow.next;
        }
        // 断开
        midNode.next = null;
        return slow;
    }

    ListNode merge(ListNode l1, ListNode l2) {
        //递归到底的情况
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //分情况递归实现
        if (l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l2.next, l1);
            return l2;
        }
    }

    /**
     * 快排版本
     *
     * @param head
     * @param last
     * @return
     */
    public ListNode quickSort(ListNode head, ListNode last) {
        if (head == last || head == null || last == null) {
            return head;
        }
        ListNode splitNode = new ListNode(head.val);
        ListNode lastNext = last.next;
        ListNode cur = head.next;
        ListNode nextCur = cur == null ? null : cur.next;

        ListNode leftHead = splitNode, leftLast = null;
        ListNode rightHead = null, rightLast = splitNode;

        while (cur != null && cur != lastNext) {
            // 将该节点插入到splitNode的最前面
            if (cur.val <= splitNode.val) {
                if (leftLast == null) {
                    leftLast = cur;
                }
                cur.next = leftHead;
                leftHead = cur;
            } else {
                // 将该节点插入到最后面.
                if (rightHead == null) {
                    rightHead = cur;
                }
                rightLast.next = cur;
                rightLast = cur;
                cur.next = null;
            }
            cur = nextCur;
            if (cur == lastNext) {
                break;
            }
            if (cur != null) {
                nextCur = cur.next;
            }
        }
        // 与之前的节点进行连接.
        // 头节点需要移花接木
        head.val = leftHead.val;
        if (leftLast != null) {
            head.next = leftHead.next;
        }
        // 尾节点直接拼接
        rightLast.next = lastNext;

        // 排序两侧的链表
        quickSort(rightHead, rightLast);
        quickSort(head, leftLast);
        return head;
    }
}

