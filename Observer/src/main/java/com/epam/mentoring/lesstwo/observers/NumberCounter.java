package com.epam.mentoring.lesstwo.observers;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aliaksandr_Liahushau on 3/4/2017.
 */
public class NumberCounter implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        final String input = (String) arg;
        int countNumbers = 0;

        final Pattern pattern = Pattern.compile("-?\\d+");
        final Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            countNumbers++;
        }

        System.out.println("NUMBER_COUNTER: " + countNumbers);
    }
}
