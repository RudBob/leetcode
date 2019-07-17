package menu._000_100;

/**
 * @ClassName _033_search
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/16 13:45
 * @Version 1.0
 */
public class _033_search {
    public int search(int[] nums, int target) {
        int splitIdx = searchSplitIdx(nums, 0, nums.length - 1);
        if (splitIdx > 0 &&nums[splitIdx] >= target) {
            if (target >= nums[0]) {
                return binSearch(nums, target, 0, splitIdx);
            } else if (splitIdx < nums.length - 1 && target >= nums[splitIdx + 1] && target <= nums[nums.length - 1]) {
                return binSearch(nums, target, splitIdx + 1, nums.length - 1);
            }
        }
        return -1;
    }

    private int binSearch(int[] nums, int target, int left, int right) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            // 左边右移
            right = mid - 1;
        } else if (nums[right] < target) {
            left = mid + 1;
        } else {
            return -1;
        }
        return binSearch(nums, target, left, right);
    }

    // 两次二分，一次找到分割点，然后分别在分割点左右进行二分.
    private int searchSplitIdx(int[] nums, int left, int right) {
        if (right - left == 1) {
            return nums[right] > nums[left] ? right : left;
        }
        int mid = (left + right) / 2;
        if (right == left) {
            return mid;
        } else if (right < left) {
            return -1;
        }
        // 依然递增
        if (nums[mid] > nums[left]) {
            left = mid;
        } else if (nums[mid] < nums[right]) {
            right = mid - 1;
        }
        return searchSplitIdx(nums, left, right);
    }
}
