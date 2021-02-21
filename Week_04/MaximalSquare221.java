/**
 * @Author: Andrew Lu
 * @Description: 最大正方形
 */
public class MaximalSquare221 {
    /**
     * 动态规划
     * 二维存储空间
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    //如果为（0，0）则直接标记1
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        //确保左边，上面，左上角都为1
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return  maxSide * maxSide;
    }

    /**
     * 动态规划
     * 一维存储空间
     * @param matrix
     * @return
     */
    public int maximalSquare1(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        int[] dp = new int[width + 1];

        for (char[] chars : matrix) {
            //左上格
            int upLeft = 0; 
            for (int col = 0; col < width; col++) {
                //当前格子的左上格
                int nextUpLeft = dp[col + 1];

                if (chars[col] == '1') {
                    //确保周边格子都为1不为0
                    dp[col + 1] = Math.min(Math.min(dp[col], dp[col + 1]), upLeft) + 1;
                    maxSide = Math.max(maxSide, dp[col + 1]);
                } else dp[col + 1] = 0;
                upLeft = nextUpLeft;
            }
        }
        //返回正方形的面积
        return maxSide * maxSide;
    }
}
