package stack;

import java.util.HashMap;
import java.util.Map;

public class nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return nums1;
        }
        // 申请储存结果的数组
        int[] res = new int[nums1.length];
        int[] biggerIndex = new int[nums2.length];
        biggerIndex[nums2.length - 1] = -1;
        for (int i = nums2.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums2.length; ) {
                if (nums2[j] > nums2[i]) {
                    biggerIndex[i] = j;
                    break;
                } else if (biggerIndex[j] == -1) {
                    biggerIndex[i] = -1;
                    break;
                } else {
                    j = biggerIndex[j];
                }
            }
        }
        Map<Integer, Integer> a = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length; i++) {
            int value = -1;
            if (biggerIndex[i] != -1) {
                value = nums2[biggerIndex[i]];
            }
            a.put(nums2[i], value);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = a.get(nums1[i]);
        }
        return res;
    }
}
