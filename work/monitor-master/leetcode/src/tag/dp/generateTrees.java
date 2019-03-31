package tag.dp;

import java.util.*;

/**
 * @ClassName generateTrees
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/8 11:40
 * @Version 1.0
 */
public class generateTrees {

    /**
     * 递推
     */
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> one = new ArrayList<>();
        one.add(new TreeNode(1));
        List<TreeNode> zero = new ArrayList<>();
        zero.add(null);
        sizeToTree.put(0, zero);
        sizeToTree.put(1, one);
        for (int i = 2; i < n; i++) {
            generateTrees2(i);
        }
        return generateTrees2(n);
    }

    public List<TreeNode> generateTrees2(int n) {
        // 根节点是 1....n；
        List<TreeNode> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            TreeNode root = new TreeNode(i);
            // 最小值，最大值
            List<TreeNode> path = getTreeFromRoot(root, i, n);
            res.addAll(path);
        }
        return res;
    }

    Map<Integer, List<TreeNode>> sizeToTree = new HashMap<>();

    private List<TreeNode> getTreeFromRoot(TreeNode root, int rootValue, int maxValue) {
        List<TreeNode> res = new ArrayList<>();
        List<TreeNode> lefts = getTreeFromSize(1, rootValue - 1);
        List<TreeNode> rights = getTreeFromSize(rootValue + 1, maxValue);
        for (TreeNode left : lefts) {
            for (TreeNode right : rights) {
                root.left = left;
                root.right = right;
                res.add(copyNode(root, 0));
            }
        }
        List<TreeNode> v = sizeToTree.get(maxValue);
        if (v == null) {
            sizeToTree.put(maxValue, res);
        } else {
            v.addAll(res);
        }
        return res;
    }

    private List<TreeNode> getTreeFromSize(int minValue, int maxValue) {
        int size = maxValue - minValue + 1;
        List<TreeNode> value = sizeToTree.get(size);
        List<TreeNode> res = new ArrayList<>(value.size());
        for (TreeNode tempNode : value) {
            TreeNode tempRes = copyNode(tempNode, minValue - 1);
            res.add(tempRes);
        }
        return res;
    }

    private TreeNode copyNode(TreeNode tempNode, int min) {
        if (tempNode == null) {
            return null;
        }
        TreeNode res = new TreeNode(tempNode.val + min);
        res.left = copyNode(tempNode.left, min);
        res.right = copyNode(tempNode.right, min);
        return res;
    }

    /**
     * 递归
     */
    public List<TreeNode> generateTrees3(int n) {
        if (n == 0)
            return new LinkedList<TreeNode>();
        return generateTrees3(1, n);
    }

    public List<TreeNode> generateTrees3(int start, int end) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> subLeftTree = generateTrees3(start, i - 1);
            List<TreeNode> subRightTree = generateTrees3(i + 1, end);
            for (TreeNode left : subLeftTree) {
                for (TreeNode right : subRightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
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