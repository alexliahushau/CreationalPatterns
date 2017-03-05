package com.epam.mentoring.lesstwo;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.Closeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Aliaksandr_Liahushau on 3/4/2017.
 */
public class PersonOutputStream implements WritePerson {
    final static String PERSON_JSON = System.getProperty("user.dir") + "/persons.json";
    final static String PERSONS = "persons";

    @Override
    public void writePerson(Person person) {

        person.setName(StringUtils.capitalize(person.getName()));

        JSONArray personsList = new JSONArray();

        try (FileReader reader = new FileReader(PERSON_JSON)) {
            final JSONParser parser = new JSONParser();
            final JSONObject jsonObject = (JSONObject) parser.parse(reader);
            personsList = (JSONArray) jsonObject.get(PERSONS);
        } catch (IOException e) {
            System.out.println("persons.json does not exist");
            System.out.println("Creating new persons.json");
        } catch (ParseException e) {
            System.out.println("persons.json is empty");
        }

        if (personsList.contains(person.toString())) {
            System.out.println("Persons with name " + person.getName() + " already exists");
            return;
        }

        try (FileWriter writer = new FileWriter(PERSON_JSON)) {
            final JSONObject personsJSON = new JSONObject();

            personsList.add(person.toString());
            personsJSON.put(PERSONS, personsList);

            writer.write(personsJSON.toJSONString());

            System.out.println("Successfully add Person to persons.json");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
