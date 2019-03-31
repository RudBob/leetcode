package menu._101_200;

import menu.TreeNode;

public class _106_buildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] map = new int[inorder.length];
        for (int i = 0; i < inorder.length; i++) {
            for (int j = 0; j < postorder.length; j++) {
                if (inorder[i] == postorder[j]) {
                    map[i] = j;
                    break;
                }
            }
        }
        TreeNode root = buildTree(inorder, map, 0, postorder.length - 1);
        return root;
    }

    private TreeNode buildTree(int[] inorder, int[] map, int head, int last) {
        if (head > last) {
            return null;
        }
        int maxValueIndex = head;
        int maxValue = map[head];
        for (int j = head + 1; j <= last; j++) {
            if (map[j] > maxValue) {
                maxValueIndex = j;
                maxValue = map[j];
            }
        }
        TreeNode root = new TreeNode(inorder[maxValueIndex]);
        root.left = buildTree(inorder, map, head, maxValueIndex - 1);
        root.right = buildTree(inorder, map, maxValueIndex + 1, last);
        return root;
    }
}
