import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Andrew Lu
 * @Description: 旋转数组
 */
public class RotateArray189 {
    /**
     * O(N)
     * dest Index= (old index+ k) % nums.length
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        //<index，value>
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = map.get(i);
        }
    }

    /**
     * O(N)
     *
     * @param nums
     * @param k
     */
    // [1, 2, 3, 4] k=2
    public void rotate1(int[] nums, int k) {
        k %= nums.length;
        //after: [4, 3, 2, 1]       exchange index: 4&3 1&2
        reverse(nums, 0, nums.length - 1);
        //after: [3,4, 2, 1]        exchange index: 4&3
        reverse(nums, 0, k - 1);
        //after: [3, 4, 1, 2]       exchange index: 1&2
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}
