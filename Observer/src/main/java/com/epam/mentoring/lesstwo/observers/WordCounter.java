package com.epam.mentoring.lesstwo.observers;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

/**
 * Created by Aliaksandr_Liahushau on 3/4/2017.
 */
public class WordCounter implements Observer {
    final static String[] NON_WORDS = {"a", "an", "of", "the", "by", "with", "to", "from", "in"};

    @Override
    public void update(Observable o, Object arg) {
        final String input = ((String) arg).replaceAll("[,.()\\[\\]]", "");
        final ArrayList<String> content = new ArrayList<String>(Arrays.asList(input.split("\\s")));
        content.removeAll(Arrays.asList(NON_WORDS));

        System.out.println("WORD_COUNTER_OBSERVER: " + content.size());
    }
}
