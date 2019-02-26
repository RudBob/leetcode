package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        int rows = 0;
        if (points.length == 0) {
            return rows;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        //依然按照结束时间排序

        // 找到所有重叠的，射死.
        int lastEnd = points[0][1];
        rows++;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > lastEnd) {
                rows++;
                lastEnd = points[i][1];
            }
        }
        return rows;
    }
}
