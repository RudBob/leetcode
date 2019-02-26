package greedy;

public class monotoneIncreasingDigits {

    // 尽量保证前面的位数最大.
    public int monotoneIncreasingDigits(int N) {
        char[] a = Integer.toString(N).toCharArray();
        int index = isLegal(a);
        while (index != -1) {
            if (a[index] == '1') {
                a[index] = '0';
            } else {
                a[index] = (char) (a[index] - 1);
            }
            for (index++; index < a.length; index++) {
                a[index] = '9';
            }
            index = isLegal(a);
        }
        return Integer.parseInt(new String(a));
    }

    /**
     * -1 就代表合法了
     *
     * @param a
     * @return
     */
    private int isLegal(char[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return i - 1;
            }
        }
        return -1;
    }
}
