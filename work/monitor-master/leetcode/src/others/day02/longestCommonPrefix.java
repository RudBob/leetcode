package others.day02;

public class longestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        boolean flag = true;
        for (int j = 0; j < strs[0].length() && flag; j++) {
            char lastChar = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() == j || (strs[i].charAt(j) != lastChar)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.append(lastChar);
            }
        }
        return res.toString();
    }
}
