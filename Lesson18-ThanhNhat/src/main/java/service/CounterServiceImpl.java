/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
public class CounterServiceImpl implements CounterService {

    @Override
    public String countWords(String input) {
        return Long.toString(Pattern.compile("[\\s]+").splitAsStream(input).count());
    }

    @Override
    public String countWordsAndFrequency(String input) {
        List<Word> wordsList = new ArrayList<>();
        String[] wordsArray = input.split("\\s+");
        for (String w : wordsArray) {
            Word word = new Word(w);
            if (!wordsList.contains(word)) {
                wordsList.add(word);
            } else {
                wordsList.get(wordsList.indexOf(word)).fre++;
            }
        }
        String result = "";
        for (int i = 0; i < wordsList.size(); i++) {
            result += wordsList.get(i).toString() + "\n";
        }
        return result;
    }

    public static String lowerCase(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                newStr += (char) (str.charAt(i) + 32);
            } else {
                newStr += (char) str.charAt(i);
            }
        }
        return newStr;
    }

}

class Word {

    String content;
    int fre;

    public Word(String content) {
        this.content = content;
        this.fre = 1;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content + ": " + fre + " lần";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !(o instanceof Word)) {
            return false;
        }
        Word a = (Word) o;
        return a.getContent().equals(getContent());
    }

}
