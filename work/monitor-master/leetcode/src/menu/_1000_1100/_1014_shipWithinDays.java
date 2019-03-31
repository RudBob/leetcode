package menu._1000_1100;

public class _1014_shipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        // 递归.
        // 先找出初始值
        int max = 0, sum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > max) {
                max = weights[i];
            }
            sum += weights[i];
        }
        int w = Math.max(max, (int) (sum / weights.length + 0.999));
        return shipWithinDays(weights, D, w);
    }

    int min = Integer.MAX_VALUE;

    private int shipWithinDays(int[] weights, int d, int w) {
        int res = -1;
        while (res < 0) {
            min = Integer.MAX_VALUE;
            res = shipWithinDays2(weights, d, w, 0);
            w += min;
        }
        return res;
    }

    private int shipWithinDays2(int[] weights, int d, int w, int index) {
        if (d >= 0 && index == weights.length) {
            return w;
        }
        if (d == 0 && index < weights.length) {
            return -1;
        }
        int sum = weights[index];
        while (index + 1 < weights.length && sum + weights[index + 1] <= w) {
            sum += weights[index + 1];
            index++;
        }
        if (index == weights.length - 1) {
            return w;
        }
        min = weights[index + 1] - (w - sum) < min ? weights[index + 1] - (w - sum) : min;
        return shipWithinDays2(weights, d - 1, w, index + 1);
    }
}
