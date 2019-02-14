package string;

/**
 * @ClassName judgeCircle
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/20 14:26
 * @Version 1.0
 */
public class judgeCircle {

    public boolean judgeCircle(String moves) {
        Robot robot = new Robot();
        int len = moves.length();
        for(int i = 0; i < len; i++) {
            robot.move(moves.charAt(i));
        }
        if (robot.x == robot.y && robot.x
                == 0) {
            return true;
        }
        return false;
    }
}

// 构造机器人
class Robot {
    // 坐标
    int x = 0;
    int y = 0;

    public void R() {
        this.x++;
    }

    public void L() {
        this.x--;
    }

    public void U() {
        this.y++;
    }

    public void D() {
        this.y--;
    }

    public void move(char move) {
        if (move == 'R') {
            R();
        } else if (move == 'L') {
            L();
        } else if (move == 'U') {
            U();
        } else if (move == 'D') {
            D();
        }

    }
}
