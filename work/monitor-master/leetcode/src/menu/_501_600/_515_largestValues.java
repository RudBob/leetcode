package menu._501_600;

import menu.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _515_largestValues {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            while (size-- != 0) {
                TreeNode curNode = queue.remove();
                if(curNode.val > max){
                    max = curNode.val;
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
            }
            res.add(max);
        }
        return res;
    }
}
