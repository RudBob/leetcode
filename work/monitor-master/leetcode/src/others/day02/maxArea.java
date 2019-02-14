package others.day02;

import java.io.IOException;

public class maxArea {
    public static void main(String[] args) throws IOException {
        maxArea m = new maxArea();
        int[] h = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(m.maxArea(h));
    }

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
