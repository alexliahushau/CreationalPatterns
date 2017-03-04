package com.epam.mentoring.lesstwo;

import java.util.Scanner;

/**
 * Created by Aliaksandr_Liahushau on 3/3/2017.
 */
public class App {
    public static void main(String[] args) {

        final ProxyPerson proxy = new ProxyPerson();

        while (true) {
            System.out.println("Enter person name:");
            final String name = new Scanner(System.in).next();
            final Person person = proxy.readPerson(name);

            if (person != null) {
                System.out.println(person);
            } else {
                System.out.println("No one person found with name : " + name);
            }

        }
    }
}
