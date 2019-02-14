package string;

/**
 * @ClassName rotatedDigits
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/21 14:40
 * @Version 1.0
 */
public class rotatedDigits {
    int reserveMap[] = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};

    public int rotatedDigits(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodNum(i)) {
                res++;
            }
        }
        return res;
    }

    private boolean isGoodNum(int i) {
        String tempStr = Integer.toString(i);
        int res = 0;
        for (int j = 0; j < tempStr.length(); j++) {
            int k = tempStr.charAt(j) - '0';
            if(reserveMap[k] == -1){
                return false;
            }
            res = res * 10 + reserveMap[k];
        }
        return res != i;
    }
}
class solution2{

    int reserveMap[] = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};

    public int rotatedDigits(int N) {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            if (isGoodNum(i)) {
                res++;
            } else if (getReserveNum(i) == -1) {
                // 有某位导致的无法成立
                char[] tempStr = Integer.toString(i).toCharArray();
                for (int j = 0; j < tempStr.length; j++) {
                    int k = tempStr[j] - '0';
                    if (reserveMap[k] == -1) {
                        tempStr[j]++;
                    }
                }
                StringBuilder a = new StringBuilder();
                for (int j = 0; j < tempStr.length; j++) {
                    a.append(tempStr[j]);
                }
                i = Integer.parseInt(a.toString()) - 1;
            }
        }
        return res;
    }

    private boolean isGoodNum(int i) {
        int res = getReserveNum(i);
        if (res == -1) {
            return false;
        }
        return res != i;
    }

    private int getReserveNum(int i) {
        String tempStr = Integer.toString(i);
        int res = 0;
        for (int j = 0; j < tempStr.length(); j++) {
            int k = tempStr.charAt(j) - '0';
            if (reserveMap[k] == -1) {
                return -1;
            }
            res = res * 10 + reserveMap[k];
        }
        return res;
    }
}
