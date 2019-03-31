package tree;

import java.util.*;

public class pathSum {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> pathList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        getPath(root, sum, pathList, path);
        return pathList;
    }

    private void getPath(TreeNode root, int target, List<List<Integer>> pathList, List<Integer> path) {
        if (root == null) {
            return;
        }
        if (root.right == null && null == root.left) {
            if (target == root.val) {
                List<Integer> copyPath = new ArrayList<>();
                for (int i = 0, len = path.size(); i < len; i++) {
                    copyPath.add(path.get(i));
                }
                copyPath.add(root.val);
                pathList.add(copyPath);
            }
        } else {
            path.add(root.val);
            getPath(root.left, target - root.val, pathList, path);
            path.remove(path.size() - 1);

            path.add(root.val);
            getPath(root.right, target - root.val, pathList, path);
            path.remove(path.size() - 1);
        }
    }
}
