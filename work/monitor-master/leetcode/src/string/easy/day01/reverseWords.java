package string.easy.day01;

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
}
