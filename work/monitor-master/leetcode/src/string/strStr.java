package string;

/**
 * @ClassName strStr
 * @Description 找到子字符串在目标字符串的位置，返回目标位置的第一个index。
 * @Author 任耀
 * @Date 2019/1/22 14:52
 * @Version 1.0
 */
public class strStr {
    public int strStr(String haystack, String needle) {
        StringBuilder a = new StringBuilder(haystack);
        return a.indexOf(needle);
    }
}
