

/**
 * @Author: Andrew Lu
 * @Description: 合并两个有序数组
 */
public class MergeTwoSortedList88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int i=m-1;
       int j=n-1;
       int k=m+n-1;
       while(i>=0 && j >= 0 ) {
           if(nums1[i]>nums2[j]){
               nums1[k--]=nums1[i--];
           }else{
               nums1[k--]=nums2[j--];
           }
       }
       if(nums2!=null){
            System.arraycopy(nums2,0,nums1,0,j+1);
       }
    }
}
