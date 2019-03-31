package menu._101_200;

import menu.TreeNode;

public class _105_buildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        int[] index = new int[preorder.length];
        for (int i = 0; i < inorder.length; i++) {
            for (int j = 0; j < preorder.length; j++) {
                if (inorder[i] == preorder[j]) {
                    index[i] = j;
                }
            }
        }
        TreeNode root = buildTree(inorder, 0, inorder.length - 1, index);
        return root;
    }

    private TreeNode buildTree(int[] inorder, int head, int last, int[] index) {
        if(head > last){
            return null;
        }
        if (head == last) {
            return new TreeNode(inorder[head]);
        }
        int minIndex = head;
        int minValue = index[head];
        for (int i = head + 1; i <= last; i++) {
            if (index[i] < minValue) {
                minValue = index[i];
                minIndex = i;
            }
        }
        TreeNode root = new TreeNode(inorder[minIndex]);
        root.left = buildTree(inorder, head, minIndex - 1, index);
        root.right = buildTree(inorder, minIndex + 1, last, index);
        return root;
    }
}
