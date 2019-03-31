package tag.string;

/**
 * @ClassName buddyStrings
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/27 10:01
 * @Version 1.0
 */
public class buddyStrings {
    public boolean buddyStrings(String A, String B) {
        if(A.equals(B)){
            // 找有没有重复的字符
            for (int i = 0; i < 26; i++) {
                char ch = (char) ('a' + i);
                if(A.indexOf(ch) != A.lastIndexOf(ch)){
                    return true;
                }
            }
            return false;
        }
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();
        if (charsA.length != charsB.length) {
            return false;
        }
        int[] indexDifferent = new int[2];
        int k = 0;
        for (int i = 0; i < charsA.length; i++) {
            if (charsA[i] != charsB[i]) {
                try {
                    indexDifferent[k++] = i;
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
            }
        }
        return k == 2 && charsA[indexDifferent[0]] == charsB[indexDifferent[1]] && charsA[indexDifferent[1]] == charsB[indexDifferent[0]];
    }
}
