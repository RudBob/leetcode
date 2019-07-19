package tag.string;

public class longestPalindrome {
    // 最暴力的方法
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] sChars = s.toCharArray();
        // 找对称轴
        SubCharArrIndex sub = new SubCharArrIndex(0, 0);
        for (int i = 0; i < sChars.length * 2 - 1; i++) {
            // 对称轴
            if (i % 2 == 1) {
                // 奇数，则长度为偶数.
                getMaxLength(sChars, i / 2, i / 2 + 1, sub);
            } else {
                // 偶数， 则长度为奇数.
                getMaxLength(sChars, i / 2, i / 2, sub);
            }
        }
        String res = new String(sChars, sub.head, sub.last - sub.head + 1);
        return res;
    }

    private void getMaxLength(char[] sChars, int headIndex, int lastIndex, SubCharArrIndex sub) {
        while (headIndex >= 0 && lastIndex < sChars.length) {
            if (sChars[headIndex] != sChars[lastIndex]) {
                break;
            }
            headIndex--;
            lastIndex++;
        }
        if (--lastIndex >= ++headIndex && sub.isLess(headIndex, lastIndex)) {
            sub.head = headIndex;
            sub.last = lastIndex;
        }
    }
}

class SubCharArrIndex {
    int head;
    int last;

    public SubCharArrIndex(int head, int last) {
        this.head = head;
        this.last = last;
    }

    public boolean isLess(int head, int last) {
        return (last - head) > (this.last - this.head);
    }
}
