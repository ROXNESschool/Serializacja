package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Deserialization {

    public static void main(String[] args) throws Exception {

        String json = """
        {
          "imie":"Anna",
          "wiek":21,
          "kierunek":"Matematyka",
          "hobby":["Czytanie","Szachy"]
        }
        """;

        ObjectMapper mapper = new ObjectMapper();

        Student student = mapper.readValue(json, Student.class);

        System.out.println(student.getImie());
    }
}