package recall;

public class exist {
    boolean flag = false;

    public boolean exist(char[][] board, String word) {
        int yLen = board.length;
        int xLen = board[0].length;
        boolean[][] weatherUse = new boolean[yLen][xLen];
        // 找到第一个字母所在的所有位置。
        for (int i = 0; i < board.length && !flag; i++) {
            for (int j = 0; j < board[i].length && !flag; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // 标记未被使用的初始化.
                    weatherUse[i][j] = true;
                    dfs(board, weatherUse, word, 1, i, j);
                    weatherUse[i][j] = false;
                }
            }
        }
        return flag;
    }

    // 上下左右的顺序
    int[][] d = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };

    private void dfs(char[][] board, boolean[][] weatherUse, String word, int counter, int y, int x) {
        int yLen = board.length;
        int xLen = board[0].length;
        // 如果字符串完全匹配，flag置为true
        if (counter == word.length()) {
            flag = true;
            return;
        }
        for (int i = 0; i < 4 && !flag; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            if (inArea(newX, newY, xLen, yLen)
                    && !weatherUse[newY][newX]
                    && board[newY][newX] == word.charAt(counter)) {
                weatherUse[newY][newX] = true;
                dfs(board, weatherUse, word, counter + 1, newY, newX);
                weatherUse[newY][newX] = false;
            }
        }
    }

    private boolean inArea(int newX, int newY, int xLen, int yLen) {
        return newX < xLen && newX >= 0 && newY < yLen && newY >= 0;
    }
}
