package tag.string;

import java.util.Arrays;

/**
 * @ClassName multiply
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/29 12:18
 * @Version 1.0
 */
public class multiply {

    //  999 * 999 = 998001
    //  100 * 100 =  10000
    // 99 * 99 =
    // 10 10 100
    // 999 * 99 = 98901
    // 100 * 10 =  1000
    public String multiply(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        char[] res;
        if (n1.length > n2.length) {
            res = multiply(n1, n2);
        } else {
            res = multiply(n2, n1);
        }
        StringBuilder resStr = new StringBuilder();
        int i = 0;
        while (i < res.length && res[i] == '0') {
            i++;
        }
        for (; i < res.length; i++) {
            resStr.append(res[i]);
        }
        return resStr.length() == 0 ? "0" : resStr.toString();
    }

    private char[] multiply(char[] num1, char[] num2) {
        char[] res = new char[num1.length + num2.length];
        int[] temp = new int[res.length];

        Arrays.copyOf(res, '0');

        int index1 = num1.length - 1;
        int index2 = num2.length - 1;
        int indexTemp = temp.length - 1;
        while (index1 >= 0 || index2 >= 0 || indexTemp >= 0) {
            if (index1 >= 0 && index2 >= 0) {
                multiply(num1, num2, index2, res, temp, indexTemp);
            } else {
                res[indexTemp] = (char) (temp[indexTemp] + '0');
            }
            index1--;
            index2--;
            indexTemp--;
        }
        return res;
    }

    private void multiply(char[] num1, char[] num2, int index2, char[] res, int[] temp, int indexTemp) {
        int k = indexTemp;
        int n2 = num2[index2] - '0';
        for (int i = num1.length - 1; i >= 0; i--) {
            int n1 = num1[i] - '0';
            temp[indexTemp] += n1 * n2;
            if (temp[indexTemp] >= 10) {
                temp[indexTemp - 1] += temp[indexTemp] / 10;
                temp[indexTemp] %= 10;
            }
            indexTemp--;
        }
        res[k] = (char) (temp[k] + '0');
    }
}
