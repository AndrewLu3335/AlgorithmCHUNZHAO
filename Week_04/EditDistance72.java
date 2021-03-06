/**
 * @Author: Andrew Lu
 * @Description: 编辑距离
 */
public class EditDistance72 {

    /**
     * 动态规划
     *
     * 1. 当word1[i]==word2[j]时,由于遍历到了i和j,说明word1的0~i-1和word2的0~j-1的匹配结果已经生成,
     * 由于当前两个字符相同,因此无需做任何操作,dp[i][j]=dp[i-1][j-1]
     * 2. 当word1[i]!=word2[j]时,可以进行的操作有3个:
     *     1) 替换操作:可能word1的0~i-1位置与word2的0~j-1位置的字符都相同,
     *            只是当前位置的字符不匹配,进行替换操作后两者变得相同,
     *            所以此时dp[i][j]=dp[i-1][j-1]+1(这个加1代表执行替换操作)
     *     2) 删除操作:若此时word1的0~i-1位置与word2的0~j位置已经匹配了,
     *          此时多出了word1的i位置字符,应把它删除掉,才能使此时word1的0~i(这个i是执行了删除操作后新的i)
     *          和word2的0~j位置匹配,因此此时dp[i][j]=dp[i-1][j]+1(这个加1代表执行删除操作)
     *     3) 插入操作:若此时word1的0~i位置只是和word2的0~j-1位置匹配,
     *           此时只需要在原来的i位置后面插入一个和word2的j位置相同的字符使得
     *           此时的word1的0~i(这个i是执行了插入操作后新的i)和word2的0~j匹配得上,
     *           所以此时dp[i][j]=dp[i][j-1]+1(这个加1代表执行插入操作)
     *     4) 由于题目所要求的是要最少的操作数:所以当word1[i] != word2[j] 时,
     *           需要在这三个操作中选取一个最小的值赋格当前的dp[i][j]
     * 3. 总结:状态方程为:
     * if(word1[i] == word2[j]):
     *       dp[i][j] = dp[i-1][j-1]
     * else:
     *        min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 初始化第一行为插入word1的步数
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 初始化第一列为删除word2的步数
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                //当前字符相等
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                //要进行操作（替换，删除，插入）
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];
    }
}
