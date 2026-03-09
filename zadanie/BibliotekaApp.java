package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BibliotekaApp {

    public static void main(String[] args) {

        try {

            ObjectMapper mapper = new ObjectMapper();

            List<Ksiazka> ksiazki = new ArrayList<>();

            ksiazki.add(new Ksiazka("Wiedzmin", "Andrzej Sapkowski", 1993, true));
            ksiazki.add(new Ksiazka("Pan Tadeusz", "Adam Mickiewicz", 1834, false));
            ksiazki.add(new Ksiazka("Lalka", "Boleslaw Prus", 1890, true));

            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File("biblioteka.json"), ksiazki);

            System.out.println("Zapisano biblioteka.json");

            List<Ksiazka> wczytane =
                    mapper.readValue(
                            new File("biblioteka.json"),
                            new TypeReference<>() {
                            }
                    );

            System.out.println("\nDostępne książki:");

            for (Ksiazka k : wczytane) {
                if (k.isDostepna()) {
                    System.out.println(
                            k.getTytul() + " - " +
                                    k.getAutor() + " (" +
                                    k.getRokWydania() + ")"
                    );
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
