package others.day01;

public class Reverse {
    public int reverse(int x) {

        // 最关键的地方在于：如果判断转换后的值是否在 [−(2^31),  (2^31) − 1]中
        // 通过打印 Integer中的常量，可以得到对应的范围值。
        // MAX_VALUE = 2147483647;
        // MIN_VALUE =-2147483648;
        int zhengFu = 1;
        if (x == 0) {
            return 0;
        } else if (x < 0) {
            zhengFu = -1;
            // 转化为正整数，以便于减少重复代码
            x = -x;
        }
        StringBuilder xStr = new StringBuilder(Integer.toString(x));
        StringBuilder res = new StringBuilder();
        for (int i = xStr.length() - 1; i >= 0; i--) {
            res.append(xStr.charAt(i));
        }
        String resStr = res.toString();
        int resInt = 0;
        try {
            resInt = Integer.parseInt(resStr);
        } catch (Exception e) {
            return 0;
        }
        return resInt * zhengFu;
    }
}
