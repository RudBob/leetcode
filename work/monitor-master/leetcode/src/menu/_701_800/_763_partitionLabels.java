package menu._701_800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName _763_partitionLabels
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 17:18
 * @Version 1.0
 */
public class _763_partitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        char[] ch = S.toCharArray();
        int[] endIndex = new int[26];
        int[] beginIdx = new int[26];
        Arrays.fill(beginIdx, -1);
        Arrays.fill(endIndex, -1);
        for (int i = 0; i < ch.length; i++) {
            int idx = ch[i] - 'a';
            if (beginIdx[idx] == -1) {
                beginIdx[idx] = i;
            }
            endIndex[idx] = i;
        }
        for (int i = 0, endIdx; i < ch.length; i++) {
            int idx = ch[i] - 'a';
            int len = endIndex[idx] - beginIdx[idx] + 1;
            endIdx = endIndex[idx];
            int pre = idx;
            boolean hasChange = true;
            while (hasChange) {
                hasChange = false;
                for (int j = 0; j < 26; j++) {
                    // 如果有其他字符落入这个区间，那么需要更新.
                    if (pre != j && beginIdx[j] >= beginIdx[idx] && beginIdx[j] <= endIdx) {
                        if (len <= (endIndex[j] - beginIdx[idx] + 1)) {
                            len = endIndex[j] - beginIdx[idx] + 1;
                            endIdx = endIndex[j];
                            hasChange = true;
                            pre = j;
                        }
                    }
                }
            }
            i = endIdx;
            res.add(len);
        }
        return res;
    }
}
