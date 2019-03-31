package tree;

public class isBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return getLen(root) != -1;
    }


    private int getLen(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getLen(root.left);
        int rightDepth = getLen(root.right);

        if (leftDepth == -1 || rightDepth == -1) {
            return -1;
        }

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return leftDepth > rightDepth ? 1 + leftDepth : 1 + rightDepth;
    }
}
