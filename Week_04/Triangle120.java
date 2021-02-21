import java.util.List;

/**
 * @Author: Andrew Lu
 * @Description: 三角形最小路径和
 */

/**
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 *
 */
public class Triangle120 {

    /**
     * 用一维数组存储结果，
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int[] dp=new int[triangle.size()+1];
        for ( int i=triangle.size()-1; i>=0; --i) {
            for (int j=0; j<triangle.get(i).size(); ++j) {
                //根据规则 下一层只能是上一层取得索引的相同所索引或者索引+1
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    /**
     *递归+cache
     * @param triangle
     * @return
     */
    int row;
    public int minimumTotal(List<List<Integer>> triangle) {
        row=triangle.size();
        return helper(0,0,triangle);
    }

    private int helper(int level, int a, List<List<Integer>> triangle) {
        if (level==row-1) {return triangle.get(level).get(a);}
        int left=helper(level+1,a,triangle);
        int right=helper(level+1,a+1,triangle);
        return Math.min(left,right)+triangle.get(level).get(a);
    }


}
