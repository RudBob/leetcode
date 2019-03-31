package menu._501_600;

import menu.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _513_findBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        // 层级遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode firstNode = root;
        while (queue.size() != 0) {
            firstNode = queue.peek();
            int size = queue.size();
            while ( size-- != 0) {
                TreeNode tempNode = queue.remove();
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
        return firstNode.val;
    }
}
