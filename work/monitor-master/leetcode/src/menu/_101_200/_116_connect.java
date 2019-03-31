package menu._101_200;

import java.util.LinkedList;
import java.util.Queue;

public class _116_connect {
    // 层序遍历
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            int size = queue.size() - 1;
            Node pre = queue.remove();
            queueAddNode(queue, pre);
            while (size-- != 0) {
                Node cur = queue.remove();
                pre.next = cur;
                pre = cur;
                queueAddNode(queue, cur);
            }
        }
        return root;
    }

    private void queueAddNode(Queue<Node> queue, Node pre) {
        if(pre.left != null) {
            queue.add(pre.left);
        }
        if(pre.right != null) {
            queue.add(pre.right);
        }
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
