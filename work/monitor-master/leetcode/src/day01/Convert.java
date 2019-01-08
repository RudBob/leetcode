package day01;

import java.util.LinkedList;

public class Convert {
    /**
     *  用链表数组模拟图像的生成
     */
    public String convert(String s, int numRows) {
        // 如果为1，直接返回
        if (numRows == 1) {
            return s;
        }
        // 申请数组
        LinkedList<Character>[] arrs = new LinkedList[numRows];
        for (int i = 0; i < numRows; i++) {
            arrs[i] = new LinkedList();
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
            for (Character c : arrs[i]) {
                res.append(c);
            }
        }
        return res.toString();
    }
}
