package tag.string;

/**
 * @ClassName reverseString
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/20 14:35
 * @Version 1.0
 */
public class reverseString {
    public String reverseString(String s) {
        char[] values = s.toCharArray();
        char[] res = new char[values.length];
        StringBuilder sb = new StringBuilder();
        // 翻转即可
        for (int i = 0; i < values.length; i++) {
            sb.append(values[values.length - i - 1]);
        }
        return sb.toString();
    }
}
