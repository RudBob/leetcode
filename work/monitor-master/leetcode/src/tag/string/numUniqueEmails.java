package tag.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName numUniqueEmails
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/19 19:41
 * @Version 1.0
 */
public class numUniqueEmails {
    public int numUniqueEmails(String[] emails) {
        Set<String> resSet = new HashSet<String>();
        for (int i = 0; i < emails.length; i++) {
            StringBuilder path = new StringBuilder();
            // 找到'@'的位置，作为尾部分。
            int indexOfAt = emails[i].lastIndexOf("@");
            // 在'@' 之前，从第 0 个开始直到到@为止。
            for (int j = 0; j < indexOfAt; j++) {
                if (emails[i].charAt(j) == '+') {
                    break;
                } else if (emails[i].charAt(j) == '.') {
                    // 在遇到'+' 之后，立刻跳到@后面的内容.
                    continue;
                } else {
                    path.append(emails[i].charAt(j));
                }
            }
            int len = emails[i].length();
            for (int j = indexOfAt; j < len; j++) {
                path.append(emails[i].charAt(j));
            }
            resSet.add(path.toString());
            // 使用set容器存储string
        }
        return resSet.size();
        // 直接返回size
    }
}
