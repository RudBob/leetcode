package dp;

import java.util.Arrays;

/**
 * @ClassName minCostClimbingStairs
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/5 9:46
 * @Version 1.0
 */
public class minCostClimbingStairs {
    public int minCostClimbingStairs01(int[] cost) {
        int[] minCost = new int[cost.length];
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            minCost[i] = cost[i] + Math.min(minCost[i - 1], minCost[i - 2]);
        }
        return Math.min(minCost[cost.length - 1], minCost[cost.length - 2]);
    }

    /**
     * cache 递归。
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int target = cost.length;
        int[] minCost = new int[target + 1];
        Arrays.fill(minCost, -1);
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        minCost[target] = 0;
        return minCostClimbingStairs(cost, minCost, target);
    }

    private int minCostClimbingStairs(int[] cost, int[] minCost, int target) {
        if (target == 0) {
            return minCost[0];
        } else if (target == 1) {
            return minCost[1];
        }
        if (target == cost.length || minCost[target] == -1) {
            if (target == cost.length) {
                minCost[target] = Math.min(minCostClimbingStairs(cost, minCost, target - 1), minCostClimbingStairs(cost, minCost, target - 2));
            } else {
                minCost[target] = cost[target] + Math.min(minCostClimbingStairs(cost, minCost, target - 1), minCostClimbingStairs(cost, minCost, target - 2));
            }
        }
        return minCost[target];
    }
}
