package tag.string;

/**
 * @ClassName repeatedStringMatch
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/26 11:42
 * @Version 1.0
 */
public class repeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder str = new StringBuilder(A);
        int lenA = str.length();
        int lenStr = lenA;
        int count = 1;
        int lenB = B.length();
        while (lenStr < lenB) {
            str.append(A);
            lenStr += lenA;
            count++;
        }
        String resA = str.toString();
        if (!resA.contains(B)) {
            resA = resA + A;
            count++;
            if (!resA.contains(B)) {
                return -1;
            }
        }
        return count;
    }
}
