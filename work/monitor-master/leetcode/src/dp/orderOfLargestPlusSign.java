package dp;

/**
 * @ClassName orderOfLargestPlusSign
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/11 11:20
 * @Version 1.0
 */
public class orderOfLargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        CountNode[][] map = new CountNode[N][N];
        for (int[] mine : mines) {
            map[mine[0]][mine[1]] = new CountNode(0);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == null) {
                    map[i][j] = new CountNode();
                } else {
                    continue;
                }
                if (i != 0) {
                    // 上面有连续几个 1 .
                    map[i][j].countUp = map[i - 1][j].countUp + map[i - 1][j].val;
                }
                if (j != 0) {
                    // 左面有连续几个 1 .
                    map[i][j].countLeft = map[i][j - 1].countLeft + map[i][j - 1].val;
                }
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (map[i][j].val == 0) {
                    continue;
                }
                if (i != N - 1) {
                    // 上面有连续几个 1 .
                    map[i][j].countDown = map[i + 1][j].countDown + map[i + 1][j].val;
                }
                if (j != N - 1) {
                    // 左面有连续几个 1 .
                    map[i][j].countRight = map[i][j + 1].countRight + map[i][j + 1].val;
                }
            }
        }
        // found 最长的十字.
        int max = 0;
        for (int i = 0; i < N - max; i++) {
            for (int j = 0; j < N - max; j++) {
                if (max < map[i][j].getAdd()) {
                    max = map[i][j].getAdd();
                }
            }
        }
        return max;
    }
}

class CountNode {
    int val = 1;
    int countUp = 0;
    int countDown = 0;
    int countRight = 0;
    int countLeft = 0;

    public CountNode(int val) {
        this.val = val;
    }

    public CountNode() {
    }


    public int getAdd() {
        if (val == 0) {
            return 0;
        }
        return Math.min(Math.min(countUp, countDown), Math.min(countRight, countLeft)) + val;
    }
}
