package geekbrains.dubovik.java.lesson_1;

public class RunTrack extends SportsEquipment {
    int length;

    public RunTrack (int height) {
        this.length = height;
    }

    public void run (Runable member) {
        member.run(length);
    }
}
