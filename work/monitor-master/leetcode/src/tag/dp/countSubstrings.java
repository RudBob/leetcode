package tag.dp;

public class countSubstrings {

    public int countSubstrings(String s) {
        int res = 0;
        char[] ch = s.toCharArray();
        for (int minddle = 0; minddle <= ch.length * 2 - 1; minddle++) {
            if (minddle % 2 == 0) {
                res += getPalindStrNum(minddle, ch, 1) + 1;
            } else {
                res += getPalindStrNum(minddle, ch, 0);
            }
        }
        return res;
    }

    private int getPalindStrNum(int minddle, char[] ch, int type) {
        int head, last;
        if (type == 1) {
            head = minddle / 2 - 1;
            last = minddle / 2 + 1;
        } else {
            head = minddle / 2;
            last = minddle / 2 + 1;
        }
        int len = 0;
        while (head >= 0 && last < ch.length && ch[head] == ch[last]) {
            len++;
            head--;
            last++;
        }
        return len;
    }
}
