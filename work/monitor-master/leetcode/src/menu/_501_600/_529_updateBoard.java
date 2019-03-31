package menu._501_600;

public class _529_updateBoard {

    public char[][] updateBoard(char[][] board, int[] click) {
        // 深度优先
        int x = click[0];
        int y = click[1];
        update(board, x, y);
        return board;
    }

    private void update(char[][] board, int x, int y) {
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else if (board[x][y] == 'B' || Character.isDigit(board[x][y])) {
            return;
        } else {
            if (board[x][y] == 'E') {
                // 找到九宫格内的地雷数.
                int count = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        // 合法，跳过自身
                        if (!(i == 0 && j == 0) && isLegal(board, i + x, j + y)) {
                            if (board[x + i][y + j] == 'M') {
                                count++;
                            }
                        }
                    }
                }
                if (count == 0) {
                    board[x][y] = 'B';
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            // 合法，跳过自身
                            if (!(i == 0 && j == 0) && isLegal(board, i + x, j + y)) {
                                update(board, i + x, y + j);
                            }
                        }
                    }
                } else {
                    board[x][y] = (char) ('0' + count);
                }
                // 显示周围的方格
            }
        }
    }

    private boolean isLegal(char[][] board, int i, int j) {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
    }
}
