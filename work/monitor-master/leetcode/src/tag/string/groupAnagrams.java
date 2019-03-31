package tag.string;

import java.util.*;

/**
 * @ClassName groupAnagrams
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/27 14:58
 * @Version 1.0
 */
public class groupAnagrams {
    /**
     * 推荐写法
     * hashMap，以排序后的结果为键
     */
    public List<List<String>> groupAnagrams02(String[] strs) {
        char[][] strsChars = new char[strs.length][];
        Map<String, List<String>> stringListMap = new HashMap<>(strs.length);
        for (int i = 0; i < strs.length; i++) {
            strsChars[i] = strs[i].toCharArray();
            Arrays.sort(strsChars[i]);
            String key = new String(strsChars[i]);
            List<String> value = stringListMap.get(key);
            if (value == null) {
                value = new ArrayList<>();
                value.add(strs[i]);
                stringListMap.put(key, value);
            } else {
                value.add(strs[i]);
            }
        }
        return new ArrayList<>(stringListMap.values());
    }

    /**
     * 计
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int[][] countChars = new int[strs.length][26];
        boolean[] flagOfDelete = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0, len = strs[i].length(); j < len; j++) {
                countChars[i][strs[i].charAt(j) - 'a']++;
            }
        }
        for (int i = 0; i < strs.length; i++) {
            if (flagOfDelete[i]) {
                continue;
            }
            List<String> tempRes = new ArrayList<>();
            tempRes.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (!flagOfDelete[j] && equals(countChars[i], countChars[j])) {
                    flagOfDelete[j] = true;
                    tempRes.add(strs[j]);
                }
            }
            res.add(tempRes);
        }
        return res;
    }

    private boolean equals(int[] strsChar, int[] strsChar1) {
        for (int i = 0; i < strsChar.length; i++) {
            if (strsChar[i] != strsChar1[i]) {
                return false;
            }
        }
        return true;
    }


    public List<List<String>> groupAnagrams01(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        char[][] strsChars = new char[strs.length][];
        boolean[] flagOfDelete = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            strsChars[i] = strs[i].toCharArray();
            Arrays.sort(strsChars[i]);

        }
        for (int i = 0; i < strs.length; i++) {
            if (flagOfDelete[i]) {
                continue;
            }
            List<String> tempRes = new ArrayList<>();
            for (int j = i; j < strs.length; j++) {
                if (flagOfDelete[j]) {
                    continue;
                }
                if (equals(strsChars[i], strsChars[j])) {
                    tempRes.add(strs[j]);
                    flagOfDelete[j] = true;
                }
            }
            res.add(tempRes);
        }
        return res;
    }

    private boolean equals(char[] strsChar, char[] strsChar1) {
        if (strsChar == strsChar1) {
            return true;
        }
        if (strsChar.length != strsChar1.length) {
            return false;
        }
        for (int i = 0; i < strsChar.length; i++) {
            if (strsChar[i] != strsChar1[i]) {
                return false;
            }
        }
        return true;
    }
}
