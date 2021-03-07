/**
 * @Author: Andrew Lu
 * @Description: 解码
 */
public class DecodeWays91 {

    /**
     * 动态规划
     * @param s
     * @return
     */
    public int numDecodings1(String s) {
        int n = s.length();
        //判空
        if(n == 0) return 0;
        //存放有多少种情况
        int[] dp = new int[n + 1];
        //0个数只有一种情况
        dp[0] = 1;
        //如果第一个字符为'0'则无法编译返回0，如果不是0则返回1
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 1; i < n; i++){

            if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <'7'){
                //如果是20、10，只有一种情况
                if(s.charAt(i) == '0') dp[i + 1] = dp[i - 1];
                    //如果是11-19、21-26
                else dp[i + 1] = dp[i] + dp[i - 1];
            }else if(s.charAt(i) == '0'){
                //如果是0、30、40、50
                return 0;
            }else{
                //i-1和i无法构成一个字母
                dp[i + 1] = dp[i];
            }
        }
        return dp[n];
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
