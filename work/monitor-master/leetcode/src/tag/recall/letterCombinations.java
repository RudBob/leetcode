package tag.recall;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    char[][] map = {
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        StringBuilder path = new StringBuilder();
        dfs(digits.toCharArray(), res, 0, path);
        return res;
    }

    private void dfs(char[] chars, List<String> res, int i, StringBuilder path) {
        if (path.length() == chars.length) {
            res.add(path.toString());
        }
        for (int j = i; j < chars.length; j++) {
            int key = chars[j] - '0';
            for (int k = 0; k < map[key].length; k++) {
                path.append(map[key][k]);
                dfs(chars, res, j + 1, path);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
