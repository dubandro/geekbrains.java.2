package geekbrains.dubovik.java.lesson_1;

public class JumpWall extends SportsEquipment {
    int height;

    public JumpWall(int height) {
        this.height = height;
    }

    public void jump (Jumpable member) {
        member.jump(height);
    }
}
