package aoa.guessers;

import aoa.utils.FileUtils;
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PatternAwareLetterFreqGuesser implements Guesser {
    private final List<String> words;

    public PatternAwareLetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
    }

    public List<String> keepOnlyWordsThatMatchesPattern(String pattern){
        List<String>ans= new ArrayList<>();
        int patlen= pattern.length();
        for(String word:words){
            int wordlen=word.length();
            if(patlen!=wordlen){
                continue;
            }
            else{
                boolean flag=false;
                for(int i=0;i<wordlen;i++){
                    if(pattern.charAt(i)=='-'){
                        continue;
                    }
                    else if(pattern.charAt(i)!=word.charAt(i)) {
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    ans.add(word);
                }
            }
        }


        return ans;
    }
    public Map<Character, Integer> getFrequencyMap(List<String>match) {
        // TODO: Fill in this method.
        Map<Character,Integer> ans= new TreeMap<>();
        for(String word:match){
            int len=word.length();
            for(int i=0;i<len;i++){
                if(ans.containsKey(word.charAt(i))){
                    ans.replace(word.charAt(i),ans.get(word.charAt(i))+1);
                }
                else{
                    ans.put(word.charAt(i),1);
                }
            }
        }


        return ans;


    }


    @Override
    /** Returns the most common letter in the set of valid words based on the current
     *  PATTERN. */



    public char getGuess(String pattern, List<Character> guesses) {
        List<String> patternMatchedWords=keepOnlyWordsThatMatchesPattern(pattern);
        Map<Character,Integer>mp= getFrequencyMap(patternMatchedWords);
        int maxi=0;
        char ans='?';

        for(Character ch:mp.keySet()){
            if(guesses.contains(ch)){
                continue;
            }
            else{
                if(mp.get(ch)>maxi){
                    maxi=mp.get(ch);
                    ans=ch;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PatternAwareLetterFreqGuesser palfg = new PatternAwareLetterFreqGuesser("data/example.txt");
        System.out.println(palfg.getGuess("-e--", List.of('e')));
    }
}