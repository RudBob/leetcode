package menu._000_100;

/**
 * @ClassName _013_romanToInt
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/17 20:23
 * @Version 1.0
 */
public class _013_romanToInt {
    static int[] map = new int[128];

    static {
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
    }

    public int romanToInt2(String s) {
        char[] cs = s.toCharArray();
        int res = 0;
        for (int i = 0; i < cs.length; ++i) {
            if (i + 1 < cs.length && map[cs[i]] < map[cs[i + 1]]) {
                res -= map[cs[i]];
            } else {
                res += map[cs[i]];
            }
        }
        return res;
    }
    public int romanToInt(String s) {
        int res = 0, pre = 0, now = 0;
        char[] cs = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            now = map[cs[i]];
            if (now > pre) {
                res = res - 2 * pre;
            }
            res += now;
            pre = now;
        }
        return res;
    }
}
