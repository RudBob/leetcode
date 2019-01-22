package string.easy.day01;

/**
 * @ClassName toGoatLatin
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/21 14:23
 * @Version 1.0
 */
public class toGoatLatin {
    private char[] fuyin = {'a', 'e', 'i', 'o', 'u','A','E','I','O','U'};

    public String toGoatLatin(String S) {
        String[] str = S.split(" ");
        StringBuilder suffix = new StringBuilder("maa");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            char headChar = str[i].charAt(0);
            if (isFunYin(headChar)) {
                res.append(str[i]);
            } else {
                res.append(str[i].substring(1) + str[i].charAt(0));
            }
            res.append(suffix + " ");
            suffix.append("a");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    private boolean isFunYin(char headChar) {
        for (int i = 0; i < fuyin.length; i++) {
            if (headChar == fuyin[i]) {
                return true;
            }
        }
        return false;
    }
}
