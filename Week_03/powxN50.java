import com.sun.tools.corba.se.idl.constExpr.Divide;

import java.lang.reflect.Proxy;

/**
 * @Author: Andrew Lu
 * @Description: Pow(x, n)
 */


public class powxN50 {
    /**
     * 分治思路
     * 2^10=2^5*2^5=2^2*2^2*2
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
       return n>0?getMul(x,n) : 1.0/getMul(x,-n);
    }
    private double getMul(double x, int n) {
        if(n==0) {
            return 1.0;
        }
        double y=getMul(x,n/2);
        return n%2==0? y*y : y*y*x;
    }

}
