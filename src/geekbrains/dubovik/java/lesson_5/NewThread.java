package geekbrains.dubovik.java.lesson_5;

public class NewThread extends Thread{
    float[] arr;
    int h;

    public NewThread(float[] arr, int h) {
        this.arr = arr;
        this.h = h;
    }

    @Override
    public void run() {
        calculate(arr, h);
    }

    private void calculate(float[] arr, int range) {
        for (int i = 0; i < arr.length; i++) {
            int j = i + range;
            arr[i] = (float) (arr[i] * Math.sin(0.2f + j / 5.0) * Math.cos(0.2f + j / 5.0) * Math.cos(0.4f + j / 2.0));
        }
    }
}