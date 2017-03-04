package com.epam.mentoring.lesstwo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Aliaksandr_Liahushau on 3/4/2017.
 */
public class ProxyPerson implements PersonDAO {

    List<Person> personsCache = new ArrayList<>(0);

    @Override
    public Person readPerson(String personName) {

        return findPerson(personName)
            .map(p -> p)
            .orElseGet(() -> {
                updateCache();
                return findPerson(personName)
                    .map(p -> p)
                    .orElse(null);
            });
    }

    private void updateCache() {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + "/persons.txt"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray personsList = (JSONArray) jsonObject.get("persons");

            personsCache = new ArrayList<>(0);

            personsList.forEach(pObj -> {
                JSONObject jsObj = (JSONObject) pObj;
                String pObjName = (String) jsObj.get("name");
                personsCache.add(new Person(pObjName));
            });

            System.out.println("***** Cache updated *****");

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    private Optional<Person> findPerson(String name) {
        return personsCache.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
    }
}
