import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: Andrew Lu
 * @Description: 前k个高频元素
 */
public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length<=1 ||k==0 ){return nums;}
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap=new PriorityQueue<>((o1, o2) -> (
            o2.getValue()-o1.getValue()));
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            maxHeap.add(entry);
        }
        int [] res=new int [k];
        for (int i=0; i<k; i++ ){
            res[i]=maxHeap.poll().getKey();
        }
        return res;
    }
}
