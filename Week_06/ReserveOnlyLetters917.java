/**
 * @Author: Andrew Lu
 * @Description:
 */
public class ReserveOnlyLetters917 {


    public String reverseOnlyLetters(String S) {
        int i=0, j=S.length()-1;
        char [] chs=S.toCharArray();
        while (i<j) {
            char font=S.charAt(i);
            char behind=S.charAt(j);
            if ( Character.isLetter(font) && Character.isLetter(behind)) {
                char temp=chs[i]; chs[i]=chs[j]; chs[j]= temp;
                i++;j--;
            }else{
                if (!Character.isLetter(font)) {
                    i++;
                }else{
                    j--;
                }
            }
        }
        return String.valueOf(chs);
    }
}
