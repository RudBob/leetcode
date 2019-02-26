package greedy;

import java.util.*;

public class reconstructQueue {
    /**
     *  0.7% 暴力,TODO
     */
    public int[][] reconstructQueue(int[][] people) {
        // 前面人的个数分堆
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] man : people) {
            if (map.get(man[1]) == null) {
                List<Integer> queue = new ArrayList<>();
                queue.add(man[0]);
                map.put(man[1], queue);
            } else {
                map.get(man[1]).add(man[0]);
            }
        }
        LinkedList res = new LinkedList();
        for (int i = 0; i < 1100; i++) {
            if (map.get(i) == null) {
                continue;
            }
            Object[] queue = map.get(i).toArray();
            Arrays.sort(queue);
            for (int k = 0; k < queue.length; k++) {
                int j = 0, count = 0;
                for (; j < res.size(); j++) {
                    int[] val = (int[]) res.get(j);
                    if (val[0] >= (int) queue[k]) {
                        count++;
                        if (count > i) {
                            int[] tempRes = {(int) queue[k], i};
                            // 插入到这位数前面
                            res.add(j, tempRes);
                            break;
                        }
                    }
                }
                if (j == res.size()) {
                    int[] tempRes = {(int) queue[k], i};
                    res.add(tempRes);
                }
            }
        }
        for (int j = 0; j < res.size(); j++) {
            people[j] = (int[]) res.get(j);
        }
        return people;
    }
}
