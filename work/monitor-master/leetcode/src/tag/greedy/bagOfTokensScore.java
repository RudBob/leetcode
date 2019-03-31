package tag.greedy;

import java.util.Arrays;

public class bagOfTokensScore {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int allScore = 0;
        for (int t : tokens) {
            allScore += t;
        }
        int score = 0;
        int res = 0;
        int last = tokens.length - 1;
        for (int i = 0; i <= last; i++) {
            if (P >= tokens[i]) {
                P -= tokens[i];
                score++;
                res = res > score ? res : score;
            } else {
                if (score > 0) {
                    score--;
                    i--;
                    P += tokens[last--];
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
