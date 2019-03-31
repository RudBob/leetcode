package tag.recall;

import java.util.ArrayList;
import java.util.List;

public class letterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        /**
         回溯法, 遇到字母分大小写情况回溯, 遇到非字母直接回溯
         **/
        List<String> res = new ArrayList<>();
        bktrace(S.toCharArray(), res, new StringBuilder(), 0);
        return res;
    }

    private void bktrace(char[] s, List<String> ret, StringBuilder sb, int indexOfChange) {
        // 结束条件, 当改变的字母的数量(数字视为改变) = 长度时.
        if (indexOfChange == s.length) {
            ret.add(sb.toString());
            return;
        }
        // 取出第index位的数字
        char c = s[indexOfChange];
        // 属于字母
        if (Character.isLetter(c)) {
            // 将小写字母 --> 拼接至结果中
            sb.append(Character.toLowerCase(c));
            // 回溯算法
            bktrace(s, ret, sb, indexOfChange + 1);
            // 回滚。
            sb.deleteCharAt(sb.length() - 1);

            sb.append(Character.toUpperCase(c));
            bktrace(s, ret, sb, indexOfChange + 1);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            // 非字母直接跳过，对下一个进行处理
            sb.append(c);
            bktrace(s, ret, sb, indexOfChange + 1);
            // 回滚
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
