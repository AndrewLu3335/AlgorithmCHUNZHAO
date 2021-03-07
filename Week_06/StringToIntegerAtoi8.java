/**
 * @Author: Andrew Lu
 * @Description: 字符串转换整数 (atoi)
 */
public class StringToIntegerAtoi8 {

    public int myAtoi(String str) {
        //index：索引指向当前要处理的字符  sign：正负符号/默认为正好 total：总计
        int index = 0, sign = 1, total = 0;
        //判空字符串
        if(str.length() == 0) return 0;

        //碰到空格就index向后移
        while(str.charAt(index) == ' ' && index < str.length()-1)
            index ++;

        //处理正负号，记录到sign上
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //处理数字
        while(index < str.length()){
            //得到字符对应的整形
            int digit = str.charAt(index) - '0';
            //判断转换下来的整形的合法性
            if(digit < 0 || digit > 9) break;

            //检查是不是符合题目中的上下限要求
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }
}
