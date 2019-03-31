package tag.string;

/**
 * @ClassName validPalindrome
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/26 10:43
 * @Version 1.0
 */
public class validPalindrome {
    public boolean validPalindrome(String s) {
        int i = -1;
        int j = s.length();
        char[] sChars = s.toCharArray();
        while (++i < --j) {
            if (sChars[i] != sChars[j]) {
                return isDeleChar(sChars, i, j - 1) || isDeleChar(sChars, i + 1, j);
            }
        }
        return true;
    }

    private boolean isDeleChar(char[] s, int i, int j) {
        while (i < j) {
            if (s[i++] != s[j--]) {
                return false;
            }
        }
        return true;
    }

    // 别人的解法
    public boolean validPalindrome03(String s) {
        char[] sChars = s.toCharArray();
        int i = isGood(0, sChars.length - 1, sChars);
        if (i != -1) {
            if (isGood(i + 1, sChars.length - 1 - i, sChars) != -1) {
                return isGood(i, sChars.length - 2 - i, sChars) == -1;
            }
        }
        return true;
    }

    private int isGood(int i, int j, char[] s) {
        while (i <= j) {
            if (s[i] != s[j]) return i;
            i++;
            j--;
        }
        return -1;
    }

    /**
     *
     */
    public boolean validPalindrome01(String s) {
        char[] sChars = s.toCharArray();
        int count = getDifferentNum(sChars, 0, 0, sChars.length - 1);
        return count <= 1;
    }

    private int getDifferentNum(char[] sChars, int count, int head, int last) {
        if (count > 1) {
            return count;
        }
        while (head < last) {
            if (sChars[head] != sChars[last]) {
                return Math.min(getDifferentNum(sChars, count + 1, head + 1, last), getDifferentNum(sChars, count + 1, head, last - 1));
            }
            head++;
            last--;
        }
        return 0;
    }

    /**
     * 暴力，差一点点就超时.
     */
    public boolean validPalindrome02(String s) {
        char[] sChars = s.toCharArray();
        for (int i = -1; i < s.length(); i++) {
            if (isPalindrome(sChars, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isPalindrome(char[] sChars, int flagDelete) {
        int head = 0;
        int last = sChars.length - 1;
        while (head < last) {
            if (head == flagDelete) {
                head++;
            }
            if (last == flagDelete) {
                last--;
            }
            if (head < last && sChars[head] != sChars[last]) {
                return false;
            }
            head++;
            last--;
        }
        return true;
    }
}
