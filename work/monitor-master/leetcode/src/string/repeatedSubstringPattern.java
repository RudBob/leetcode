package string;

/**
 * @ClassName repeatedSubstringPattern
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/22 15:15
 * @Version 1.0
 */
public class repeatedSubstringPattern {
    public boolean repeatedSubstringPattern02(String s) {
        int len = s.length();
        for (int subLen = 1; subLen <= len / 2; subLen++) {
            if (len % subLen != 0) {
                continue;
            }
            int k = len / subLen;
            String a = s.substring(0, subLen);
            int indexOfSub = 0;
            int i = 0;
            for (; i < len; i++) {
                indexOfSub = indexOfSub % subLen;
                if (s.charAt(i) != a.charAt(indexOfSub)) {
                    break;
                }
                indexOfSub++;
            }
            if (i == len && indexOfSub == subLen) {
                return true;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int subLen = 1; subLen <= len / 2; subLen++) {
            if (len % subLen != 0) {
                continue;
            }
            int k = len / subLen;
            String a = s.substring(0, subLen);
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < k; i++) {
                temp.append(a);
            }
            if (temp.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
