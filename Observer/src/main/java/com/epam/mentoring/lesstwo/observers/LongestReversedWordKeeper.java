package com.epam.mentoring.lesstwo.observers;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Created by Aliaksandr_Liahushau on 3/4/2017.
 */
public class LongestReversedWordKeeper implements Observer {
    String lastLongestReversedWord = StringUtils.EMPTY;

    @Override
    public void update(Observable o, Object arg) {
        final String input = ((String) arg).replaceAll("[,.()\\[\\]]", "");
        Arrays.asList(input.split("\\s")).stream()
            .max(Comparator.comparing( s -> s.length()))
            .ifPresent(currentLongestWord -> {
                if (this.lastLongestReversedWord.length() < currentLongestWord.length()) {
                    this.lastLongestReversedWord = StringUtils.reverse(currentLongestWord);
                    System.out.println("LONGEST_REVERSED_WORD_KEEPER: " + this.lastLongestReversedWord);
                }
            });
    }

    public String getLastLongestReversedWord() {
        return this.lastLongestReversedWord;
    }
}
