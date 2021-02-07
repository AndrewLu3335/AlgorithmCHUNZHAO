/**
 * @Author: Andrew Lu
 * @Description: 平方根
 */
public class SqrtX69 {

    /**
     * 二分查找法
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        if (x==0) {return 0;}
        long left=1L, right=x,mid=1L;
        while (left<=right) {
            mid=left+(right-left)/2;
            if (mid*mid>x) {
                //去左半边查找
                right=mid-1;
            }else{
                //去右半边找
                left=mid+1;
            }
        }
        return (int)right;
    }

    public int mySqrt(int x) {
        long r=x;
        while (r*r>x) {
            r=(r+x/r)/2;
        }
        return (int)r;
    }

}
