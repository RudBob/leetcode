package string.easy.day01;

/**
 * @ClassName countBinarySubstrings
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/21 21:49
 * @Version 1.0
 */
public class countBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int res = 0;
        int len = s.length();
        int lastCount = 0, curCount = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                lastCount = curCount;
                curCount = 1;
            } else {
                curCount++;
            }
            if (lastCount >= curCount) {
                res++;
            }
        }
        return res;
    }
}
class solutionCountBinarySubstrings02{

    public int countBinarySubstrings(String s) {
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int count = getBinary(s, i);
            if (count != -1) {
                res += count;
                i += count;
                i--;
            }
        }
        return res;
    }

    private int getBinary(String s, int i) {
        int len = s.length();
        int countHead = 0;
        int j = i;
        char headChar = s.charAt(i);
        for (; j < len; j++) {
            if (s.charAt(j) == headChar) {
                countHead++;
            } else {
                break;
            }
        }
        int res = countHead;
        for (; j < len; j++) {
            if (s.charAt(j) != headChar) {
                countHead--;
                if (countHead <= 0) {
                    return res;
                }
            } else {
                break;
            }
        }
        return -1;
    }
}
