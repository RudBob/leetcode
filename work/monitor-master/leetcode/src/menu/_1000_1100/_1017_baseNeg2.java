package menu._1000_1100;

import java.util.Stack;

public class _1017_baseNeg2 {

    public String baseNeg2(int N) {
        String res = "";
        char num[] = new char[40005];
        Stack<Integer> s = new Stack<>();
        int a;
        if (N == 0)
            return "0";
        else {
            while (N != 0) {
                a = Math.abs(N % (-2));
                s.push(a);
                N = (N - a) / (-2);
            }
        }
        while (!s.empty()) {
            res = res + s.pop();
        }
        return res;
    }
}
