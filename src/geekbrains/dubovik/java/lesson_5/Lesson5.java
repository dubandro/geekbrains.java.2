package geekbrains.dubovik.java.lesson_5;

import java.util.Arrays;

public class Lesson5 {
    public static void main(String[] args) throws InterruptedException {
        final int size = 10;
        float[] arr1 = new float[size];
        float[] arr2 = new float[size];
        Arrays.fill(arr1, 1.0f);
        Arrays.fill(arr2, 1.0f);

        System.out.println("Пауза для чистоты эксперимента");
        Thread.sleep(1000); //получена эмпирически, если поставить меньше - первый метод делает дольше

        ArrayThread.threadOne(arr1);
        ArrayThread.threadTwo(arr2);
        /*ArrayThread.threadTwo(arr);
        ArrayThread.threadOne(arr);*/

    }
}
