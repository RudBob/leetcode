package others.day02;

public class myAtoi {
    public int myAtoi(String str) {
        int len = str.length();
        StringBuilder res = new StringBuilder();
        int flag = 1;
        int i = 0;
        // 跳过所有的空格
        while (i < len && str.charAt(i) == ' ') {
            i++;
        }
        // 如果是'+','-'
        if (i < len && str.charAt(i) == '+') {
            flag = 1;
            i++;
        } else if (i < len && str.charAt(i) == '-') {
            flag = -1;
            i++;
        }
        // 属于数字
        while (i < len && str.charAt(i) <= '9' && str.charAt(i) >= '0') {
            res.append(str.charAt(i++));
        }
        if (res.length() == 0) {
            return 0;
        }
        try {
            Integer.parseInt(res.toString());
        } catch (NumberFormatException e) {
            if (flag == 1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        int resInt = Integer.parseInt(res.toString()) * flag;
        return resInt;
    }
}
