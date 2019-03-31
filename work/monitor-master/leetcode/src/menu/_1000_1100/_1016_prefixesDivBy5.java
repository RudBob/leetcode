package menu._1000_1100;

import java.util.*;

public class _1016_prefixesDivBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = (sum * 2 + A[i]) % 100;
            if (sum % 5 == 0) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

}
