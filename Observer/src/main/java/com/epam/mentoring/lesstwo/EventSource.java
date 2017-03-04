package com.epam.mentoring.lesstwo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Observable;
import java.util.Scanner;

/**
 * Created by Aliaksandr_Liahushau on 3/4/2017.
 */
class EventSource extends Observable implements Runnable {
    public void run() {
        while (true) {
            System.out.println("Enter file path:");
            final String path = new Scanner(System.in).next();
            String content = null;
            try {
                content = new String(Files.readAllBytes(Paths.get(path)), "UTF-8");
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }

            if (content != null) {
                setChanged();
                notifyObservers(content);
            }
        }
    }
}
