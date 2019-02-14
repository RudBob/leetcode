package string;

/**
 * @ClassName nextGreaterElement
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/2 10:44
 * @Version 1.0
 */
public class nextGreaterElement {
    // 回溯全排列，捕获异常.
    public int nextGreaterElement(int n) {
        String str = Integer.toString(n);
        char[] chars = str.toCharArray();
        int res = MaxInt(chars, 0, Integer.MAX_VALUE, n);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int MaxInt(char[] chars, int i, int min, int n) {
        String tempStr = new String(chars);
        try {
            int k = Integer.parseInt(tempStr);
            if (k > min) {
                return min;
            }
            if (k > n) {
                min = min < k ? min : k;
            }
        } catch (NumberFormatException e) {
            return min;
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            min = Math.min(min, MaxInt(chars, i + 1, min, n));
            swap(chars, i, j);
        }
        return min;
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
