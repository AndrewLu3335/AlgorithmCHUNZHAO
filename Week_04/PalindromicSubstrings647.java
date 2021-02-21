/**
 * @Author: Andrew Lu
 * @Description: 回文子串
 */
public class PalindromicSubstrings647 {

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                //举例： 1）aa 两个字符 并且相等
                //      2）acaca 当cac为回文串， 两边加个相等的字符之后的也是回文串
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
