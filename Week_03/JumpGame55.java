/**
 * @Author: Andrew Lu
 * @Description: 跳跃游戏
 */
public class JumpGame55 {
    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int reachPosition=nums.length-1;
        for (int i= nums.length-1; i>=0; --i) {
            if((nums[i]+i)>=reachPosition) {
                reachPosition=i;
            }
        }
        return reachPosition==0;
    }
}
