import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strWithout3a3b(1, 2));
    }
}

class Solution {
    // 谁多先放谁，并且不能连续三次一样.
    public String strWithout3a3b(int A, int B) {
        StringBuilder res = new StringBuilder();
        // 计重复的次数
        int count = 0;
        // 上一个字母.
        char lastCh = 'c';
        while (A != 0 || B != 0) {
            if (count == 2) {
                if (lastCh == 'a') {
                    B--;
                    res.append('b');
                    lastCh = 'b';
                } else {
                    A--;
                    res.append('a');
                    lastCh = 'a';
                }
                count = 1;
            } else if (A > B) {
                if (lastCh == 'a') {
                    count++;
                } else {
                    count = 1;
                }
                A--;
                res.append('a');
                lastCh = 'a';
            } else {
                if (lastCh == 'b') {
                    count++;
                } else {
                    count = 1;
                }
                B--;
                res.append('b');
                lastCh = 'b';
            }
        }
        return res.toString();
    }
}