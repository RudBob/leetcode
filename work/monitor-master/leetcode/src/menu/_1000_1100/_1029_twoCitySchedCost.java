package menu._1000_1100;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName _1029_twoCitySchedCost
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 15:32
 * @Version 1.0
 */
public class _1029_twoCitySchedCost {
    public int twoCitySchedCost(int[][] costs) {
        // 待去人数
        int A = costs.length / 2, B = A;
        // 优先满足省下的最多的人。
        Person[] men = new Person[costs.length];
        for (int i = 0; i < costs.length; i++) {
            men[i] = new Person();
            men[i].money = costs[i][0] - costs[i][1];
            men[i].idx = i;
        }
        Arrays.sort(men, new Compa());
        // 现在差值从大到小排列
        // 优先满足这些人.
        int res = 0;
        for (int i = 0; i < men.length; i++) {
            int idx = men[i].idx;
            // 前一半人去A，后一半去B即可.
            if(A-- > 0) {
                res += costs[idx][1];
            } else {
                res += costs[idx][0];
            }
        }
        return res;
    }
}

class Person {
    int money;
    int idx;
}

class Compa implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o2.money - o1.money;
    }
}
