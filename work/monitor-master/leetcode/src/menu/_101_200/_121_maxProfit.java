package menu._101_200;

/**
 * @ClassName _121_maxProfit
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 14:16
 * @Version 1.0
 */
public class _121_maxProfit {
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
