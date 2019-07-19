package menu._000_100;

/**
 * @ClassName _035_searchInsert
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 14:29
 * @Version 1.0
 */
public class _035_searchInsert {
    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length - 1);
    }

    // 二分查找
    public int searchInsert(int[] nums, int target, int head, int last) {
        if (nums[head] >= target) {
            return head;
        } else if (nums[last] == target) {
            return last;
        } else if (nums[last] < target) {
            return last + 1;
        }
        int mid = (head + last) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return searchInsert(nums, target, mid + 1, last);
        } else {
            return searchInsert(nums, target, head, mid - 1);
        }
    }
}
