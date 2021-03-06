package geekbrains.dubovik.java.lesson_3;

import java.util.Map;
import java.util.TreeMap;

public class Champ1 {
    // Task 1.2 - 1 - попробовал Map используя свой класс в объявлении
     static void champions(String[][] allChampions) {
        Map<String, CountOfYears> champNumbers = new TreeMap<>();
            for (int i = 0; i < allChampions[0].length; i++) {
            String team = allChampions[0][i];
            String year = allChampions[1][i];
            CountOfYears years;
            if (!champNumbers.containsKey(team)) {
                years = new CountOfYears(1, year);
            } else {
                years = champNumbers.get(team);
                years.setNumber(years.getNumber() + 1);
                years.setYear(years.getYear() + "/" + year);
            }
            champNumbers.put(team, years);
        }
        for (Map.Entry<String, CountOfYears> team : champNumbers.entrySet()) {
            System.out.println(team.getKey() + " - " + team.getValue().printYears());
        }
    }

    private static class CountOfYears {
        int number;
        String year;

        private CountOfYears(int number, String year) {
            this.number = number;
            this.year = year;
        }

        private int getNumber() {
            return number;
        }

        private void setNumber(int number) {
            this.number = number;
        }

        private String getYear() {
            return year;
        }

        private void setYear(String year) {
            this.year = year;
        }

        private String printYears() {
            return (number + " times: " + year);
        }
    }
}