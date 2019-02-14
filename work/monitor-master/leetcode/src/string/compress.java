package string;

/**
 * @ClassName compress
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/24 9:48
 * @Version 1.0
 */
public class compress {
    public int compress(char[] chars) {
        int len = chars.length;
        if (len == 1) {
            return len;
        }
        // 两个指针 i , j
        int i = 0;
        int j = 1;
        char one;
        int count;
        while (i < chars.length && j < chars.length) {
            one = chars[i];
            count = 1;
            while (j < chars.length && chars[j] == one) {
                count++;
                j++;
            }
            if (count != 1) {
                String countStr = Integer.toString(count);
                for (int k = 0, lenCount = countStr.length(); k < lenCount; k++) {
                    chars[++i] = countStr.charAt(k);
                }
            }
            if (j < chars.length) {
                chars[++i] = chars[j++];
            }
        }
        return i + 1;
    }
}
