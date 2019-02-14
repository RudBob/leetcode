package string;

import java.util.ArrayList;
import java.util.List;

public class wordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<>(A.length);
        // 先算出B中的单词的每个字母出现的频率
        int[] countB = new int[26];
        getCount(countB, B);
        int[][] countA = new int[26][A.length];
        getCount(countA, A);
        boolean tongYong;
        for (int i = 0; i < A.length; i++) {
            tongYong = true;
            for (int j = 0; j < 26; j++) {
                if (countA[j][i] < countB[j]) {
                    tongYong = false;
                    break;
                }
            }
            if (tongYong) {
                res.add(A[i]);
            }
        }
        return res;
    }

    private void getCount(int[] countB, String[] b) {
        // 找到B中每个字符串中.
        int[] tempCount = new int[26];
        for (String s : b) {
            for (int j = 0, len = s.length(); j < len; j++) {
                int index = s.charAt(j) - 'a';
                tempCount[index]++;
                if (countB[index] < tempCount[index]) {
                    countB[index] = tempCount[index];
                }
            }
        }
    }

    private void getCount(int[][] countA, String[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0, len = a[i].length(); j < len; j++) {
                int index = a[i].charAt(j) - 'a';
                countA[index][i]++;
            }
        }
    }
}
