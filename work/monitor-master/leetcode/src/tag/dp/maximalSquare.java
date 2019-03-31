package tag.dp;

/**
 * @ClassName maximalSquare
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/19 12:53
 * @Version 1.0
 */
public class maximalSquare {
    /**
     * 求最大正方形的dp公式
     * tag.dp[i][j] = Math.min(tag.dp[i - 1][j - 1], tag.dp[i- 1][j], tag.dp[i][j-1])
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] square = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                square[i][j] = matrix[i][j] - '0';
                if (square[i][j] == 1) {
                    if (i != 0 && j != 0) {
                        square[i][j] = 1 + Math.min(square[i - 1][j - 1], Math.min(square[i - 1][j], square[i][j - 1]));
                        maxArea = maxArea < square[i][j] * square[i][j] ? square[i][j] * square[i][j] : maxArea;
                    } else if (maxArea == 0) {
                        maxArea = 1;
                    }
                }
            }
        }
        //[["1","0","1","0","0"],
        // ["1","0","1","1","1"],
        // ["1","1","1","1","1"],
        // ["1","0","0","1","0"]]
        return maxArea;
    }
}
