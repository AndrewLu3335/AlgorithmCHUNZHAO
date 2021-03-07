import java.util.LinkedList;

/**
 * @Author: Andrew Lu
 * @Description: 最长有效括号
 */
public class LongestValidParentheses32 {

    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int result = 0;
        //数左括号
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            //如果是左括号就让计数器+1
            if (s.charAt(i) == '(') {
                leftCount++;
                //如果当前是 ）并且之前已经有左括号了
            } else if (leftCount > 0){
                //dp[i-1]指的是记录之前有效括号的数量，在这个上面再加2个有效括号
                dp[i] = dp[i - 1] + 2;
                //dp[i - dp[i]]相邻有效括号的计数 ：()() dp数组：0202 最后一个元素目前为2，但是要加上之前的累计的有效括号数
                //i-dp[i]=3-2=1 ;dp[1]==2; 0204
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                result = Math.max(result, dp[i]);
                leftCount--;
            }
        }
        return result;
    }

    /**
     * Stack
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int result = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return result;
    }
}
