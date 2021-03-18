package geekbrains.dubovik.java.lesson_3;

import java.util.*;

public class PhoneBook {
    private final Map<String, Set<String>> phoneBook = new TreeMap<>();

    public void add(String surname, String phoneNumber) {
        Set<String> phoneNumbers;
        if (!phoneBook.containsKey(surname)) phoneNumbers = new TreeSet<>();
        else phoneNumbers = phoneBook.get(surname);
        phoneNumbers.add(phoneNumber);
        phoneBook.put(surname, phoneNumbers);
    }

    public void print() {
        phoneBook.entrySet().forEach(System.out::println);
    }

    public void get(String surname) {
        if (phoneBook.containsKey(surname)) System.out.println(surname + " - " + phoneBook.get(surname));
        else System.out.println(surname + " - No such subscriber exists");
    }
}
