package menu._000_100;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName _056_merge
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/16 9:02
 * @Version 1.0
 */
public class _056_merge {
    public int[][] merge(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, new Comp());

        boolean[] disappear = new boolean[intervals.length];
        int count = intervals.length;
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                // 将i 合并i+1中
                disappear[i] = true;
                intervals[i + 1][0] = Math.min(intervals[i][0], intervals[i + 1][1]);
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
                count--;
            }
        }
        int[][] res = new int[count][2];
        for (int i = 0, k = 0; i < intervals.length; i++) {
            if (!disappear[i]) {
                res[k][0] = intervals[i][0];
                res[k][1] = intervals[i][1];
                k++;
            }
        }
        return res;
    }


}

class Comp implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        int[] i1 = (int[]) o1;
        int[] i2 = (int[]) o2;
        return i1[0] - i2[0];
    }
}