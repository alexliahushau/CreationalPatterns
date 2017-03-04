package com.epam.mentoring.lesstwo;

import com.epam.mentoring.lesstwo.observers.LongestReversedWordKeeper;
import com.epam.mentoring.lesstwo.observers.NumberCounter;
import com.epam.mentoring.lesstwo.observers.WordCounter;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Aliaksandr_Liahushau on 3/3/2017.
 */
public class App {
    public static void main(String[] args) {
        final EventSource eventSource = new EventSource();

        eventSource.addObserver(new WordCounter());
        eventSource.addObserver(new NumberCounter());
        eventSource.addObserver(new LongestReversedWordKeeper());

        new Thread(eventSource).start();
    }
}
