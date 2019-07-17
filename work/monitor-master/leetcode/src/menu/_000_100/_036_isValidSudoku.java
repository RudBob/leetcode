package menu._000_100;

import java.util.Arrays;

/**
 * @ClassName _036_isValidSudoku
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/15 14:18
 * @Version 1.0
 */
public class _036_isValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // 判断数组
        return judgeHang(board) && judgeLie(board) && judgeKuai(board);
    }

    private boolean judgeKuai(char[][] board) {
        boolean[] used = new boolean[9];
        for (int k = 0; k < 9; k++) {
            Arrays.fill(used,false);
            // 块
            // 行从
            for (int i = (k % 3) * 3, iend = i + 3; i < iend; i++) {
                for (int j = (k / 3) * 3, jend = j + 3; j < jend; j++) {
                    if(board[i][j] == '.'){
                        continue;
                    }
                    int val = board[i][j] - '1';
                    if(used[val]) {
                        return false;
                    }
                    used[val] = true;
                }
            }
        }
        return true;
    }

    private boolean judgeLie(char[][] board) {
        boolean[] used = new boolean[9];
        for (int j = 0; j < board.length; j++) {
            Arrays.fill(used,false);
            for (int i = 0; i < board.length; i++) {
                if(board[i][j] == '.'){
                    continue;
                }
                int val = board[i][j] - '1';
                if(used[val]) {
                    return false;
                }
                used[val] = true;
            }
        }
        return true;
    }

    private boolean judgeHang(char[][] board) {
        boolean[] used = new boolean[9];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(used,false);
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == '.'){
                    continue;
                }
                int val = board[i][j] - '1';
                if(used[val]) {
                    return false;
                }
                used[val] = true;
            }
        }
        return true;
    }
}
