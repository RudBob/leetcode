package string;

/**
 * @ClassName findLUSlength
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/1 14:55
 * @Version 1.0
 */
public class findLUSlength {

    public int findLUSlength(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        if (lenA != lenB) {
            return Math.max(lenA, lenB);
        }
        if (a.equals(b)) {
            return -1;
        }
        String subStr;
        for (int subLen = lenA; subLen > 0; subLen--) {
            for (int beginIndex = 0; beginIndex <= lenA - subLen; beginIndex++) {
                subStr = a.substring(beginIndex, subLen);
                if (!b.contains(subStr)) {
                    return subLen;
                }
            }
        }
        return -1;
    }

    public int findLUSlength01(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
