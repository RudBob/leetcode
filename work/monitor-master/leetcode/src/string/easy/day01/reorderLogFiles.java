package string.easy.day01;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName reorderLogFiles
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/21 11:09
 * @Version 1.0
 */
public class reorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int index1 = o1.indexOf(' ');
                String s1 = o1.substring(index1 + 1);
                int index2 = o2.indexOf(' ');
                String s2 = o2.substring(index2 + 1);
                char c1 = s1.charAt(0);
                char c2 = s2.charAt(0);
                if (Character.isLetter(c1) && Character.isLetter(c2)) {
                    return s1.compareTo(s2);
                } else if (Character.isLetter(c1)) {
                    return -1;
                } else if (Character.isLetter(c2)) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        return logs;
    }
}
