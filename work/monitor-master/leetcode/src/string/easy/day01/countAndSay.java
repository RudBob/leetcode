package string.easy.day01;

/**
 * @ClassName countAndSay
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/21 17:24
 * @Version 1.0
 */
public class countAndSay {
    /**
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     */
    public String countAndSay(int n) {
        String[] resMap = new String[n + 1];
        resMap[1] = "1";
        for (int i = 2; i <= n; i++) {
            resMap[i] = getCountNum(resMap[i - 1]);
        }
        return resMap[n];
    }

    private String getCountNum(String s) {
        StringBuilder res = new StringBuilder();
        int count = 1;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                res.append(count).append(s.charAt(i));
                count = 0;
            }
        }
        return res.toString();
    }
}
