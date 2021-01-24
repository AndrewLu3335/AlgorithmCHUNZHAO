/**
 * @Author: Andrew Lu
 * @Description: 移动零
 */
public class MoveZeroes283 {
    /**
     * O(N)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        //j用来记录非0元素的下表位置
        int j=0;
        for (int i=0;i<nums.length;++i){
            if(nums[i]!=0) {
                //把非0元素存放到j位置
                nums[j]=nums[i];
                //如果j指向的位置为0
                if(i!=j){
                    nums[i]=0;
                }
                j++;
            }
        }
    }
}
