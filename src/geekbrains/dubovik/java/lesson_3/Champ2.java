package geekbrains.dubovik.java.lesson_3;

import java.util.*;

public class Champ2 {
    // Task 1.2 - 2 - упростил, хотя вывод в консоль красивее с классом
    static void champions(String[][] allChampions) {
        Map<String, TreeSet<String>> champNumbers = new TreeMap<>();
        for (int i = 0; i < allChampions[0].length; i++) {
            String team = allChampions[0][i];
            String year = allChampions[1][i];
            TreeSet<String> years;
            if (!champNumbers.containsKey(team)) years = new TreeSet<>();
            else years = champNumbers.get(team);
            years.add(year);
            champNumbers.put(team, years);
        }

        for (Map.Entry<String, TreeSet<String>> entry : champNumbers.entrySet()) {
            int num = entry.getValue().size();
            System.out.println(entry.getKey() + " - " + num + " times: " + entry.getValue());
        }
    }
}