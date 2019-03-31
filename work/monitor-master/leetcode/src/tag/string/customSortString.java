package tag.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName customSortString
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/27 11:24
 * @Version 1.0
 */
public class customSortString {

    public String customSortString(String S, String T) {
        comp a = new comp(S);
        Character[] charsT = new Character[T.length()];
        for (int i = 0; i < charsT.length; i++) {
            charsT[i] = T.charAt(i);
        }
        Arrays.sort(charsT, a);
        StringBuilder res = new StringBuilder();
        for (Character character : charsT) {
            res.append(character);
        }
        return res.toString();
    }
}

class comp implements Comparator<Character> {
    String c;

    comp(String c) {
        this.c = c;
    }

    @Override
    public int compare(Character o1, Character o2) {
        int chIndex = c.indexOf(o1);
        int ch2Index = c.indexOf(o2);
        return chIndex - ch2Index;
    }
}

