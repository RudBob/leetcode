package tag.others.somemethod;

import java.util.ArrayList;
import java.util.List;

public class readBinaryWatch {
    /**
     * 巧用二进制宝搜
     *
     * @param num
     * @return
     */
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
                    if (m < 10) {
                        res.add(h + ":" + "0" + m);
                    } else {
                        res.add(h + ":" + m);
                    }
                }
            }
        }
        return res;
    }

    /**
     * 直接暴搜。
     *
     * @param num
     * @return
     */
    public List<String> readBinaryWatch01(int num) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (judgeNum(h, m, num)) {
                    if (m < 10) {
                        res.add(h + ":" + "0" + m);
                    } else {
                        res.add(h + ":" + m);
                    }
                }
            }
        }
        return res;
    }

    private boolean judgeNum(int h, int m, int num) {
        int lightNum = 0;
        int[] hours = {1, 2, 4, 8};
        int[] minus = {1, 2, 4, 8, 16, 32};
        int i = hours.length - 1;
        lightNum = getLightNum(h, hours, lightNum);
        lightNum = getLightNum(m, minus, lightNum);
        return lightNum == num;
    }

    private int getLightNum(int m, int[] arr, int lightNum) {
        int i = arr.length - 1;
        while (m > 0) {
            if (m >= arr[i]) {
                m -= arr[i];
                lightNum += 1;
            } else {
                i--;
            }
        }
        return lightNum;
    }


}
