package menu._1000_1100;

import java.util.ArrayList;
import java.util.List;

public class _1002_commonChars {

    // 1002
    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (A[i].length() != 0) {
            char target = A[i].charAt(0);
            if (A[i].length() == 1) {
                A[i] = "";
            } else {
                A[i] = A[i].substring(1);
            }
            boolean res = commonChars(A, i + 1, target);
            if (res) {
                list.add(target + "");
            }
        }
        return list;
    }

    private boolean commonChars(String[] A, int index, char target) {
        if (index == A.length) {
            return true;
        }
        int i = A[index].indexOf(target);
        if (i == -1) {
            return false;
        } else {
            if (A[index].length() == 1) {
                A[index] = "";
            } else {
                A[index] = A[index].substring(0, i) + A[index].substring(i + 1);
            }
            return commonChars(A, index + 1, target);
        }
    }

}
