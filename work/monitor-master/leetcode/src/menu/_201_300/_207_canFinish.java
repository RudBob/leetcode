package menu._201_300;

import java.util.Iterator;
import java.util.LinkedList;

public class _207_canFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        // 先找到前置课程为 0 的课.
        // 找前置已经被满足的课程
        LinkedList<Integer>[] list = new LinkedList[numCourses];
        for (int[] p : prerequisites) {
            if (list[p[1]] == null) {
                list[p[1]] = new LinkedList<Integer>();
            }
            list[p[1]].add(p[0]);
        }
        boolean[] added = new boolean[numCourses];
        boolean hasAdd = true;
        int num = numCourses;
        while (hasAdd) {
            hasAdd = false;
            for (int i = 0; i < numCourses; i++) {
                if (!added[i]) {
                    if (list[i] != null) {
                        Iterator<Integer> a = list[i].iterator();
                        while (a.hasNext()) {
                            Integer id = a.next();
                            if (added[id]) {
                                a.remove();
                            }
                        }
                        if (list[i].size() == 0) {
                            list[i] = null;
                        }
                    }
                    if (list[i] == null) {
                        added[i] = true;
                        hasAdd = true;
                        num--;
                    }
                }
            }
        }
        return num == 0;
    }
}
