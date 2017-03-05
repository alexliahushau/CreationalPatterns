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
    final static String PERSON_JSON = System.getProperty("user.dir") + "/persons.json";
    final List<Person> personsCache = new ArrayList<>(0);

    @Override
    public Person readPerson(String personName) {

        return findPerson(personName)
            .map(this::capitalizeName)
            .orElseGet(() -> {
                updateCache();
                return findPerson(personName)
                    .map(this::capitalizeName)
                    .orElse(null);
            });
    }

    private void updateCache() {
        try {
            final JSONParser parser = new JSONParser();
            final FileReader reader = new FileReader(PERSON_JSON);
            final Object obj = parser.parse(reader);
            final JSONObject jsonObject = (JSONObject) obj;
            final JSONArray personsList = (JSONArray) jsonObject.get("persons");

            personsCache.clear();

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

}
