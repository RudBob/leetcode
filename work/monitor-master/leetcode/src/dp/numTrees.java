package dp;

/**
 * @ClassName numTrees
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/6 10:34
 * @Version 1.0
 */
public class numTrees {

    // 递归
    public int numTrees(int n) {
        int sum = 0;
        int[] cache = new int[n];
        cache[0] = 1;
        if (n >= 2) {
            cache[1] = 1;
        }
        if (n >= 3) {
            cache[2] = 2;
        }
        if (n >= 4) {
            cache[3] = 5;
        }
        for (int i = 0; i < n; i++) {
            // 左右两边的可能性
            sum += getTreeNum(i, cache) * getTreeNum(n - i - 1, cache);
        }
        return sum;
    }

    private int getTreeNum(int n, int[] cache) {
        if (cache[n] == 0) {
            cache[n] += getTreeNum(n - 1, cache);
            for (int i = 1; i < n; i++) {
                // 左右两边的可能性
                cache[n] += getTreeNum(i, cache) * getTreeNum(n - i - 1, cache);
            }
        }
        return cache[n];
    }
}
