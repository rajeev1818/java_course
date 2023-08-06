
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        Map<Character,Integer>ans=new TreeMap<>();
        ans.put('a',1);
        ans.put('b',2);
        ans.put('c',3);
        ans.put('d',4);
        ans.put('e',5);
        ans.put('f',6);
        ans.put('g',7);
        ans.put('h',8);
        ans.put('i',9);
        ans.put('j',10);
        ans.put('k',11);
        ans.put('l',12);
        ans.put('m',13);
        ans.put('n',14);
        ans.put('o',15);
        ans.put('p',16);
        ans.put('q',17);
        ans.put('r',18);
        ans.put('s',19);
        ans.put('t',20);
        ans.put('u',21);
        ans.put('v',22);
        ans.put('w',23);
        ans.put('x',24);
        ans.put('y',25);
        ans.put('z',26);

        return ans;

    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        Map<Integer,Integer> m=new TreeMap<>();

        for(int num:nums){
            m.put(num,num*num);
        }
        return m;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String,Integer>ans=new TreeMap<>();

        for(String str:words){
            if(ans.containsKey(str)){
                ans.replace(str,ans.get(str)+1);
            }
            else{
                ans.put(str,1);
            }
        }
        return ans;

    }
}
