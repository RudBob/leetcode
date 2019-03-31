package menu._101_200;

import menu.TreeNode;

public class _114_flatten {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        TreeNode cur = root.left;
        if(cur != null) {
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = right;
            root.right = root.left;
            root.left = null;
        }
    }
}
