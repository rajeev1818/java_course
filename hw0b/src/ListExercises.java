import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int ans=0;
        for(int num:L){
            ans+=num;
        }

        return ans;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer>ans=new ArrayList<>();

        for(int num:L){
            if(num%2==0){
                ans.add(num);
            }
        }
        return ans;


    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> ans=new ArrayList<>();
        Set<Integer>s =new HashSet<>();

        for(int num:L1) {
            s.add(num);
        }
        for(int num:L2){
            if(s.contains(num)){
                ans.add(num);
            }
        }



        return ans;


    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int count=0;

        for(String str:words){
            int len=str.length();
            for(int i=0;i<len;i++){
                if(str.charAt(i)==c){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
