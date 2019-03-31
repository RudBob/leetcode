package tag.dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @ClassName numSquares
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/10 12:18
 * @Version 1.0
 */
public class numSquares {

    // 1 ： 1， 2 ： 2， 3 : 3,
    // 4 : 1, 5 :2, 6: 3, 7 : 4 ,8 : 2
    // 9 : 1, 10: 2, 11 : 3, 12 : 3,13 : 2, 14 : 3, 15:4
    // 16 : 1, 17: 2, 18 : 2, 19 : 3, 20 : 2

    public int numSquares(int n) {
        int size = (int) Math.sqrt(n);
        Map<Integer, Integer> numSquare = new HashMap<>(256);
        int[] pingFang = new int[size + 1];
        // 减少重复计算
        for (int i = 1; i <= size; i++) {
            pingFang[i] = i * i;
        }
        return numSquares(n, pingFang, numSquare);
    }

    private int numSquares(int n, int[] pingFang, Map<Integer, Integer> numSquare) {
        if (numSquare.get(n) != null) {
            return numSquare.get(n);
        }
        // 计算最大的平方数
        int size = (int) Math.sqrt(n);
        int min = Integer.MAX_VALUE;
        for (int i = size; i > 0; i--) {
            int maxSquare = pingFang[i];
            int yuShu = n % maxSquare;
            int beiShu = n / maxSquare;
            if (yuShu == 0) {
                min = min < beiShu ? min : beiShu;
                numSquare.put(n, min);
                return min;
            } else {
                int res = beiShu + numSquares(yuShu, pingFang, numSquare);
                min = min < res ? min : res;
            }
        }
        numSquare.put(n, min);
        return min;
    }

    /**
     * 广搜,真谛牛批
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int step = 1;
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int cur = queue.remove();
                for (int j = 1; ; j++) {
                    int next = cur + j * j;
                    if (next > n) {
                        break;
                    } else if (next == n) {
                    return step;
                }
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        throw new IllegalArgumentException("No Solution");
    }
}
