package string;

/**
 * @ClassName reverseVowels
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/21 22:13
 * @Version 1.0
 */
public class reverseVowels {
    public String reverseVowels(String s) {
        if(s.length() == 0){
            return s;
        }
        char[] chars = s.toCharArray();
        int head = 0, last = chars.length - 1;
        while (true) {
            while (!isYuanYin(chars[head]) && head < last) {
                head++;
            }
            while (!isYuanYin(chars[last]) && head < last) {
                last--;
            }
            if (head < last) {
                swap(chars, head, last);
                head++;
                last--;
            } else {
                break;
            }
        }
        return new String(chars);
    }

    private void swap(char[] chars, int head, int last) {
        char temp = chars[head];
        chars[head] = chars[last];
        chars[last] = temp;
    }

    char[] yuanYins = {'a', 'e', 'o', 'i', 'u'};

    public boolean isYuanYin(char c) {
        for (char yuanYin : yuanYins) {
            if (Character.toLowerCase(c) == yuanYin) {
                return true;
            }
        }
        return false;
    }
}
