import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}

class Solution {
    public int brokenCalc(int x, int y) {
        int steps = 0;
        // 神搜.
        while (y != x) {
            if (y < x) {
                return steps + x - y;
            } else {
                if (y % 2 == 1) {
                    y++;
                } else {
                    y /= 2;
                }
            }
            steps++;
        }
        // 第二种解法.
        if (x >= y) {
            return x - y;
        } else if (y % 2 != 0) {
            // y为奇数，那么+1.
            return 1 + brokenCalc(x, y + 1);
        } else {
            // 为偶数，则除2.
            return 1 + brokenCalc(x, y / 2);
        }
    }
}