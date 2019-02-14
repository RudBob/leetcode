package others.day01;

public class isPalindrome {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        String strX = Integer.toString(x);
        int len = strX.length() / 2;
        int l1 = strX.length();
        for (int i = 0; i < len; i++) {
            if (strX.charAt(i) != strX.charAt(l1 - 1 - i)){
                return false;
            }
        }
        return true;
    }
    private String reserve(int x) {
        StringBuilder res = new StringBuilder();
        String strX = Integer.toString(x);
        for (int i = strX.length() - 1; i >= 0; i--) {
            res.append(strX.charAt(i));
        }
        return res.toString();
    }
}
