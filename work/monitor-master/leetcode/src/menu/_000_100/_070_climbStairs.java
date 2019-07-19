package menu._000_100;

/**
 * @ClassName _070_climbStairs
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 14:17
 * @Version 1.0
 */
public class _070_climbStairs {

    /**
     * 直接推过去
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int a = 1, b = 2, res = 0;
        while (n != 2) {
            res = a + b;
            a = b;
            b = res;
            n--;
        }
        return res;
    }

    /**
     * 递归，4500ms，5%
     */
    public int climbStairs01(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return climbStairs01(n - 1) + climbStairs01(n - 2);
    }

    /**
     * 优化递归，3ms，80%
     */
    public int climbStairs02(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 2;
        return climbStairs(n, cache);
    }

    private int climbStairs(int n, int[] cache) {
        if (cache[n] == 0) {
            cache[n] = climbStairs(n - 2, cache) + climbStairs(n - 1, cache);
        }
        return cache[n];
    }
}
