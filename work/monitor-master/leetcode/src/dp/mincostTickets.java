package dp;

// 5ms
public class mincostTickets {
    public int mincostTickets(int[] days, int[] costs) {
        // 节省空间，所以不使用365，使用今天旅行的最后一天
        int[] lastAllDaysCost = new int[days[days.length - 1] + 1];
        // 将旅行天数
        int countDays = 1;
        int ticketDay = costs[0];
        int ticketWeek = costs[1];
        int ticketMonth = costs[2];
        lastAllDaysCost[days[0]] = ticketDay;
        // lastAllCost[i] 是截至到今年的第 i 天的总花费.
        // 模拟时间跑起来，从旅行的第二天跑到旅行的最后一天。
        for (int i = days[0] + 1; i <= days[days.length - 1]; i++) {
            if (days[countDays] != i) {
                // 如果这一天不旅行那么直接把上一天的过去总花费拿过来直接使用。
                lastAllDaysCost[i] = lastAllDaysCost[i - 1];
                continue;
            }
            // 开始进入下一个待旅行的日子
            countDays++;
            // 如果一月前，买了月票，会不会更便宜？
            // 如果一周前，买了周票，会不会更便宜？
            // 如果都不会的话，那我暂时先买日票试试呗。
            lastAllDaysCost[i] = Math.min(
                    Math.min(
                            lastAllDaysCost[Math.max(0, i - 1)] + ticketDay
                            , lastAllDaysCost[Math.max(0, i - 7)] + ticketWeek)
                    , lastAllDaysCost[Math.max(0, i - 30)] + ticketMonth);
        }
        return lastAllDaysCost[days[days.length - 1]];
    }
}
