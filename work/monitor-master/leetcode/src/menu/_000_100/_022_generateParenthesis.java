package menu._000_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _022_generateParenthesis
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 14:24
 * @Version 1.0
 */
public class _022_generateParenthesis {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            StringBuilder path = new StringBuilder();
            int sum = 0;
            int index = 0;
            dfs(n, res, path, index, sum);
            return res;
        }

        private void dfs(int n, List<String> res, StringBuilder path, int index, int sum) {
            if ( sum < 0) {
                return;
            }
            if (sum == 0 && 2 * n == index) {
                res.add(path.toString());
                return;
            }
            if(2 * n == index){
                return;
            }

            // 开始构建回溯体
            path.append("(");
            dfs(n, res, path, index + 1, sum + 1);
            path.deleteCharAt(path.length() - 1);

            path.append(")");
            dfs(n, res, path, index + 1, sum - 1);
            path.deleteCharAt(path.length() - 1);

        }

}
