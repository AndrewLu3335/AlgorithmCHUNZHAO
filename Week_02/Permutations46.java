import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Andrew Lu
 * @Description: 全排列
 */
public class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();

        List<Integer> output=new ArrayList<>();
        for (int num :nums) {
            output.add(num);
        }
        backtrack(nums.length,output,res,0);
        return res;
    }

    /**
     * 递归
     *  结束条件： 走完/遍历完数组 代表一个分支排列完毕 添加到res结果集中
     *  递归逻辑：从第一个数开始和之后的每一个数交换 并且递归， 返回后 将数组交换的元素通过交换的形式，恢复成交换前的排列
     *  向下递归方式： first+1
     * @param length
     * @param output
     * @param res
     * @param first
     */
    private void backtrack(int length, List<Integer> output, List<List<Integer>> res, int first) {
        if (first==length) {
            res.add(new ArrayList<>(output));
            return;
        }

        for ( int i=first; i<length; i++) {
            Collections.swap(output,first,i);
            backtrack(length,output,res,first+1);
            Collections.swap(output,first,i);
        }
    }



    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
