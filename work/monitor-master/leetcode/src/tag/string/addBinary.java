package tag.string;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @ClassName addBinary
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/22 11:49
 * @Version 1.0
 */
public class addBinary {
    public String addBinary2(String a, String b) {
        return new BigInteger(a,2).add(new BigInteger(b,2)).toString(2);
    }
    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length());
        char[] aChars = new char[len], bChars = new char[len], temp = new char[len + 1], res = new char[len + 1];
        binStrToCharArr(a, aChars, len);
        binStrToCharArr(b, bChars, len);
        Arrays.fill(temp, '0');

        for (int i = len - 1; i >= 0; i--) {
            char res0 = '0';
            // 先计算achars和bchars 的和，然后将进位放入temp中的前一位中，
            if (aChars[i] == bChars[i] && bChars[i] == '1') {
                temp[i] = '1';
            } else if (aChars[i] != bChars[i]) {
                res0 = '1';
            }
            // 然后将计算结果与temp对应的位置进行计算，之后放入结果中
            if (res0 == temp[i + 1] && res0 == '1') {
                temp[i] = '1';
                res[i + 1] = '0';
            } else if (res0 != temp[i + 1]) {
                res[i + 1] = '1';
            } else {
                res[i + 1] = '0';
            }
        }
        String res1 = null;
        if (temp[0] == '1') {
            res[0] = '1';
            res1 = new String(res);
        }else {
            res[0] = '0';
            res1 = new String(res).substring(1);
        }

        return res1;
    }

    private void binStrToCharArr(String a, char[] aChars, int len) {
        int begin = len - a.length();
        for (int i = 0; i < len; i++) {
            if (i < begin) {
                aChars[i] = '0';
            } else {
                aChars[i] = a.charAt(i - (begin));
            }
        }
    }
}
