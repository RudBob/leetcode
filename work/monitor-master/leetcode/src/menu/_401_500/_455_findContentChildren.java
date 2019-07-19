package menu._401_500;

import java.util.Arrays;

/**
 * @ClassName _455_findContentChildren
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 15:56
 * @Version 1.0
 */
public class _455_findContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        // 尽可能满足胃口小的孩子.
        int i, j;
        for (i = 0, j = 0; i < g.length && j < s.length; ) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
