/**
 * @Author: Andrew Lu
 * @Description: 扫雷
 */
public class SaoLei529 {
    /**
     *  当前点四周的八个方位的x坐标
     */
    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};


    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            // 挖到地雷游戏结束
            board[x][y] = 'X';
        } else{
            //还没挖到雷区
            dfs(board, x, y);
        }
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        int bombCount = 0;
        //查看四周八个方框内有几个炸弹
        for (int i = 0; i < 8; ++i) {
            int tx = x + dirX[i];
            int ty = y + dirY[i];
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                continue;
            }
            // 不用判断 M，因为如果有 M 的话游戏已经结束了
            if (board[tx][ty] == 'M') {
                ++bombCount;
            }
        }

        //有炸弹的情况
        if (bombCount > 0) {
            //四周八个格子中有炸弹并且显示炸弹数量
            board[x][y] = (char) (bombCount + '0');
        } else {
            // 四周八个格子没有炸弹 标记四周格子为B没有空白
            board[x][y] = 'B';
            for (int i = 0; i < 8; ++i) {
                int tx = x + dirX[i];
                int ty = y + dirY[i];
                // 这里不需要在存在 B 的时候继续扩展，因为 B 之前被点击的时候已经被扩展过了
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E') {
                    continue;
                }
                dfs(board, tx, ty);
            }
        }
    }
}
