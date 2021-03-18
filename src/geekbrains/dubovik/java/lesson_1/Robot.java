package geekbrains.dubovik.java.lesson_1;

public class Robot implements Runable{
    String name;
    int maxRun = 500;
    int maxJump = 1;
    boolean permit = true;

    public Robot(String name) {
        this.name = name;
    }

    @Override
    public void run(int param) {
        if (permit) {
            if (param <= maxRun) {
                System.out.printf("Robot %s run %d meters\n", name, param);
            }
            else {
                permit = false;
                System.out.printf("Robot %s can not run %d meters\n", name, param);
            }
        }
    }

    @Override
    public void jump(int param) {
        if (permit) {
            if (param <= maxJump) {
                System.out.printf("Robot %s jump %d meters\n", name, param);
            } else {
                permit = false;
                System.out.printf("Robot %s can not jump %d meters\n", name, param);
            }
        }
    }
}