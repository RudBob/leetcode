package tag.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName restoreIpAddresses
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/29 15:38
 * @Version 1.0
 */
public class restoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() <= 1) {
            return res;
        }
        boolean[] flagUsed = new boolean[s.length() - 1];
        if (s.length() >= 4 && s.length() <= 12) {
            getIps(s, res, flagUsed, 0, 0);
        }
        return res;
    }

    private void getIps(String s, List<String> res, boolean[] flagUsed, int countDot, int index) {
        if (countDot == 3) {
            if (checkIp(s, flagUsed)) {
                res.add(DotToIp(s, flagUsed));
            }
            return;
        } else if (countDot > 3) {
            return;
        }
        //  三个点在一个数组中的全排列
        for (int i = index; i < flagUsed.length; i++) {
            flagUsed[i] = true;
            getIps(s, res, flagUsed, countDot + 1, i + 1);
            flagUsed[i] = false;
        }
    }

    private String DotToIp(String s, boolean[] flagUsed) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < flagUsed.length; i++) {
            res.append(s.charAt(i));
            if (flagUsed[i]) {
                res.append('.');
            }
        }
        res.append(s.charAt(flagUsed.length));
        return res.toString();
    }

    private boolean checkIp(String s, boolean[] flagUsed) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < flagUsed.length; i++) {
            res.append(s.charAt(i));
            if (flagUsed[i]) {
                if (res.length() > 1 && res.charAt(0) == '0') {
                    return false;
                }
                int num = Integer.parseInt(res.toString());
                if (num > 255) {
                    return false;
                }
                res = new StringBuilder();
            }
        }
        res.append(s.charAt(flagUsed.length));
        if (res.length() > 1 && res.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(res.toString());
        return num <= 255;
    }
}
