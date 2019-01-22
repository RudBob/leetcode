package string.easy.day01;

/**
 *  找到空括号出现的原因: 占位，以便更好地表达树的右枝
 */
public class tree2str {
    public String tree2str(TreeNode t) {
        StringBuilder s = new StringBuilder();
        // 前序遍历
        printTree(t, s);
        return s.toString();
    }

    private void printTree(TreeNode t, StringBuilder s) {
        if (t == null) {
            return;
        }
        s.append(t.val);
        if (t.left == null && t.right == null) {
            return;
        } else if (t.left == null) {
            s.append("()");
        } else {
            s.append("(");
            printTree(t.left, s);
            s.append(")");
        }
        if (t.right == null) {
            return;
        }
        s.append("(");
        printTree(t.right, s);
        s.append(")");
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