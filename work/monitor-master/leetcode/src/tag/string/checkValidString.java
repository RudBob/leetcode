package tag.string;

/**
 * @ClassName checkValidString
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/1 12:33
 * @Version 1.0
 */
public class checkValidString {

    public boolean checkValidString(String s) {
        // 回溯
        char[] ch = s.toCharArray();
        int index = 0;
        // return checkVS(ch, index, 0);
        return checkVS(ch);
    }

    // 两遍循环，解决. 5ms
    private boolean checkVS(char[] ch) {
        int countLeft = 0, countStar = 0, countRight = 0;
        for (int j = 0; j < ch.length; j++) {
            if (ch[j] == '(') {
                countLeft++;
            } else if (ch[j] == '*') {
                countStar++;
            } else {
                if (countLeft > 0) {
                    countLeft--;
                } else if (countStar > 0) {
                    countStar--;
                } else {
                    return false;
                }
            }
        }
        countStar = 0;
        for (int j = ch.length - 1; j >= 0; j--) {
            if (ch[j] == ')') {
                countRight++;
            } else if (ch[j] == '*') {
                countStar++;
            } else {
                if (countRight > 0) {
                    countRight--;
                } else if (countStar > 0) {
                    countStar--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //暴力回溯 315ms
    private boolean checkVS10(char[] ch, int index, int count) {
        if (count < 0) {
            return false;
        }
        if (index == ch.length) {
            return count == 0;
        }
        if (ch[index] == '(') {
            return checkVS10(ch, index + 1, count + 1);
        } else if (ch[index] == ')') {
            return checkVS10(ch, index + 1, count - 1);
        } else {
            // 先跳过.
            // 再变左括号
            // 右括号.
            return checkVS10(ch, index + 1, count) ||
                    checkVS10(ch, index + 1, count + 1) ||
                    checkVS10(ch, index + 1, count - 1);
        }
    }

    // 简单优化后的回溯 243ms
    private boolean checkVS11(char[] ch, int index, int count) {
        for (int i = index; i < ch.length && count >= 0; i++) {
            if (ch[i] == '(') {
                count++;
            } else if (ch[i] == ')') {
                count--;
            } else {
                // 先跳过.
                // 再变左括号
                // 右括号.
                return checkVS11(ch, i + 1, count) ||
                        checkVS11(ch, i + 1, count + 1) ||
                        checkVS11(ch, i + 1, count - 1);
            }
        }
        return count == 0;
    }
}
