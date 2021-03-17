package geekbrains.dubovik.java.lesson_3;

import java.util.*;

public class Words {
    // Task 1.1 - 1
    static void task1Method1(String[][] allChampions) {
        HashSet<String> champions = new HashSet<>();
        Collections.addAll(champions, allChampions[0]);
        System.out.println(champions);
    }
    // Task 1.1 - 2
    static void task1Method2(String[][] allChampions) {
        TreeSet<String> champions2 = new TreeSet<>(Arrays.asList(allChampions[0]));
        System.out.println(champions2);
    }
    // Task 1.2
    static void task2Method1(String[][] allChampions) {
        Map<String, Integer> champNumbers = new HashMap<>();
        for (String team : allChampions[0]) {
            //вариант if/тернарный
            /*Integer times = champNumbers.get(team);
            champNumbers.put(team, times == null? 1 : times + 1);*/
            //такая же логика в merge
            champNumbers.merge(team, 1, Integer::sum);
        }
        System.out.println(champNumbers);
    }
}