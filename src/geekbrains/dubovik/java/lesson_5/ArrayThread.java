package geekbrains.dubovik.java.lesson_5;

public class ArrayThread {

    public static void threadOne(float[] arr) {
        for (float i : arr) System.out.print(i);
        System.out.println();

        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long finish = System.currentTimeMillis();
        System.out.printf("Изменение целого массива произведено за %d секунд\n", finish - start);

        for (float i : arr) System.out.print(i);
        System.out.println();
    }

    public static void threadTwo(float[] arr) {
        for (float i : arr) System.out.print(i);
        System.out.println();

        long start = System.currentTimeMillis();

        int h = arr.length / 2;
        float[] arr21 = new float[h];
        float[] arr22 = new float[h];
        System.arraycopy(arr, 0, arr21, 0, h);
        System.arraycopy(arr, h, arr22, 0, h);

        for (int i = 0; i < arr21.length; i++) {
            arr21[i] = (float)(arr21[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        for (int i = 0; i < arr22.length; i++) {
            int j = i + h;
            arr22[i] = (float)(arr22[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }

        System.arraycopy(arr21, 0, arr, 0, h);
        System.arraycopy(arr22, 0, arr, h, h);

        long finish = System.currentTimeMillis();
        System.out.printf("Разделение на два массива, изменение и склейка произведено за %d секунд\n", finish - start);

        for (float i : arr) System.out.print(i);
        System.out.println();
    }
}
