import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Andrew Lu
 * @Description: 全排列 II
 */
public class PermutationsII47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        boolean [] visited=new boolean[nums.length];
        //面对题目中会出现数组去重的 都可以先排序
        Arrays.sort(nums);
        backtruck(nums,output,res,nums.length, 0,visited);
        return res;
    }

    private void backtruck(int []nums,List<Integer> output, List<List<Integer>> res, int n, int index,boolean[] visited) {
        if(index==n) {
            res.add(new ArrayList<>(output));
            return;
        }
        for (int i=0; i<n; ++i) {
            //（如果该值被访问过 ｜｜ 如果这个值和前一个值相同，并且前一个值被访问过） 就跳过此次
            if (visited[i] || (i>0 && nums[i-1]==nums[i] && !visited[i-1])) {
                continue;
            }
            //标记已经用过了这个值
            output.add(nums[i]);
            visited[i]=true;
            backtruck(nums,output,res,n,index+1,visited);
            visited[i]=false;
            output.remove(index);
        }
    }
}
