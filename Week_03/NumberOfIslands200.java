/**
 * @Author: Andrew Lu
 * @Description: 小岛的数量
 */
public class NumberOfIslands200 {
    private int n;
    private int m;
    public int numIslands(char[][] grid) {
        n=grid.length;
        m= grid[0].length;
        if(n==0) {return 0;}
        int count=0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j]=='1') {
                    dfsRemark(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfsRemark(char[][] grid, int i, int j) {
        if (i<0 || j<0 || i>=n || j>=m || (grid[i][j]!='1')) {
            return;
        }
        grid[i][j]='0';
        dfsRemark(grid,i+1,j);
        dfsRemark(grid, i-1, j);
        dfsRemark(grid,i,j+1);
        dfsRemark(grid,i,j-1);
    }
}
