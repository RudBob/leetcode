package string;

/**
 * @ClassName countSegments
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/26 11:24
 * @Version 1.0
 */
public class countSegments {
    public int countSegments(String s) {
        // 通过左右各加一个空格，规避掉各种特殊情况："", " ", " h w", "h w "," h w "
        String s2 = " " + s + " ";
        int countSpace = 0;
        for (int i = 0, len = s2.length(); i < len; i++) {
            if (s2.charAt(i) == ' ') {
                countSpace++;
                // 跳过所有空格.
                do {
                    i++;
                } while (i < len && s2.charAt(i) == ' ');
            }
        }
        return countSpace - 1;
    }
}
