package menu._101_200;

import menu.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _129_sumNumbers {

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            int size = queue.size();
            while (size-- != 0) {
                TreeNode curNode = queue.remove();
                if (curNode.right == null && curNode.left == null) {
                    sum += curNode.val;
                }
                if (curNode.right != null) {
                    curNode.right.val += curNode.val * 10;
                    queue.add(curNode.right);
                }
                if (curNode.left != null) {
                    curNode.left.val += curNode.val * 10;
                    queue.add(curNode.left);
                }
            }
        }
        return sum;
    }
}
