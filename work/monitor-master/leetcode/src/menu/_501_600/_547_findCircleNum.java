package menu._501_600;

public class _547_findCircleNum {
    public int findCircleNum(int[][] M) {
        boolean[] hasCircle = new boolean[M.length];
        int countCircle = 0;
        for (int i = 0; i < M.length; i++) {
            if (!hasCircle[i]) {
                hasCircle[i] = true;
                // 将这个人的朋友们加到这个set中去
                circleDetail(i, hasCircle, M);
                countCircle++;
            }
        }
        return countCircle;
    }

    private void circleDetail(int id, boolean[] hasCircle, int[][] M) {
        for (int i = 0; i < M[id].length; i++) {
            if (i != id && !hasCircle[i] && M[id][i] == 1) {
                hasCircle[i] = true;
                circleDetail(i, hasCircle, M);
            }
        }
    }

}
