package tag.dp;

/**
 * @ClassName isSubsequence
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/11 13:51
 * @Version 1.0
 */
public class isSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int subIndex = 0;
        char c = s.charAt(subIndex++);
        for (int i = 0, len = t.length(); i < len; i++) {
            if (c == t.charAt(i)) {
                if (subIndex == s.length()) {
                    return true;
                } else {
                    c = s.charAt(subIndex++);
                }
            }
        }
        return false;
    }
}
