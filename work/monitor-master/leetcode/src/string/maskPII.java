package string;

/**
 * @ClassName maskPII
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/4 10:58
 * @Version 1.0
 */
public class maskPII {
    public String maskPII(String S) {
        String res;
        if (isEmail(S)) {
            res = hideEmailInfo(S);
        } else {
            res = hideTelInfo(S);
        }
        return res;
    }

    private String hideTelInfo(String s) {
        StringBuilder telNum = new StringBuilder();
        for (int i = 0, len = s.length(); i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                telNum.append(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        int len = telNum.length();
        if (len > 10) {
            int k = len - 10;
            res.append("+");
            while (k-- != 0) {
                res.append("*");
            }
            res.append("-");
        }
        res.append("***-***-");
        for (int i = len - 4; i < len; i++) {
            res.append(telNum.charAt(i));
        }
        return res.toString();
    }

    private String hideEmailInfo(String s) {
        int indexOfAt = s.indexOf('@');
        char head = Character.toLowerCase(s.charAt(0));
        char last = Character.toLowerCase(s.charAt(indexOfAt - 1));
        StringBuilder res = new StringBuilder(head + "*****" + last);
        for (int i = indexOfAt, len = s.length(); i < len; i++) {
            res.append(Character.toLowerCase(s.charAt(i)));
        }
        return res.toString();
    }

    private boolean isEmail(String s) {
        return s.contains("@");
    }
}
