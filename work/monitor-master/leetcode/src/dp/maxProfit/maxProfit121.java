package dp.maxProfit;

/**
 * @ClassName maxProfit121
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/4 11:07
 * @Version 1.0
 */
public class maxProfit121 {
    public int maxProfit(int[] prices) {
        int minIndex = 0, maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[minIndex]) {
                minIndex = i;
            }
            int profit = prices[i] - prices[minIndex];
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
