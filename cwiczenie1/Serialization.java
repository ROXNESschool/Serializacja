package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;

public class Serialization {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        Student student = new Student(
                "Jan Kowalski",
                22,
                "Informatyka",
                Arrays.asList("Programowanie", "Gry", "Filmy")
        );

        String json = mapper.writeValueAsString(student);

        System.out.println("JSON:");
        System.out.println(json);

    }
}
