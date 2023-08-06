package aoa.guessers;

import aoa.utils.FileUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NaiveLetterFreqGuesser implements Guesser {
    private final List<String> words;

    public NaiveLetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
    }

    @Override
    /** Makes a guess which ignores the given pattern. */
    public char getGuess(String pattern, List<Character> guesses) {
        return getGuess(guesses);
    }

    /** Returns a map from a given letter to its frequency across all words.
     *  This task is similar to something you did in hw0b! */
    public Map<Character, Integer> getFrequencyMap() {
        // TODO: Fill in this method.
        Map<Character,Integer> ans= new TreeMap<>();
        for(String word:words){
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

    /** Returns the most common letter in WORDS that has not yet been guessed
     *  (and therefore isn't present in GUESSES). */
    public char getGuess(List<Character> guesses) {
        // TODO: Fill in this method.
        int maxi=0;
        char ans='?';
        Map<Character,Integer>mp=getFrequencyMap();


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
        NaiveLetterFreqGuesser nlfg = new NaiveLetterFreqGuesser("data/example.txt");
        System.out.println("list of words: " + nlfg.words);
        System.out.println("frequency map: " + nlfg.getFrequencyMap());

        List<Character> guesses = List.of('e', 'l');
        System.out.println("guess: " + nlfg.getGuess(guesses));
    }
}
