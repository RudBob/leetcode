package tag.dp;

/**
 * @ClassName minSteps
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/14 12:58
 * @Version 1.0
 */
public class minSteps {
    // 规律
    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 2;
        }
        return minSteps2(n);
    }

    private int minSteps2(int n) {
        if (n == 2) {
            return 2;
        }
        int k = (int) Math.sqrt(n);
        for (int i = 2; i <= k; i++) {
            if (n % i == 0) {
                return minSteps2(n / i) + i;
            }
        }
        return n;
    }

    // 深搜
    public int minSteps_1(int n) {
        if (n == 1) {
            return 1;
        }
        int steps = 1;
        int add = 1;
        return minSteps(1, add, steps, n);
    }

    private int minSteps(int now, int add, int steps, int target) {
        if (now > target) {
            return target;
        } else if (now == target) {
            return steps;
        }
        // 增量不变.
        int res0 = minSteps(now + add, add, steps + 1, target);
        // 增量增加
        add = now;
        int res1 = minSteps(now + add, add, steps + 2, target);
        return Math.min(res0, res1);
    }
}
