package geekbrains.dubovik.java.lesson_5;

public class ArrayThread {

    public static void threadOne(float[] arr) {

        long start = System.currentTimeMillis();
        int range = 0;
        Thread t = new NewThread(arr, range);
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long finish = System.currentTimeMillis();
        System.out.printf("Изменение целого массива произведено за %d милисекунд\n", finish - start);
    }

    public static void threadTwo(float[] arr) {

        long start = System.currentTimeMillis();

        int range = arr.length / 2;
        float[] arr21 = new float[range];
        float[] arr22 = new float[range];
        System.arraycopy(arr, 0, arr21, 0, range);
        System.arraycopy(arr, range, arr22, 0, range);

        Thread t1 = new NewThread(arr21, 0);
        Thread t2 = new NewThread(arr22, range);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr21, 0, arr, 0, range);
        System.arraycopy(arr22, 0, arr, range, range);

        long finish = System.currentTimeMillis();
        System.out.printf("Разделение на два массива, изменение и склейка произведено за %d милисекунд\n", finish - start);
    }
}