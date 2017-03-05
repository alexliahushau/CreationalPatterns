package com.epam.mentoring.lesstwo;

import java.util.Scanner;

/**
 * Created by Aliaksandr_Liahushau on 3/3/2017.
 */
public class App {
    public static void main(String[] args) {
        final PersonInputStream readDecorator = new PersonInputStream();
        final PersonOutputStream writeDecorator = new PersonOutputStream();

        while (true) {
            System.out.println("Enter action:");
            System.out.println("    1 - read person");
            System.out.println("    2 - write person");
            System.out.println("    3 - exit");

            int action = 0;

            try {
                action = Integer.parseInt(new Scanner(System.in).next());
            } catch (NumberFormatException e) {
                System.out.println("please enter correct number");
            }

            switch (action) {
                case 0 :
                    break;
                case 1 :
                    System.out.println("Enter name:");
                    final String name = new Scanner(System.in).next();
                    final Person person = readDecorator.readPerson(name);
                    if (person != null) {
                        System.out.println(person);
                    } else {
                        System.out.println("No one person found with name : " + name);
                    }
                    break;
                case 2 :
                    System.out.println("Enter name:");
                    writeDecorator.writePerson(new Person(new Scanner(System.in).next()));
                    break;
                case 3 :
                    System.exit(0);
                    break;
            }
        }
    }
}
