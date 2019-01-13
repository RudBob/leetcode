package recall;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class grayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        // 得到二进制的位数
        int k = n;
        n = 1;
        for (int i = 1; i < k; i++) {
            n *= 2;
        }
        int len = Integer.toBinaryString(n).length();
        StringBuilder path = new StringBuilder();
        int pos = 0;
        grayCode(n, res, len, pos, path, true);
        return res;
    }

    private void grayCode(int n, List<Integer> res, int targetLen, int len, StringBuilder path, boolean flag) {
        // 将结果加入res容器中
        if (len == targetLen) {
            // 加入容器
            res.add(Integer.parseInt(path.toString(), 2));
            return;
        }
        if (flag) {
            // 双重回溯,使用变量标记路径
            path.append('0');
            grayCode(n, res, targetLen, len + 1, path, true);
            path.deleteCharAt(path.length() - 1);

            path.append('1');
            grayCode(n, res, targetLen, len + 1, path, false);
            path.deleteCharAt(path.length() - 1);
        } else {
            path.append('1');
            grayCode(n, res, targetLen, len + 1, path, true);
            path.deleteCharAt(path.length() - 1);
            // 双重回溯
            path.append('0');
            grayCode(n, res, targetLen, len + 1, path, false);
            path.deleteCharAt(path.length() - 1);
        }

    }
}
