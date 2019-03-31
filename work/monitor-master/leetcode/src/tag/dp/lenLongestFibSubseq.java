package tag.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName lenLongestFibSubseq
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/12 20:55
 * @Version 1.0
 */
public class lenLongestFibSubseq {

    public int lenLongestFibSubseq(int[] A) {
        /**
         * 用hashMap反向存储index
         */
        Map<Integer, Integer> findIndexByValue = new HashMap<>(A.length * 2);
        for (int i = 0; i < A.length; i++) {
            findIndexByValue.put(A[i], i);
        }
        int lenRes = 2;
        for (int first = A.length - 2; first >= 0; first--) {
            for (int secode = first + 1; secode < A.length - 1; secode++) {
                int len = getNext(A, A[first] + A[secode], 2, A[secode], findIndexByValue);
                lenRes = lenRes < len ? len : lenRes;
            }
        }
        return lenRes == 2 ? 0 : lenRes;
    }

    private int getNext(int[] a, int target, int len, int preValue, Map<Integer, Integer> findIndexByValue) {
        if (findIndexByValue.get(target) != null) {
            int i = findIndexByValue.get(target);
            len += getNext(a, preValue + a[i], len + 1, a[i], findIndexByValue);
        }
        return len;
    }
}
