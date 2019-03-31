package menu._901_1000;

public class sumEvenAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        if (queries == null || queries.length == 0) {
            return null;
        }
        int[] an = new int[queries.length];
        // 遍历一遍，求出奇偶数之和
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                sum2 += A[i];
            } else {
                sum1 += A[i];
            }
        }
        // 遍历查询数组
        for (int i = 0; i < queries.length; i++) {
            if (A[queries[i][1]] % 2 == 0) {
                sum2 -= A[queries[i][1]];
            } else {
                sum1 -= A[queries[i][1]];
            }
            A[queries[i][1]] += queries[i][0];
            if (A[queries[i][1]] % 2 == 0) {
                sum2 += A[queries[i][1]];
            } else {
                sum1 += A[queries[i][1]];
            }
            an[i] = sum2;
        }
        return an;
    }
}
