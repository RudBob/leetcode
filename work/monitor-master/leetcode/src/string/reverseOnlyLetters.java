package string;

/**
 * @ClassName reverseOnlyLetters
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/22 14:13
 * @Version 1.0
 */
public class reverseOnlyLetters {
    // 双指针，遇到非字母则跳过
    public String reverseOnlyLetters(String S) {
        char[] s = S.toCharArray();
        int head = 0;
        int last = s.length - 1;
        while (head < last) {
            while (!Character.isLetter(s[head]) && head < last) {
                head++;
            }
            while (!Character.isLetter(s[last]) && head < last) {
                last--;
            }
            if (head < last) {
                swap(s, head, last);
                head++;
                last--;
            }
        }
        return new String(s);
    }

    private void swap(char[] s, int head, int last) {
        char t = s[head];
        s[head] = s[last];
        s[last] = t;
    }
}
