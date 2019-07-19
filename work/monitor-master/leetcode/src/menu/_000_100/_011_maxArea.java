package menu._000_100;

/**
 * @ClassName _011_maxArea
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/17 21:11
 * @Version 1.0
 */
public class _011_maxArea {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        return maxArea(height, left, right);
    }

    public int maxArea(int[] height, int left, int right) {
        int res = 0;
        while (left < right) {
            int tempRes = (right - left) * Math.min(height[left], height[right]);
            if (tempRes > res) {
                res = tempRes;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
