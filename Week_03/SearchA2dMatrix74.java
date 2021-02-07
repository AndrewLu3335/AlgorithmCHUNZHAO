/**
 * @Author: Andrew Lu
 * @Description: 搜索二维矩阵
 */
public class SearchA2dMatrix74 {
    /**
     *
     *      1   3   5   7
     *      10  11  16  20
     *      23  30  34  60
     *
     *二分查找法 将二维数组转化为一维数组
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        //行数
        int row = matrix.length;
        //列数
        int col = matrix[0].length;
        int left = 0;
        //行数乘列数 - 1，右指针
        int right = row * col - 1;
        while (left <= right) {
            int mid = left+ ((right-left) >> 1);
            //将一维坐标变为二维坐标
            int rownum = mid / col;
            int colnum = mid % col;
            if (matrix[rownum][colnum] == target) {
                return true;
            } else if (matrix[rownum][colnum] > target) {
                right = mid - 1;
            } else if (matrix[rownum][colnum] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}
