package menu._901_1000;

import java.util.LinkedList;
import java.util.Queue;

public class _934_shortestBridge {
    public int shortestBridge(int[][] A) {
        // 找到第二座岛的标识
        boolean twoInsand = false;
        int steps = 0;
        // 找到第一座岛，编号为2
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1 && !twoInsand) {
                    // 第一座岛
                    namedIsland(A, i, j);
                    twoInsand = true;
                } else if(A[i][j] == 1){
                    // 第二座岛的坐标，我们已经找到了
                    steps = planBuild(A, i, j);
                }
            }
        }
        return steps;
    }

    // 先把岛上所有的点全都加到队列中，
    // 然后让队列中的每个之都 step by step的走，知道第一个边界找到另一个岛，此时return.
    private int planBuild(int[][] a, int i, int j) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));
        getQueue(queue, a, i, j);
        int steps = 0;
        while (queue.size() != 0) {

            int size = queue.size();
            while (size-- != 0) {
                Node temp = queue.remove();
                int x = temp.x;
                int y = temp.y;
                for (int k = 0; k < 4; k++) {
                    int newX = x + next[k][0];
                    int newY = y + next[k][1];
                    if (isValid(newX, newY, a)) {
                        if (a[newX][newY] == 0) {
                            a[newX][newY] = 3;
                            queue.add(new Node(newX, newY));
                        } else if (a[newX][newY] == 2) {
                            return steps;
                        }
                    }
                }
            }
            steps++;
        }
        return steps;
    }

    private void getQueue(Queue<Node> queue, int[][] a, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int newX = x + next[i][0];
            int newY = y + next[i][1];
            if (isValid(newX, newY, a) && a[newX][newY] == 1) {
                queue.add(new Node(newX, newY));
                a[newX][newY] = 3;
                getQueue(queue, a, newX, newY);
            }
        }
    }

    int[][] next = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    private void namedIsland(int[][] a, int x, int y) {
        if (a[x][y] == 1) {
            a[x][y] = 2;
        }
        // 深搜
        for (int i = 0; i < 4; i++) {
            int newX = x + next[i][0];
            int newY = y + next[i][1];
            if (isValid(newX, newY, a) && a[newX][newY] == 1) {
                namedIsland(a, newX, newY);
            }
        }
    }

    private boolean isValid(int newX, int newY, int[][] a) {
        return newX >= 0 && newY >= 0 && newX < a.length && newY < a[newX].length;
    }
}

class Node {
    int x;
    int y;

    public Node(int i, int j) {
        x = i;
        y = j;
    }
}
