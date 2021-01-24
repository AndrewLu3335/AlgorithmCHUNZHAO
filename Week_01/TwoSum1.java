import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Andrew Lu
 * @Description: 两数之和
 */
public class TwoSum1 {
    /**
     * O（N^2）
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int []a=new int[2];
        for (int i=0; i<nums.length-1; ++i) {
            for (int j=i+1; j<=nums.length-1;j++) {
                if(nums[i]+nums[j]==target){
                    a[0]=i;
                    a[1]=j;
                    return a;
                }
            }
        }
        return new int[2];
    }

    /**
     * hash -> O(N)
     * target-a exist in nums?
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0; i<nums.length; ++i) {
            map.put(nums[i],i);
        }
        for (int i=0;i<nums.length;++i){
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i ){
                return new int[] {i,map.get(target-nums[i])};
            }
        }
        return new int[0];
    }
}
