package tag.dp;

/**
 * @ClassName knightProbability
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/12 18:10
 * @Version 1.0
 */
public class knightProbability {
    int[][] next = {{2, 1}, {-2, 1}, {2, -1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

//    Map<Node, Double> map = new HashMap<>();

    public double knightProbability(int N, int K, int r, int c) {
        if (K == 0) {
            return 1;
        }
        double[][][] map = new double[N][N][K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < K; k++) {
                    map[i][j][k] = -1;
                }
            }
        }
        Jump(N, K, r, c, map);

        return map[r][c][K - 1] / Math.pow(8, K);
    }

    private double Jump(int n, int k, int r, int c, double[][][] map) {
        if (k == 0) {
            if (legal(r, c, n)) {
                return 1;
            }
            return 0;
        }
        if (map[r][c][k - 1] == -1) {
            double rr = 0;
            for (int i = 0; i < 8; i++) {
                if (legal(r + next[i][0], c + next[i][1], n)) {
                    rr += Jump(n, k - 1, r + next[i][0], c + next[i][1], map);
                }
            }
            map[r][c][k - 1] = rr;
        }
        return map[r][c][k - 1];
    }

    private boolean legal(int r, int c, int n) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }

}
