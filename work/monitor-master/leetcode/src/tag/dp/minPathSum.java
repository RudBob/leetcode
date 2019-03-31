package tag.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName minPathSum
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/5 21:33
 * @Version 1.0
 */
public class minPathSum {

    /**
     * 动态规划
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i == m - 1 && j == n - 1) {
                } else if (i == m - 1) {
                    grid[i][j] += grid[i][j + 1];
                } else if (j == n - 1) {
                    grid[i][j] += grid[i + 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i][j + 1], grid[i + 1][j]);
                }
            }
        }
        return grid[0][0];
    }

    /**
     * 广搜
     */
    public int minPathSum02(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        // 申请一个队列保存各种状态
        Queue<Node> queue = new LinkedList<>();
        Node end = new Node(grid.length - 1, grid[0].length - 1);
        queue.add(new Node(0, 0));
        int[][] minCost = new int[grid.length][grid[0].length];
        Node[][] prePath = new Node[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }
        minCost[0][0] = grid[0][0];
        return minPathSum(grid, queue, end, minCost, prePath);
    }

    private int minPathSum(int[][] grid, Queue<Node> queue, Node end, int[][] minCost, Node[][] prePath) {
        do {
            Node now = queue.poll();
            for (int i = 0; i < 2; i++) {
                Node nextNode = new Node(now.x + fangXiang[i][0], now.y + fangXiang[i][1]);
                if (!isNotLegal(nextNode, end) && (minCost[now.x][now.y] + grid[nextNode.x][nextNode.y] < minCost[nextNode.x][nextNode.y] || minCost[nextNode.x][nextNode.y] == -1)) {
                    minCost[nextNode.x][nextNode.y] = minCost[now.x][now.y] + grid[nextNode.x][nextNode.y];
                    queue.add(nextNode);
                }
            }
        } while (!queue.isEmpty());
        return minCost[end.x][end.y];
    }

    // 深搜,果然超时了,换成广搜
    public int minPathSum01(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Node begin = new Node(0, 0);
        Node end = new Node(grid.length - 1, grid[0].length - 1);
        boolean[][] flagPath = new boolean[grid.length][grid[0].length];
        int sum = 0;
        minPathSum(grid, flagPath, begin, end, sum);
        return min;
    }

    private int[][] fangXiang = {
            {1, 0},
            {0, 1},
    };
    private int min = Integer.MAX_VALUE;

    private void minPathSum(int[][] grid, boolean[][] flagPath, Node now, Node end, int sum) {
        if (sum + grid[end.x][end.y] > min) {
            return;
        } else if (now.x == end.x && now.y == end.y) {
            sum = sum + grid[end.x][end.y];
            min = sum < min ? sum : min;
            return;
        }
        for (int i = 0; i < 2; i++) {
            Node nextNode = new Node(now.x + fangXiang[i][0], now.y + fangXiang[i][1]);
            if (isNotLegal(nextNode, end) || flagPath[nextNode.x][nextNode.y]) {
                continue;
            }
            flagPath[nextNode.x][nextNode.y] = true;
            minPathSum(grid, flagPath, nextNode, end, sum + grid[now.x][now.y]);
            flagPath[nextNode.x][nextNode.y] = false;
        }
    }


    private boolean isNotLegal(Node nextNode, Node end) {
        if (nextNode.x < 0 || nextNode.y < 0 || nextNode.x > end.x || nextNode.y > end.y) {
            return true;
        }
        return false;
    }
}

class Node {
    int x;
    int y;
    // 上一个节点的位置.以便于找到最终路径

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
