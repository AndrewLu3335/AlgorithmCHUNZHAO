import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Andrew Lu
 * @Description: 括号生成
 */
public class GenerateParentheses22 {
    //private List<String>res;
    public List<String> generateParenthesis(int n) {
       List<String> res=new ArrayList<>();
        generate(0,0,n,"",res);
        return res;
    }

    private void generate(int right,int left, int n, String s,List<String> res) {
        //termaintor
        if(left==n &&right==n) {
            res.add(s);
            return;
        }
        //process current logic
        if(left<n){
            String s1=s+"(";

            generate(right,left+1,n,s1,res);
        }
        if(left>right){
            String s2=s+")";

            generate(right+1,left,n,s2,res);
        }
    }
}
