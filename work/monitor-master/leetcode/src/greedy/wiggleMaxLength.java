package greedy;

public class wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int res = 0;
        int plusOrMinus = 0;
        for (int i = 1; i < nums.length; i++) {
            int sub = nums[i] - nums[i - 1];
            if (sub > 0 && plusOrMinus != 1) {
                plusOrMinus = 1;
                res++;
            } else if (sub < 0 && plusOrMinus != -1) {
                plusOrMinus = -1;
                res++;
            }
        }
        return res + 1;
    }
}
