package com.epam.mentoring.lesstwo;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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


    @Override
    public void writePerson(Person person) {

        person.setName(StringUtils.capitalize(person.getName()));

        final PersonInputStream pis = new PersonInputStream();
        pis.readPerson("");

        final List<Person> persons = pis.getPersonsCache();
        persons.add(person);

        final JSONObject obj = new JSONObject();
        obj.put("persons", persons);

        try(FileWriter file = new FileWriter(System.getProperty("user.dir") + "/persons.json")) {
            file.write(obj.toJSONString());
            file.flush();
            file.close();
            System.out.println("Successfully add Person to persons.json");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
