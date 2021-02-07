/**
 * @Author: Andrew Lu
 * @Description: 买卖股票的最佳时机
 */
public class BestTimeToBuyAndSellStockII122 {
    /**
     * 贪心算法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int money=0;
        for (int i=0; i<prices.length; ++i) {
            if(i>0 && prices[i]>prices[i-1]) {
                money+=prices[i]-prices[i-1];
            }
        }
        return money;
    }
}
