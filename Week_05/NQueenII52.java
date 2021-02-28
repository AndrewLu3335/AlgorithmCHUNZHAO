/**
 * @Author: Andrew Lu
 * @Description: N皇后II
 */
public class NQueenII52 {
    private int size;
    private int count;


    public int totalNQueens(int n) {
        count=0;
        //n为几二进制就有多少个1
        size=(1<<n)-1;
        solve(0,0,0);
        return count;
    }

    private void solve(int row, int ld, int rd) {
        if (row==size) {
            count++;
            return;
        }
        /**
         * 1. row|ld|rd 所有横，撇，捺 能攻击到的范围都为1，可放/安全的位置为0
         * 2. ~(row|ld|rd)取反，所有可放的位置都为1
         * 3. size&(~(row|ld|rd)) 将当前剩余的位置 与上 可放的位置，得出来的1为当前可放的位置（排除了之前放过的位置）
         */
        int pos=size&(~(row|ld|rd));
        while(pos!=0) {
            //p为pos最低位1的位置
            int p=pos&(-pos);
            //把皇后放置到最低位1的位置
            pos-=p;

            //ld 左下角斜着 左移是下一行的左边一位 所以要左移一位
            //rd 右下角，下一行的右边位置也是为1 所以要>>1
            solve(row|p,(ld|p)<<1,(rd|p)>>1);
        }
    }
}
