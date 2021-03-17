package geekbrains.dubovik.java.lesson_3;

import java.util.*;

public class lesson3 {
    public static void main(String[] args) {

        String[][] allChampions = new String[][]{
                {"Ferrari", "Ferrari", "Ferrari", "Ferrari", "Ferrari", "Renault", "Renault", "Ferrari", "Ferrari",
                        "Brawn-Mercedes", "Red Bull", "Red Bull", "Red Bull", "Red Bull", "Mercedes", "Mercedes",
                        "Mercedes", "Mercedes", "Mercedes", "Mercedes", "Mercedes"},
                {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009",
                        "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}
        };

        System.out.println("Task 1");
        Words.task1Method1(allChampions);
        Words.task1Method2(allChampions);
        Words.task2Method1(allChampions);

        System.out.println("\nTask 1* (for understanding)");
        Champ1.champions(allChampions);
        Champ2.champions(allChampions);

        System.out.println("\nTask 2");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Subscriber1", "PhoneNumber11");
        phoneBook.add("Subscriber2", "PhoneNumber21");
        phoneBook.add("Subscriber3", "PhoneNumber31");
        phoneBook.add("Subscriber4", "PhoneNumber41");
        phoneBook.add("Subscriber1", "PhoneNumber12");
        phoneBook.add("Subscriber1", "PhoneNumber13");
        phoneBook.add("Subscriber2", "PhoneNumber22");
        phoneBook.add("Subscriber3", "PhoneNumber32");
        phoneBook.print();
        phoneBook.get("Subscriber1");
        phoneBook.get("Subscriber5");
    }
}