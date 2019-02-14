package others.day01;

public class twoSum {
    /**
     * 暴力破解
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            res[0] = i;
            int temp = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (temp == nums[j]) {
                    res[1] = j;
                    return res;
                }
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int []res = twoSum(nums,target);
        for (int i = 0; i < 2; i++) {
            System.out.println(res[i]);
        }

    }
}
