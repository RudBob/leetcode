package dp;

/**
 * @ClassName integerBreak
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/8 12:13
 * @Version 1.0
 */
public class integerBreak {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        } else if (n == 4) {
            return 4;
        }
        int[] maxValue = new int[n + 1];
        maxValue[1] = 1;
        maxValue[2] = 2;
        maxValue[3] = 3;
        maxValue[4] = 4;
        return getMax(n, maxValue);
    }

    private int getMax(int n, int[] maxValue) {
        if (maxValue[n] == 0) {
            maxValue[n] = n;
            for (int i = 2; i < n - 1; i++) {
                int temp = getMax(n - i, maxValue) * getMax(i, maxValue);
                if (temp > maxValue[n]) {
                    maxValue[n] = temp;
                }
            }
        }
        return maxValue[n];
    }
}
