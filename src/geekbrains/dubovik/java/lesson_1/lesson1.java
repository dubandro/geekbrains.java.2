package geekbrains.dubovik.java.lesson_1;

public class lesson1 {
    public static void main(String[] args) {
        Human human = new Human("Kolya");
        Robot robot = new Robot("Verter");
        Cat cat = new Cat("Vasya");

        Runable[] members = {
                human,
                robot,
                cat
        };

        RunTrack track1 = new RunTrack(100);
        JumpWall wall1 = new JumpWall(1);
        RunTrack track2 = new RunTrack(200);
        JumpWall wall2 = new JumpWall(2);
        RunTrack track3 = new RunTrack(1000);
        JumpWall wall3 = new JumpWall(10);

        SportsEquipment[] equipments = {
                track1, wall1,
                track2, wall2,
                track3, wall3
        };

        for (SportsEquipment equipment : equipments) {
            for (Runable member : members) {
                if (equipment instanceof RunTrack) {
                    ((RunTrack) equipment).run(member);
                }
                if (equipment instanceof JumpWall) {
                    ((JumpWall) equipment).jump(member);
                }
            }
        }
    }
}
