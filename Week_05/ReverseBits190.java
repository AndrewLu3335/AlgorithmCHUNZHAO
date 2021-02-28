/**
 * @Author: Andrew Lu
 * @Description: 颠倒二进制
 */
public class ReverseBits190 {

    /**
     * 位运算
     * 循环32词 每一次循环将ans左移一位之后+ n与1（n最低位）， 最后再把右移1位
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int ans=0;
        for (int i=0; i<32; i++) {
            ans=(ans<<1) +(n&1);
            n>>=1;
        }
        return ans;
    }
}
