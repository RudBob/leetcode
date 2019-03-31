package tag.dp.maxProfit;

/**
 * @ClassName maxProfit
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/11 13:11
 * @Version 1.0
 */
public class maxProfit {

    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] maxProfit = new int[prices.length + 1];
        int[] maxSellProfit = new int[prices.length + 1];
        maxSellProfit[prices.length - 1] = prices[prices.length - 1] - fee;

        for (int day = prices.length - 2; day >= 0; day--) {
            maxSellProfit[day] = Math.max(prices[day] - fee + maxProfit[day + 1], maxSellProfit[day + 1]);
            maxProfit[day] = getMaxProfit(day, maxProfit, prices, fee, maxSellProfit);
        }
        return maxProfit[0];
    }

    // 计算maxSelleProfit
    private int getMaxProfit(int day, int[] maxProfit, int[] prices, int fee, int[] maxSellProfit) {
        // 买入的收益.
        // 看看明天卖的收益大还是明天不卖的的收益大.
        // 明天卖掉的话，最大收益为： 现在的钱数+ 明天的最大收益.
        int tommrowSell = prices[day + 1] - fee + maxProfit[day + 2] - prices[day];
        // 今天买，明天不卖的最大收益。
        int tommrowNotSell = maxSellProfit[day + 2] - prices[day];
        int buy = Math.max(tommrowSell, tommrowNotSell);

        // 不买入的最大收益就是明天的最大收益.
        int notBuy = maxProfit[day + 1];
        return Math.max(buy, notBuy);
    }
}
