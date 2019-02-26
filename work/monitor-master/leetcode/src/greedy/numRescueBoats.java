package greedy;

import java.util.Arrays;

public class numRescueBoats {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int head = 0, last = people.length - 1;
        int countBoat = 0;
        while (head < last) {
            countBoat++;
            if (people[head] + people[last] > limit) {
                last--;
            } else {
                last--;
                head++;
            }
        }
        if (head == last) {
            countBoat++;
        }
        return countBoat;
    }
}
