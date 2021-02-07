import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Andrew Lu
 * @Description: 子集
 */
public class subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> output=new ArrayList<>();
        dfs(res,output,nums,0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> output, int[] nums, int index) {
        if(index==nums.length) {
            res.add(new ArrayList<>(output));
            return;
        }
        //先存放一个空值
        dfs(res,output,nums,index+1);
        output.add(nums[index]);
        dfs(res,output,nums,index+1);
        //恢复成之前的样子
        output.remove(output.size()-1);
    }


    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
