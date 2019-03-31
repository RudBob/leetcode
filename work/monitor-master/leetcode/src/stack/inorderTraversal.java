package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        // 先递归
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || stack.size() != 0) {
            if (root == null) {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        return res;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
