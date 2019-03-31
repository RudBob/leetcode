package tag.greedy;

public class canCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] surplus = new int[gas.length];
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            surplus[i] = gas[i] - cost[i];
            sum += surplus[i];
        }
        if (sum < 0) {
            return -1;
        }
        // 合并所有相邻的正数和负数
        int headIndex = 0;
        int lastIndex = -1;
        int len = gas.length;
        sum = 0;
        while (lastIndex < 0 || (headIndex - 1 + len) % len != (lastIndex) % len) {
            lastIndex = (lastIndex + 1) % len;
            sum += surplus[lastIndex];
            while (sum < 0) {
                headIndex = (headIndex - 1 + len) % len;
                sum += surplus[headIndex];
            }
        }
        return headIndex;
    }
}
