package geekbrains.dubovik.java.lesson_1;

public class Human implements Runable{
    String name;
    int maxRun = 1000;
    int maxJump = 2;
    boolean permit = true;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public void run(int param) {
        if (permit) {
            if (param <= maxRun) {
                System.out.printf("Human %s run %d meters\n", name, param);
            }
            else {
                permit = false;
                System.out.printf("Human %s can not run %d meters\n", name, param);
            }
        }
    }

    @Override
    public void jump(int param) {
        if (permit) {
            if (param <= maxJump) {
                System.out.printf("Human %s jump %d meters\n", name, param);
            } else {
                permit = false;
                System.out.printf("Human %s can not jump %d meters\n", name, param);
            }
        }
    }
}