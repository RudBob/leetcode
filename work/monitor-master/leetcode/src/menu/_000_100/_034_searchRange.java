package menu._000_100;

/**
 * @ClassName _034_searchRange
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/17 14:49
 * @Version 1.0
 */
public class _034_searchRange {
    public int[] searchRange(int[] nums, int target) {
        // 分别找第一个或最后一个
        int[] res = new int[2];
        res[0] = getRangeIdx(nums, target, 0, nums.length - 1, true);
        res[1] = getRangeIdx(nums, target, 0, nums.length - 1, false);
        return res;
    }

    private int getRangeIdx(int[] nums, int target, int left, int right, boolean Left) {
        if (right < left) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            if (Left) {
                if (mid > 0 && nums[mid - 1] == nums[mid]) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else {
                if (mid < nums.length - 1 && nums[mid + 1] == nums[mid]) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
        return getRangeIdx(nums, target, left, right, Left);
    }
}
