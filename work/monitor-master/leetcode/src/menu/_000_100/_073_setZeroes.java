package menu._000_100;

/**
 * @ClassName _073_setZeroes
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/16 10:18
 * @Version 1.0
 */
public class _073_setZeroes {
    public void setZeroes(int[][] matrix) {
        // 首先，特殊处理第一行第一列
        boolean firstRowZero = flagFirstRow(matrix);
        boolean firstColumnZero = flagFirstColumn(matrix);

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 遍历第一行，将其0所再所有列置0
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        // 遍历第一列，将其0所再所有行置0
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 是否要改变第一行，第一列
        if (firstColumnZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

    }

    private boolean flagFirstColumn(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean flagFirstRow(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                return true;
            }
        }
        return false;
    }
}
