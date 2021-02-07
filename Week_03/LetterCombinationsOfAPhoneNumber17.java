import java.util.*;

/**
 * @Author: Andrew Lu
 * @Description: 电话号码的字母组合
 */
public class LetterCombinationsOfAPhoneNumber17 {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqr");
        map.put('8',"stu");
        map.put('9',"wxyz");
        List<String> res=new ArrayList<>();
        recursion(res,"",0,map,digits);
        return res;
    }
    private void recursion(List<String> res,String temp, int index,Map<Character,String> map,String digest) {
        if (index==digest.length()) {
            res.add(temp);
            return;
        }
        String letter=map.get(digest.charAt(index));
        for (int i=0; i<letter.length(); i++) {
            recursion(res,temp+letter,index+1,map,digest);
        }
    }


    public List<String> letterCombinations2(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if(digits.isEmpty()) {
            return ans;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray()) {
                    ans.add(t+s);
                }
            }
        }
        return ans;
    }

}
