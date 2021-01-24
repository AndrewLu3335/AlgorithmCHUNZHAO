/**
 * @Author: Andrew Lu
 * @Description: 加一
 */
public class plusOne66 {
    /**
     * 自己借鉴989号题的思路
     * O(N)
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int k=1;
        for (int i=digits.length-1;i>=0; i--) {
            int oldVal= digits[i];
            digits[i]=(digits[i]+k)%10;
            k=(oldVal+k)/10;
            if(digits[i]!=0){ return digits; }
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }

    /**
     * O(N)
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        for (int i=digits.length-1;i>=0; i--) {
            digits[i]++;
            digits[i]=digits[i]%10;
            if(digits[i]!=0){return digits; }
        }
        digits=new int[digits.length+1];
        digits[0]=1;
        return digits;
    }
}
