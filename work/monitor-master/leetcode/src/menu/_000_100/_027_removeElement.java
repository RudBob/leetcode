package menu._000_100;

/**
 * @ClassName _027_removeElement
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 14:27
 * @Version 1.0
 */
public class _027_removeElement {
    public int removeElement(int[] nums, int val) {
        int head = 0, last = nums.length - 1;
        while (head <= last) {
            if (nums[head] == val) {
                nums[head] = nums[last--];
            } else {
                head++;
            }
        }
        return last + 1;
    }
}

