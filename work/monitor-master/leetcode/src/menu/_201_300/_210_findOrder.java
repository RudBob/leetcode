package menu._201_300;

import java.util.LinkedList;

public class _210_findOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        // 先找到前置课程为 0 的课.
        // 找前置已经被满足的课程
        LinkedList<Integer>[] list = new LinkedList[numCourses];
        for (int[] p : prerequisites) {
            if (list[p[0]] == null) {
                list[p[0]] = new LinkedList<Integer>();
            }
            list[p[0]].add(p[1]);
        }
        boolean[] added = new boolean[numCourses];
        boolean hasAdd = true;
        int num = 0;
        while (hasAdd) {
            hasAdd = false;
            for (int i = 0; i < numCourses; i++) {
                if (!added[i]) {
                    if (list[i] != null) {
                        list[i].removeIf(id -> added[id]);
                        if (list[i].size() == 0) {
                            list[i] = null;
                        }
                    }
                    if (list[i] == null) {
                        added[i] = true;
                        hasAdd = true;
                        res[num++] = i;
                    }
                }
            }
        }
        if (num != numCourses) {
            return new int[0];
        }
        return res;
    }
}
