package tag.dp;

/**
 * @ClassName numberOfArithmeticSlices
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/6 11:04
 * @Version 1.0
 */
public class numberOfArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int[] cache = new int[A.length];
        cache[0] = 1;
        cache[1] = 3;
        cache[2] = 6;
        return numberOfArithmeticSlices(A, cache);
    }


    public int numberOfArithmeticSlices(int[] A, int[] cache) {
        int sum = 0;
        int d = Integer.MAX_VALUE;
        int len = 2;
        for (int i = 0; i < A.length - 1; i++) {
            if (d == Integer.MAX_VALUE) {
                d = A[i + 1] - A[i];
            } else if (A[i] + d == A[i + 1]) {
                len++;
            } else {
                sum += getCache(len, cache);
                d = Integer.MAX_VALUE;
                len = 2;
                // 不过不倒退，那么 7，7，7，6，5, 无法被当作两个等差数组
                i--;
            }
        }
        if (len > 2) {
            sum += getCache(len, cache);
        }
        return sum;
    }

    public int getCache(int len, int[] cache) {
        if (len < 3) {
            return 0;
        }
        if (cache[len - 3] == 0) {
            cache[len - 3] = getCache(len - 1, cache) + len - 2;
        }
        return cache[len - 3];
    }
}
