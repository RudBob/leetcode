package tag.stack;

public class calPoints {

    public int calPoints(String[] ops) {
        int[] a = new int[ops.length];
        // 一个哨兵
        int k = 0;
        for (int i = 0; i < ops.length; i++) {
            char c = ops[i].charAt(0);
            if (c == '+') {
                a[k] = a[k - 1] + a[k - 2];
            } else if (c == 'D') {
                a[k] = a[k - 1] * 2;
            } else if (c == 'C') {
                // 向前移动
                k -= 2;
            } else {
                // 数字情况
                int num = Integer.parseInt(ops[i]);
                a[k] = num;
            }
            k++;
        }
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        return sum;
    }
}
