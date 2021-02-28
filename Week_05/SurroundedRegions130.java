/**
 * @Author: Andrew Lu
 * @Description: 被围绕的区域
 */
public class SurroundedRegions130 {
    /**
     * 从边界往x衍生，如果遇到x就结束，并把这些边界或者在x包围圈的外边界的格子定义为'#'之后方便修改为'O';
     * @param board
     */
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        for (int i=0;i<n; i++) {
            for (int j=0; j<m; j++) {
                //从边界开始
                boolean isEdge=i==0|| j==0||j==m-1 || i==n-1;
                if (isEdge && board[i][j]=='O') {
                    dfs(board,i,j);
                }
            }
        }
        for (int i=0;i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j]=='O') {
                   board[i][j]='X';
                }
                if (board[i][j]=='#') {
                    board[i][j]='O';
                }
            }
        }
    }

    //从边界开始衍生出去周围四个，遇到原先为x或者为'#'已经访问过的就这条路结束
    private void dfs(char[][] board, int i, int j) {
        if (i<0 || j<0|| i>= board.length || j>= board[0].length || board[i][j]=='X' || board[i][j]=='#' ) {
            return;
        }
        board[i][j]='#';
        dfs(board,i+1,j);
        dfs(board,i,j+1);
        dfs(board,i-1,j);
        dfs(board,i,j-1);
    }





    class UnionFind {
        int[] parents;

        public UnionFind(int totalNodes) {
            parents = new int[totalNodes];
            for (int i = 0; i < totalNodes; i++) {
                parents[i] = i;
            }
        }
        // 合并连通区域是通过find来操作的, 即看这两个节点是不是在一个连通区域内.
        void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 != root2) {
                parents[root2] = root1;
            }
        }

        int find(int node) {
            while (parents[node] != node) {
                // 当前节点的父节点 指向父节点的父节点.
                // 保证一个连通区域最终的parents只有一个.
                parents[node] = parents[parents[node]];
                node = parents[node];
            }

            return node;
        }

        boolean isConnected(int node1, int node2) {
            return find(node1) == find(node2);
        }
    }

    /**
     * 并查集
     * @param board
     */
//    public void solve2(char[][] board) {
//        if (board == null || board.length == 0)
//            return;
//
//        int rows = board.length;
//        int cols = board[0].length;
//
//        // 用一个虚拟节点, 边界上的O 的父节点都是这个虚拟节点
//        UnionFind uf = new UnionFind(rows * cols + 1);
//        int dummyNode = rows * cols;
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (board[i][j] == 'O') {
//                    // 遇到O进行并查集操作合并
//                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
//                        // 边界上的O,把它和dummyNode 合并成一个连通区域.
//                        uf.union(node(i, j), dummyNode);
//                    } else {
//                        // 和上下左右合并成一个连通区域.
//                        if (i > 0 && board[i - 1][j] == 'O')
//                            uf.union(node(i, j), node(i - 1, j));
//                        if (i < rows - 1 && board[i + 1][j] == 'O')
//                            uf.union(node(i, j), node(i + 1, j));
//                        if (j > 0 && board[i][j - 1] == 'O')
//                            uf.union(node(i, j), node(i, j - 1));
//                        if (j < cols - 1 && board[i][j + 1] == 'O')
//                            uf.union(node(i, j), node(i, j + 1));
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (uf.isConnected(node(i, j), dummyNode)) {
//                    // 和dummyNode 在一个连通区域的,那么就是O；
//                    board[i][j] = 'O';
//                } else {
//                    board[i][j] = 'X';
//                }
//            }
//        }
//    }

//    int node(int i, int j) {
//        return i * cols + j;
//    }


}
