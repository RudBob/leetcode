package day02;

public class romanToInt {
    public int romanToInt(String s) {
        int[] nums = {1, 5, 10, 50, 100, 500, 1000};
        char[] romans = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int res = 0, pre = 0, now = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < romans.length; j++) {
                if (s.charAt(i) == romans[j]) {
                    now = nums[j];
                }
            }
            //
            if (now > pre) {
                res = res - 2 * pre;
            }
            res += now;
            pre = now;
        }
        return res;
    }
}
