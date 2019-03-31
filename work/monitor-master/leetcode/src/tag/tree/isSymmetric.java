package tag.tree;

import java.util.Deque;
import java.util.LinkedList;

public class isSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.right == null && root.left == null)) {
            return true;
        } else if (!(root.right != null && root.left != null)) {
            return false;
        }
        // 双端队列层级遍历
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root.left);
        deque.add(root.right);
        while (deque.size() != 0) {
            // 判断前后是否相同.
            Deque<TreeNode> deque01 = new LinkedList<>();
            Deque<TreeNode> deque02 = new LinkedList<>();

            while (deque.size() != 0) {
                TreeNode nodeFirst = deque.remove();
                TreeNode nodeLast = deque.removeLast();
                if (nodeFirst == null && nodeLast == null) {
                    continue;
                } else if (nodeFirst == null || nodeLast == null || nodeFirst.val != nodeLast.val) {
                    return false;
                }
                deque01.add(nodeFirst);
                deque02.addFirst(nodeLast);
            }
            // 将两条队列的下一行进行合并
            deque = new LinkedList<>();
            while (deque01.size() != 0) {
                TreeNode node = deque01.remove();
                deque.add(node.left);
                deque.add(node.right);
            }
            while (deque02.size() != 0) {
                TreeNode node = deque02.remove();
                deque.add(node.left);
                deque.add(node.right);
            }


        }
        return true;
    }
}
