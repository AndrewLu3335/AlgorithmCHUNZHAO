import java.util.Arrays;

/**
 * @Author: Andrew Lu
 * @Description: 零钱交换
 */
public class CoinChange322 {
    /**
     * 动态规划
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        //声明一个最大值
        int max = amount + 1;
        //记录了每一个金额需要的最少的金币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        //i表示金额数，j代表不同金额的硬币
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] ==max ? -1 : dp[amount];
    }
}
