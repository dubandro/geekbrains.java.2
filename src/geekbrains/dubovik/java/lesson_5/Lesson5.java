package geekbrains.dubovik.java.lesson_5;

import java.util.Arrays;

public class Lesson5 {
    public static void main(String[] args) {
        final int size = 10_000_000;

        float[] arr1 = new float[size];
        float[] arr2 = new float[size];
        Arrays.fill(arr1, 1.0f);
        Arrays.fill(arr2, 1.0f);

        System.out.println("Пауза для чистоты эксперимента)");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ArrayThread.threadOne(arr1);
        ArrayThread.threadTwo(arr2);

        System.out.println("Массивы одинаковые? - " + Arrays.equals(arr1, arr2));
    }
}
