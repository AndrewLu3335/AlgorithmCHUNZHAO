/**
 * @Author: Andrew Lu
 * @Description: 位1的个数
 */
public class NumberOf1Bits191 {

    /**
     * 每一位对1做与运算，然后右移
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count=0;
        for (int i=0; i<32; i++ ) {
            if ((n&1)!=0) {
                count++;
            }
            n>>=1;
        }
        return count;
    }
}
