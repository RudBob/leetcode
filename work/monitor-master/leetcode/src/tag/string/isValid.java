package tag.string;

/**
 * @ClassName isValid
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/22 15:39
 * @Version 1.0
 */
public class isValid {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int len = s.length();
        char[] res = new char[len];
        int top = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (top > 0 && isRight(ch)) {
                // 给定右括号
                if (ch == ')' && res[top - 1] == '(') {
                    top--;
                } else if (ch == '}' && res[top - 1] == '{') {
                    top--;
                } else if (ch == ']' && res[top - 1] == '[') {
                    top--;
                } else {
                    return false;
                }
            } else {
                res[top++] = ch;
            }
        }
        return top == 0;
    }

    private boolean isRight(char ch) {
        return ch == '}' || ch == ')' || ch == ']';
    }
}
