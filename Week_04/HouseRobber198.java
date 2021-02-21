/**
 * @Author: Andrew Lu
 * @Description: 打家劫舍
 */
public class HouseRobber198 {

    /**
     * 动态规划+二维数组存储
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        if (nums==null || nums.length==0) {return 0;}


        int n=nums.length;
        int [][] dp=new int[n][2];
        //第二维 0：不打劫 1：打劫
        dp[0][0]=0;
        dp[0][1]=nums[0];

        for (int i=1;i<n; ++i) {
            dp[i][0]=Math.max(dp[i-1][1],dp[i-1][0]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }

    /**
     * 动态规划+1维数组存储
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums==null || nums.length==0) {return 0;}
        if (nums.length==1) {return nums[0];}

        int n=nums.length;
        int []dp=new int[n];
        //第二维 0：不打劫 1：打劫
        dp[0]=nums[0];
        dp[1]=Math.max(dp[0],nums[1]);

        for (int i=2;i<n; ++i) {
            //dp[i-1]: 不打劫dp[i], nums[i]+dp[i-2]: 打劫当前的房子
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }
}
