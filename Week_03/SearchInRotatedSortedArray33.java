/**
 * @Author: Andrew Lu
 * @Description: 搜索旋转排序数组
 */
public class SearchInRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段
            if (nums[mid] >= nums[lo]) {
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

//    public void getDivergencePoint( int ans,int left,int right) {
//        mid=(left+right)/2;
//        //如果mid两边的数字同时大于或者小于mid就找到了分歧点并且返回
//        if (mid+1<mid && mid-1<mid) {ans=mid+1; return;}
//        if (mid+1>mid && mid-1>mid) {ans=mid-1; return;}
//        //没有分歧点
//        if (left==right) { ans=-1;return;}
//
//        getDivergencePoint(ans,mid+1,right);
//        getDivergencePoint(ans,left,mid-1);
//    }
}
