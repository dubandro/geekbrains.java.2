package geekbrains.dubovik.java.lesson_2;

import java.util.Arrays;

public class CheckArray {

    public static void chekAndSumArray (String[][] arr, int arrSize) {
        int sum = 0;
        boolean rightSize = false;
        
        if (arr.length == arrSize) {
            rightSize = true;
            int i = 0;
            for (String[] row : arr) {
                if (row.length != arrSize) {
                    rightSize = false;
                    break;
                }
                i++;
                int j = 0;
                for (String element : row) {
                    j++;
                    try {
                        sum += Integer.parseInt(element);
                    }
                    catch (Exception e) {
                        String message = "Wrong data - row: " + i + ", element: " + j + " - " + Arrays.toString(row);
                        throw new MyArrayDataException(message);
                    }
                }
            }
        }

        if (!rightSize) {
            throw new MySizeArrayException("Wrong size of array!");
        }
        else {
            System.out.println("Sum of elements = " + sum);
        }
    }
}
