import java.util.Arrays;

/**
 * @Author: Andrew Lu
 * @Description: 翻转对
 */
public class ReserverPairs493 {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    //递归
    private int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0;
        //取中间值
        int mid = s + ((e-s)>>1);
        //总计数=左边部分计数+右边部分计数
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e);
        //计数
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++;
            cnt += j-(mid+1);
        }
        //最后对nums数组中的s到e+1位置进行排序，归并，时间复杂度：logN
        Arrays.sort(nums, s, e+1);
        return cnt;
    }
}
