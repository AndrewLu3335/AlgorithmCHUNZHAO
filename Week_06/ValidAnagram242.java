
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author: Andrew Lu
 * @Description: 有效的字母异位词
 */
public class ValidAnagram242 {
    /**
     * O(N)
     * hashmap->record used times of each character (String s)
     * ->same Character used? usedTimes-- (String t)
     * -> see if values in the map are 0? true : false .
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if(s==null || t==null ){return false;}
        Map<Character,Integer> map=new HashMap<>();
        char [] chars=s.toCharArray();
        for (char c: s.toCharArray()) {
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        for ( char c:t.toCharArray()) {
            if(map.containsKey(c)){
                if(map.get(c)>0){
                    map.put(c,map.get(c)-1);
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        for (Character  c : map.keySet()) {
            if(map.get(c)!=0){
                return false;
            }
        }
        return true;
    }

    /**
     * O(n log(n))
     * sort->  isAnagram: same string
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        char [] charS=s.toCharArray();
        char[] charT=t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        return Arrays.equals(charS,charT);
    }
}
