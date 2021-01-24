import java.util.Arrays;

/**
 * @Author: Andrew Lu
 * @Description: 删除排序数组中的重复项
 */
public class RemoveDuplicatesFromSortedArray26 {
    /**
     * O(N)
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        if(nums==null || nums.length<0) {return 0;}
        //i 指向比较的数字/ 需要填充的空的前一个空
        //j 指向现在操作的数字
        int i=0,j=1;
        //计数器：计数重复了多少元素
        //int count=0;
        while(j<nums.length) {
            if(nums[j]!=nums[i]){
                nums[i+1]=nums[j];
                i++;
            }
            j++;
        }
        //移除尾部的多余元素
//        int[] res = Arrays.copyOf(nums, nums.length - count);
//        return res.length;
        return i+1;
    }
}
