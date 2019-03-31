package menu._1000_1100;

public class _1003_isValid {// 1003
    public boolean isValid(String S) {
        String abc = "abc";
        int index = S.indexOf(abc);
        while (index != -1) {
            S = S.substring(0, index) + S.substring(index + 3);
            index = S.indexOf(abc);
        }
        return S.length() == 0;
    }

}
