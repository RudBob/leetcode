package greedy;

public class predictPartyVictory {
    public String predictPartyVictory(String senate) {
        int allR = 0;
        int allD = 0;
        int countR = 0;
        int countD = 0;
        char[] ch = senate.toCharArray();
        for (char c : ch) {
            if (c == 'R') {
                allR++;
            } else {
                allD++;
            }
        }
        int len = senate.length();
        boolean[] deleted = new boolean[len];
        for (int i = 0; allR != 0 && allD != 0; i = (i + 1) % len) {
            if (deleted[i]) {
                continue;
            }
            if (ch[i] == 'R') {
                if (countD > 0) {
                    countD--;
                    allR--;
                    deleted[i] = true;
                } else {
                    countR++;
                }
            } else {
                if (countR > 0) {
                    countR--;
                    allD--;
                    deleted[i] = true;

                } else {
                    countD++;
                }
            }
        }
        return allR == 0 ? "Dire" : "Radiant";
    }
}
