package geekbrains.dubovik.java.lesson_1;

public class Cat implements Runable{
    String name;
    int maxRun = 100;
    int maxJump = 3;
    boolean permit = true;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void run(int param) {
        if (permit) {
            if (param <= maxRun) {
                System.out.printf("Cat %s run %d meters\n", name, param);
            }
            else {
                permit = false;
                System.out.printf("Cat %s can not run %d meters\n", name, param);
            }
        }
    }

    @Override
    public void jump(int param) {
        if (permit) {
            if (param <= maxJump) {
                System.out.printf("Cat %s jump %d meters\n", name, param);
            } else {
                permit = false;
                System.out.printf("Cat %s can not jump %d meters\n", name, param);
            }
        }
    }
}
