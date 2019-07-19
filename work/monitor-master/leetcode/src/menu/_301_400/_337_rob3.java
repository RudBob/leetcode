package menu._301_400;


import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName _337_rob3
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 14:11
 * @Version 1.0
 */
public class _337_rob3 {


    public int rob(TreeNode root) {
        return Math.max(contain(root), notContain(root));
    }

    private int contain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + notContain(root.left) + notContain(root.right);
    }

    private int notContain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(contain(root.left), notContain(root.left)) +
                Math.max(contain(root.right), notContain(root.right));
    }

    public int rob2(TreeNode root) {
        Map<TreeNode, Integer> containMap = new HashMap<>();
        Map<TreeNode, Integer> notContainMap = new HashMap<>();

        return Math.max(contain(root, containMap, notContainMap), notContain(root, containMap, notContainMap));
    }

    private int contain(TreeNode root, Map<TreeNode, Integer> containMap, Map<TreeNode, Integer> notContainMap) {
        if (root == null) {
            return 0;
        }
        if (containMap.get(root) == null) {
            containMap.put(root, root.val + notContain(root.left, containMap, notContainMap) + notContain(root.right, containMap, notContainMap));
        }
        return containMap.get(root);
    }

    private int notContain(TreeNode root, Map<TreeNode, Integer> containMap, Map<TreeNode, Integer> notContainMap) {
        if (root == null) {
            return 0;
        }
        if (notContainMap.get(root) == null) {
            notContainMap.put(root, Math.max(contain(root.left, containMap, notContainMap), notContain(root.left, containMap, notContainMap)) +
                    Math.max(contain(root.right, containMap, notContainMap), notContain(root.right, containMap, notContainMap)));
        }
        return notContainMap.get(root);
    }
}
