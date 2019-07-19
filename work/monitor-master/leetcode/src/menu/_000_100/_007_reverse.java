package menu._000_100;

/**
 * @ClassName _007_reverse
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/17 20:43
 * @Version 1.0
 */
public class _007_reverse {
    public int reverse(int x) {
        // 得到符号.
        long y = 0;
        while (x != 0) {
            y += y * 10 + x % 10;
            x /= 10;
        }
        if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) y;
    }
}
