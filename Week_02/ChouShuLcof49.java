import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @Author: Andrew Lu
 * @Description: 丑数
 */
public class ChouShuLcof49 {
    public int nthUglyNumber1(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min){ factor2 = 2*ugly[++index2]; }

            if(factor3 == min){ factor3 = 3*ugly[++index3];}

            if(factor5 == min){ factor5 = 5*ugly[++index5];}

        }
        return ugly[n-1];
    }
    public int nthUglyNumber2(int n) {
        PriorityQueue<Long> heap=new PriorityQueue<>();
        heap.add(1L);
        //标记已经进入过堆的元素
        HashSet<Long>seen =new HashSet<>();
        seen.add(1L);
         int[] factors=new int[]{1,3,5};
         long curUglyNum=1,newUgly;
         for (int i=0; i<n; i++ ){
             curUglyNum=heap.poll();
             //弹出堆中最小的数字后分别*2，*3，*5，如果还没如果堆的就入堆
             for (int factor : factors) {
                 newUgly=factor * curUglyNum;
                 if(!seen.contains(newUgly)){
                     seen.add(newUgly);
                     heap.add(newUgly);
                 }
             }
         }
         return (int)(curUglyNum);

    }
}
