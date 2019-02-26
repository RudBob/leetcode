package greedy;

import java.util.*;

public class eraseOverlapIntervals {
    // 简单的时间最大利用问题
    public int eraseOverlapIntervals(Interval[] intervals) {
        // 每次找到最小的end 并且不可以与现有的时间重叠 即可
        Arrays.sort(intervals, new Com());
        int count = 0;
        int lastEnd = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].start < lastEnd) {
                // 无效，跳过
                count++;
                continue;
            }
            // 有效，加入
            lastEnd = intervals[i].end;
        }
        return count;
    }
}

class Com implements Comparator<Interval> {
    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.end - o2.end;
    }
}
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}