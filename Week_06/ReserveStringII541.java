/**
 * @Author: Andrew Lu
 * @Description: 反转字符串
 */
public class ReserveStringII541 {

    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        //2k的倍数
        for (int start = 0; start < a.length; start += 2 * k) {
            //i指向每一个单位的头， j指向每一个单位的尾
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }
}
