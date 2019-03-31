package tag.string;

/**
 * @ClassName reverseStr2
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/22 13:32
 * @Version 1.0
 */
public class reverseStr2 {
    public String reverseStr(String s, int k) {
        if (k == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int len = s.length();
        int all = len;
        int index = 0;
        while (all != 0) {
            if (all >= 2 * k) {
                all -= 2 * k;
                res.append(new StringBuffer(s.substring(index, index + k)).reverse());
                res.append(s.substring(index + k, index + 2 * k));
                index += 2 * k;
            } else if (all < 2 * k && all >= k) {
                res.append(new StringBuffer(s.substring(index, index + k)).reverse());
                res.append(new StringBuffer(s.substring(index + k)));
                all = 0;
            } else {
                res.append(new StringBuffer(s.substring(index)).reverse());
                all = 0;
            }
        }
        return res.toString();
    }
}
