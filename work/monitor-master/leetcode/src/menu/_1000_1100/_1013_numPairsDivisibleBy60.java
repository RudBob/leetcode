package menu._1000_1100;

import java.util.Arrays;

public class _1013_numPairsDivisibleBy60 {


    public int numPairsDivisibleBy60(int[] time) {
        // 所有的数字都%= 60；
        for (int i = 0; i < time.length; i++) {
            time[i] %= 60;
        }
        Arrays.sort(time);
        int[] count = new int[60];
        for (int i = 0; i < time.length; i++) {
            count[time[i]]++;
        }
        int res = 0;
        // i== 0时，i == 30 时，个数都是
        res += Cby2(count[0]) + Cby2(count[30]);
        for (int i = 1; i < 30; i++) {
            res += count[i] * count[60 - i];
        }
        return res;
    }

    private int Cby2(int up) {
        if (up < 2) {
            return 0;
        }
        return (up * (up - 1)) / 2;
    }
}
