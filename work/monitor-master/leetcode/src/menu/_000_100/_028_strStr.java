package menu._000_100;

/**
 * @ClassName _028_strStr
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 14:28
 * @Version 1.0
 */
public class _028_strStr {
    public int strStr(String haystack, String needle) {
        StringBuilder a = new StringBuilder(haystack);
        return a.indexOf(needle);
    }
}
