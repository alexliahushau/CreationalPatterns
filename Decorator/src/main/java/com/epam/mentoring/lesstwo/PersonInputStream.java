package com.epam.mentoring.lesstwo;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Aliaksandr_Liahushau on 3/4/2017.
 */
public class PersonInputStream implements ReadPerson {

    List<Person> personsCache = new ArrayList<>(0);

    @Override
    public Person readPerson(String personName) {

        return findPerson(personName)
            .map(p -> capitalizeName(p))
            .orElseGet(() -> {
                updateCache();
                return findPerson(personName)
                    .map(p -> capitalizeName(p))
                    .orElse(null);
            });
    }

    private void updateCache() {
        final JSONParser parser = new JSONParser();

        try {
            final FileReader reader = new FileReader(System.getProperty("user.dir") + "/persons.json");
            final Object obj = parser.parse(reader);
            final JSONObject jsonObject = (JSONObject) obj;
            final JSONArray personsList = (JSONArray) jsonObject.get("persons");

            personsCache = new ArrayList<>(0);

            personsList.forEach(pObj -> {
                JSONObject jsObj = (JSONObject) pObj;
                String pObjName = (String) jsObj.get("name");
                personsCache.add(new Person(pObjName));
            });

            reader.close();
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

    private Person capitalizeName(final Person person) {
        person.setName(StringUtils.capitalize(person.getName()));
        return person;
    }

    public List<Person> getPersonsCache() {
        return personsCache;
    }
}
