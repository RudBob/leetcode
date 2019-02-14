package string;

/**
 * @ClassName reverseWords
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/20 15:10
 * @Version 1.0
 */
public class reverseWords {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] strs = s.split(" ");

        for (String str : strs) {
            StringBuilder a = new StringBuilder(str);
            res.append(a.reverse()).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public String reverseWords01(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] word = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = word.length - 1; i >= 0; i--) {
            String s2 = word[i];
            if (!s2.equals("")) {
                res.append(s2).append(" ");
            }
        }
        if (res.length() > 1) {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }
}
