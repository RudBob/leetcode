package greedy;

import java.util.HashMap;
import java.util.Map;

public class isPossible {

    public boolean isPossible(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int k : nums) {
            map.put(k, map.getOrDefault(k,0) + 1);
        }
        int countLen = 1;
        for (int i = 0; i < nums.length; i++) {
            // 跳过所有使用过的
            if (used[i]) {
                continue;
            }
            // init value
            int maxCount = map.get(nums[i]);
            countLen = 1;
            int preInt = nums[i];
            used[i] = true;
            map.put(nums[i],map.get(nums[i]) - 1);
            for (int j = i + 1; j < nums.length; j++) {
                // 跳过所有用过的 or 跳过所有与上一位相同的数
                if (used[j] || nums[j] == preInt) {
                    continue;
                }
                // 如果不连续，结束这个子数组的延申
                if (nums[j] != preInt + 1) {
                    if (countLen < 3) {
                        return false;
                    } else {
                        break;
                    }
                } else {
                    int a = map.get(nums[j]);
                    if (a < maxCount) {
                        if (countLen < 3) {
                            return false;
                        } else {
                            break;
                        }
                    }
                    // 连续，使用,改变上一位的值
                    preInt = nums[j];
                    used[j] = true;
                    countLen++;
                    maxCount = a;
                    map.put(nums[j],map.get(nums[j]) - 1);
                }
            }
        }
        return countLen >= 3;
    }
}
