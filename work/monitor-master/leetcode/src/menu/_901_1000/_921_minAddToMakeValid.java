package menu._901_1000;

/**
 * @ClassName _921_minAddToMakeValid
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 16:28
 * @Version 1.0
 */
public class _921_minAddToMakeValid {
    public int minAddToMakeValid(String S) {
        char[] ch = S.toCharArray();
        int res = 0;
        int count = 0;
        for (char ch1 : ch) {
            if (ch1 == '(') {
                count++;
            } else {
                if (count == 0) {
                    res++;
                } else {
                    count--;
                }
            }
        }
        return res + count;
    }
}
