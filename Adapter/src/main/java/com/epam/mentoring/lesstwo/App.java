package com.epam.mentoring.lesstwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Aliaksandr_Liahushau on 3/3/2017.
 */
public class App {
    public static void main(String[] args) {

        String[] temp = {"lesha", "sasha", "marina", "peter"};

        ListAdapter<String> list = new ListAdapter<>(0);

        list.addAll(Arrays.asList(temp));

        System.out.println("Init array:");
        System.out.println("[");

        list.forEach(s -> System.out.println(s));

        System.out.println("]");
        System.out.println(" ");

        System.out.println("Append to array: {last}");
        System.out.println("[");

        list.push("last");
        list.forEach(s -> System.out.println(s));

        System.out.println("]");
        System.out.println(" ");

        System.out.println("Pull last object");
        System.out.println("[");

        list.pop();
        list.forEach(s -> System.out.println(s));

        System.out.println("]");
        System.out.println("");

    }
}
