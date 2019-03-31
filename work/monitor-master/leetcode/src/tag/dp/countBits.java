package tag.dp;

public class countBits {
    /**
     * 调用库函数，好粗在于简介，但重复计算较多
     */
    public int[] countBits01(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = Integer.bitCount(i);
        }
        return res;
    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        if (num == 0) {
            return res;
        }
        res[0] = 0;
        res[1] = 1;
        int k = 2;
        for (int i = 2; i <= num; i++) {
            if (k * 2 == i) {
                k *= 2;
            }
            res[i] = res[i - k] + 1;
        }
        return res;
    }
}
