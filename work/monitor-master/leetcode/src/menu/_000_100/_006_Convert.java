package menu._000_100;

import java.util.ArrayList;
import java.util.List;

public class _006_Convert {
    /**
     * 直接使用图像呈现的规律
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] ch = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        // 默认是 (2n -3)
        int[] next = new int[2];
        next[0] = 2 * numRows - 2;
        for (int i = 0, beginIdx = 0, cur = 0; stringBuilder.length() != ch.length; i = (i + 1) % 2) {
            if (next[i] != 0) {
                stringBuilder.append(ch[cur]);
                cur = (cur + next[i]);
                if (cur >= ch.length) {
                    cur = ++beginIdx;
                    next[0] -= 2;
                    next[1] += 2;
                    i = 1;
                }
            }
        }
        return stringBuilder.toString();
    }
    /**
     * 用链表数组模拟图像的生成
     */
    public String convert1(String s, int numRows) {
        // 如果为1，直接返回
        if (numRows == 1) {
            return s;
        }
        // 申请数组
        List[] arrs = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            arrs[i] = new ArrayList();
        }
        // 数组下标，需要上下晃荡，所以需要一个下标，一个下标的方向标志。
        int k = 0;
        int k_s = 1;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            arrs[k].add(s.charAt(i));
            k += k_s;
            // 如果到头，那么改变方向
            if (k == numRows - 1 || k == 0) {
                k_s = -k_s;
            }
        }
        // 结果StringBuilder，
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (Object c : arrs[i]) {
                res.append(c);
            }
        }
        return res.toString();
    }
}
