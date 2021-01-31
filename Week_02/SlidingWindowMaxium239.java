import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author: Andrew Lu
 * @Description: 滑动窗口最大值
 */
public class SlidingWindowMaxium239 {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[]res=new int[nums.length-k+1];
        if(nums==null || k==0){return res;}
        PriorityQueue<Integer> max=new PriorityQueue<>((o1, o2) -> (o2-o1));
        for (int i=0; i<nums.length;i++) {
            int start=i-k;
            //如果已经填满了k个元素了，在所有操作前先移除一个元素
            if(start>=0) {
                max.remove(nums[start]);
            }
            //向大顶堆里补充一个
            max.offer(nums[i]);
            //如果补充一个后，大顶堆里满了k个元素，就在结果数组中添加一个最大值
            if(max.size()==k){
                res[i-k+1]=max.peek();
            }
        }
        return res;
    }

    /**
     * 双向队列中 保持队头元素是最大的元素，每次向后滑动，
     * 新的值进来的时候先判断是否和滑动窗口里的值大，大的话就一次比较滑动窗口里的剩余的值 。
     * 每次都返回对头元素到结果数组中
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) {return nums;}
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 滑动窗口左边的边界值
            if(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }
}
