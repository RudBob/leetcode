package menu._000_100;

/**
 * @ClassName _029_divide
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/16 16:07
 * @Version 1.0
 */
public class _029_divide {

    // dividend 分母
    // divisor 分子
    public int divide(int dividend, int divisor) {
        long end = dividend;
        long sor = divisor;

        long sign = getSign(end, sor);
        end = end > 0 ? end : -end;
        sor = sor > 0 ? sor : -sor;
        // 二分法.
        long[] memo = new long[32];
        long[] m = new long[32];
        m[0] = 1;
        memo[0] = sor;
        for (int i = 1; memo[i - 1] < end; i++) {
            memo[i] = memo[i - 1] << 1;
            m[i] = m[i - 1] << 1;
        }
        long kkk = getRes(end, memo, m);
        if(sign == 0){
            kkk = 0;
        }else if(sign == -1){
            kkk = -kkk;
        }
        if (sign == 1 && kkk > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (sign == -1 && kkk < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) kkk;
    }

    private long getRes(long dividend, long[] memo, long[] m) {
        if (dividend < memo[0]) {
            return 0;
        } else if (dividend == memo[0]) {
            return m[0];
        }
        int i = 0;
        while (memo[i] < dividend) {
            i++;
        }
        dividend -= memo[i - 1];
        return m[i - 1] + getRes(dividend, memo, m);
    }

    private long getSign(long dividend, long divisor) {
        if (dividend == 0) {
            return 0;
        } else if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            return -1;
        } else {
            return 1;
        }
    }
}
