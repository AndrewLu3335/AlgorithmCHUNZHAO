/**
 * @Author: Andrew Lu
 * @Description: 最大子序和
 */

/**
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class MaximumSubarray53 {

    /**
     * 分治：maxSum(i)=Math.max(maxSum(i-1), 0) //包含前有个数的和或者不包含前一个数的和，两者取最大值
     * 状态数组定：dp[i] / nums[i]
     * DP方程: dp[i]=Math.max(dp[i-1]+dp[i],dp[i]+0)
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int maxAns=nums[0];

        for (int i=1; i<nums.length; i++) {
            nums[i]=Math.max(nums[i-1]+nums[i],nums[i]);
            maxAns=Math.max(maxAns,nums[i]);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        MaximumSubarray53 m=new MaximumSubarray53();
        System.out.println(m.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2}));
    }
}
