package menu._901_1000;

import menu.TreeNode;

public class _979_distributeCoins {
    public int distributeCoins(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    int res;

    private int dfs(TreeNode root) {
        if (root != null) {
            // 计算左子树中的移动
            int l = dfs(root.left);
            // 计算右子树中的移动
            int r = dfs(root.right);
            // 累计root的子树的移动数
            res += Math.abs(l) + Math.abs(r);
            // 返回需要与外界交换的硬币数
            return l + r + root.val - 1;
        } else {
            return 0;
        }
    }
}
