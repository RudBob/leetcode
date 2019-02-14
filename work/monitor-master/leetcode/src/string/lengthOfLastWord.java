package string;

/**
 * @ClassName lengthOfLastWord
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/26 10:55
 * @Version 1.0
 */
public class lengthOfLastWord {
    // 调用库函数，反而不如自己写的好.因为简单而且用时更少
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int lenLastWord = 0;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && Character.isLetter(s.charAt(i))) {
            lenLastWord++;
            i--;
        }
        return lenLastWord;
    }
}
