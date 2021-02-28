/**
 * @Author: Andrew Lu
 * @Description: 验证完全平方数
 */
public class ValidPerfectSquare367 {

    /**
     * 二分查找法
     * @param num
     * @return
     */
    public boolean isPerfectSquare1(int num) {
        if (num<=2) {return true;}
        long right=num, left=1, mid=0;
        while (left<=right) {
            mid=left+(right-left)/2;
            if (mid*mid==num) {
                return true;
            }else if (mid*mid>num){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;
    }

    /**
     * 牛顿迭代法
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num<=2) {return true;}
       long x=num/2;
        while(x*x>num) {
            x=(x+num/x)/2;
        }
        return (x*x==num);
    }


}
