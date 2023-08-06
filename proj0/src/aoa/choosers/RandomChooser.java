package aoa.choosers;

import edu.princeton.cs.algs4.StdRandom;
import aoa.utils.FileUtils;

import java.util.List;

public class RandomChooser implements Chooser {
    private final String chosenWord;
    private String pattern;

    public RandomChooser(int wordLength, String dictionaryFile) {
        // TODO: Fill in/change this constructor.

        if(wordLength<1){
            throw new IllegalArgumentException();
        }

        List<String> words=FileUtils.readWordsOfLength(dictionaryFile,wordLength);
        if(words.size()==0){
            throw new IllegalStateException();
        }
        int numWords=words.size();
        int randomlyChosenWordNumber=StdRandom.uniform(numWords);
        String word=words.get(randomlyChosenWordNumber);

        chosenWord = word;
        String newPattern="";
        for(int i=0;i<wordLength;i++){
            newPattern+='-';
        }
        pattern=newPattern;
    }

    @Override
    public int makeGuess(char letter) {
        // TODO: Fill in this method.
        int count=0;
        int wordLength=chosenWord.length();
        String pat="";

        for(int i=0;i<wordLength;i++){
            if(chosenWord.charAt(i)==letter){
                count++;
                pat+=letter;
            }
            else{
                pat+=pattern.charAt(i);
            }
        }
        pattern=pat;


        return count;
    }

    @Override
    public String getPattern() {
        // TODO: Fill in this method.
        return this.pattern;
    }

    @Override
    public String getWord() {
        // TODO: Fill in this method.
        return this.chosenWord;
    }
}
