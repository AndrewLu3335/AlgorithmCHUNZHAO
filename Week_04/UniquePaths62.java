/**
 * @Author: Andrew Lu
 * @Description: 不同路径
 */
public class UniquePaths62 {


    /**
     * 从目标位置倒着走到start位置
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0;j--) {
                if (i==(m-1) || j==(n-1)) {
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }

    /**
     * 从start开始走到目标位置
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n;j++) {
                if (i==0|| j==0) {
                    dp[i][j]=1;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
