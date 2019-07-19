package menu._801_900;

/**
 * @ClassName _861_matrixScore
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 16:25
 * @Version 1.0
 */
public class _861_matrixScore {

    public int matrixScore(int[][] A) {
        // [[0,0,1,1],
        // [1,0,1,0],
        // [1,1,0,0]]

        // 1100
        // 1010
        // 1100

        /**
         * 1111
         * 1001
         * 1111
         */
        // 策略： 先遍历行，找到所有第一位为0的行进行翻转，然后从第二列开始，找到1.size < 0.size的列进行翻转
        for (int[] a : A) {
            if (a[0] == 0) {
                for (int i = 0; i < a.length; i++) {
                    a[i] = a[i] == 0 ? 1 : 0;
                }
            }
        }
        // 从第二列开始
        for (int j = 1; j < A[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < A.length; i++) {
                sum += A[i][j];
            }
            // 翻转
            if (sum < (A.length + 1) / 2) {
                for (int i = 0; i < A.length; i++) {
                    A[i][j] = A[i][j] == 0 ? 1 : 0;
                }
            }
        }
        int res = 0;
        for (int[] ints : A) {
            int k = 0;
            for (int j = 0; j < A[0].length; j++) {
                k = k * 2 + ints[j];
            }
            res += k;
        }
        return res;
    }
}
