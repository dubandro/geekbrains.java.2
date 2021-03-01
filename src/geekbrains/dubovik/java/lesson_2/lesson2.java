package geekbrains.dubovik.java.lesson_2;

import java.util.Arrays;

public class lesson2 {
    public static void main(String[] args) {
        final int SIZE = 4;

        String[][] array1 = new String[][] {
                {"11", "12", "13", "14"},
                {"21", "22", "23", "24"},
                {"31", "32", "33", "34"},
                {"41", "42", "43", "44"},
                {"51"}
        };

        String[][] array2 = new String[][] {
                {"11", "12", "13", "14", "15"},
                {"21", "22", "23", "24"},
                {"31", "32", "33", "34"},
                {"41", "42", "43", "44"}
        };

        String[][] array3 = new String[][] {
                {"11", "12", "13", "14"},
                {"21", "22", "23", "24"},
                {"31", "32", "ЗЗ", "34"}, // Русские буквы ЗЗ вместо цифр 33
                {"41", "42", "43", "44"}
        };

        String[][] array4 = new String[][] {
                {"11", "12", "13", "14"},
                {"21", "22", "23", "24"},
                {"31", "32", "33", "34"},
                {"41", "42", "43", "44"}
        };

        for (String[][] arrays : Arrays.asList(array1, array2, array3, array4)) {
            try {
                CheckArray.chekAndSumArray(arrays, SIZE);
            }
            catch (Exception exArr) {
                System.out.println(exArr.getMessage());
            }
        }
    }
}
