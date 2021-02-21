/**
 * @Author: Andrew Lu
 * @Description: 最长公共子序列
 */
public class LongestCommonSubsequence1143 {
    /**
     * 动态规划
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int [][]dp=new int[m+1][n+1];
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                //如果当前字符串相等，则在左上方（之前比较的结果）的基础上+1
                if ( text1.charAt(i-1)==text2.charAt(j-1)) {
                    dp[i][j]=1 +dp[i-1][j-1];
                }else{
                    //取左边或者上面的最大值
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
