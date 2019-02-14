package string;

/**
 * 88.08%
 */
public class shiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        char[] Schars = S.toCharArray();
        for (int i = shifts.length - 1, sum = 0; i >= 0; i--) {
            sum += shifts[i];
            sum %= 26;
            Schars[i] = (char) ('a' + (((Schars[i] - 'a') + sum) % 26));
        }
        return new String(Schars);
    }
}
