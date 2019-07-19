package tag.string;

/**
 * @ClassName _009_isPalindrome
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/22 14:31
 * @Version 1.0
 */
public class isPalindrome {
    // 直接使用双指针法。
    public boolean isPalindrome2(String s) {
        int head = 0, last = s.length() - 1;
        while (head < last) {
            while (head < last && !(Character.isDigit(s.charAt(head)) || Character.isLetter(s.charAt(head)))) {
                head++;
            }
            while (head < last && !(Character.isDigit(s.charAt(last)) || Character.isLetter(s.charAt(last)))) {
                last--;
            }
            if (head < last) {
                char h = s.charAt(head);
                char l = s.charAt(last);
                if (h == l) {
                    head++;
                    last--;
                } else if (Character.isLetter(h) && Character.isLetter(l)) {
                    h = Character.toLowerCase(h);
                    l = Character.toLowerCase(l);
                    if (h != l) {
                        return false;
                    } else {
                        head++;
                        last--;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        // 只把字母和数字放入新数组中，(字母全部转为小写)
        char[] resCharArr = new char[s.length()];
        int indexOfRes = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            char theChar = s.charAt(i);
            if (Character.isLetter(theChar)) {
                resCharArr[indexOfRes++] = Character.toLowerCase(theChar);
            } else if (Character.isDigit(theChar)) {
                resCharArr[indexOfRes++] = theChar;
            }
        }
        return isPalindrome(resCharArr, indexOfRes);
    }

    private boolean isPalindrome(char[] resCharArr, int indexOfRes) {
        int head = 0, last = indexOfRes - 1;
        while (head < last) {
            if (resCharArr[head] != resCharArr[last]) {
                return false;
            }
            head++;
            last--;
        }
        return true;
    }
}
