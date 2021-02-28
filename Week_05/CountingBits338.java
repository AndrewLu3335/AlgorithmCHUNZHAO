/**
 * @Author: Andrew Lu
 * @Description: 比特位计数
 */
public class CountingBits338 {

    /**
     * 动态规划+最小位
     *
     * 从1到6
     *   0001
     *   0010
     *   0011
     *   0100
     *   0101
     *   0110
     * 从1开始到num遍历， dp[当前数/2] + 当前数对2取模
     *
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {

        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            //dp[i/2] + (i mod 2)
            dp[i] = dp[i >> 1] + (i & 1); 
        return dp;
    }

    
}
