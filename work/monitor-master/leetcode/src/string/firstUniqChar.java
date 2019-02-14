package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName firstUniqChar
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/24 9:09
 * @Version 1.0
 */
public class firstUniqChar {
    // 自己手写map
    public int firstUniqChar(String s) {
        int len = s.length();
        char[] key = new char[26];
        int[] value = new int[26];
        for (int i = 0; i < len; i++) {
            char thisChar = s.charAt(i);
            value[thisChar - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            char thisChar = s.charAt(i);
            if (value[thisChar - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    //HashMap
    public int firstUniqChar02(String s) {
        int len = s.length();
        // 使用map
        Map<Character, Integer> count = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            char key = s.charAt(i);
            Integer value = count.get(key);
            if (value == null) {
                count.put(key, 0);
            } else {
                count.put(key, value + 1);
            }
        }
        for (int i = 0; i < len; i++) {
            char key = s.charAt(i);
            int value = count.get(key);
            if (value == 0) {
                return i;
            }
        }
        return -1;
    }

    //暴力
    public int firstUniqChar01(String s) {
        char[] sc = s.toCharArray();
        boolean[] flag = new boolean[sc.length];
        int resIndex = -1;
        int count = 0;
        for (int i = 0; i < sc.length; i++) {
            count = 0;
            if (!flag[i]) {
                for (int j = i + 1; j < sc.length; j++) {
                    if (!flag[j] && sc[i] == sc[j]) {
                        count++;
                        flag[j] = true;
                    }
                }
                if (count == 0) {
                    return i;
                }
            }
        }
        return resIndex;
    }
}
