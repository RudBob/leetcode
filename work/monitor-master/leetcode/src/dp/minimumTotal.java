package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName minimumTotal
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/6 10:06
 * @Version 1.0
 */
public class minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 1) {
            return triangle.get(0).get(0);
        }
        List<Integer> temp = new ArrayList<>(triangle.get(size - 1));
        for (int i = size - 2; i >= 0; i--) {
            List<Integer> temp01 = triangle.get(i);
            for (int j = 0, len = triangle.get(i).size(); j < len; j++) {
                Integer tempInt = temp01.get(j) + Math.min(temp.get(j), temp.get(j + 1));
                temp01.set(j, tempInt);
            }
            temp = temp01;
        }
        return triangle.get(0).get(0);
    }
}
