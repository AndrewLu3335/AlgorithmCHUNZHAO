import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: Andrew Lu
 * @Description: 最小K个数
 */
public class MinKNumbersIcof40 {
    public int[] getLeastNumbers1(int[] arr, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for (int num : arr) {
            heap.add(num);
        }
        int[]res=new int[k];
        for (int i=0; i<k; i++) {
            res[i]=heap.poll();
        }
        return res;
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[]res=new int[k];
        for (int i=0; i<k; i++) {
            res[i]=arr[i];
        }
        return res;
    }
}
