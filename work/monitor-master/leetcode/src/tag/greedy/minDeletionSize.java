package tag.greedy;

public class minDeletionSize {
    public int minDeletionSize(String[] A) {
        StringBuilder[] a = new StringBuilder[A.length];
        char[][] aCh = new char[A.length][];
        for (int i = 0, len = A.length; i < len; i++) {
            aCh[i] = A[i].toCharArray();
            a[i] = new StringBuilder();
        }
        int count = 0;
        boolean hasEqual = false;
        for (int j = 0; j < aCh[0].length; j++) {
            hasEqual = false;
            a[0].append(aCh[0][j]);
            int i = 1;
            for (; i < aCh.length; i++) {
                a[i].append(aCh[i][j]);
                if (a[i].toString().compareTo(a[i - 1].toString()) < 0) {
                    count++;
                    hasEqual = false;
                    // 回滚这一列
                    for (; i >= 0; i--) {
                        a[i].deleteCharAt(a[i].length() - 1);
                    }
                    break;
                } else if (a[i].toString().compareTo(a[i - 1].toString()) == 0) {
                    hasEqual = true;
                }
            }
            if (i == aCh.length && !hasEqual) {
                break;
            }
        }
        return count;
    }
}
