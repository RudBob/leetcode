package menu._801_900;

/**
 * @ClassName _860_lemonadeChange
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/19 15:41
 * @Version 1.0
 */
public class _860_lemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int[] countMoney = new int[3];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                countMoney[0]++;
            } else if (bills[i] == 10) {
                if (countMoney[0] <= 0) {
                    return false;
                }
                countMoney[0]--;
                countMoney[1]++;
            } else if (bills[i] == 20) {
                if (countMoney[1] == 0) {
                    if (countMoney[0] < 3) {
                        return false;
                    } else {
                        countMoney[0] -= 3;
                    }
                } else if (countMoney[0] == 0) {
                    return false;
                } else {
                    countMoney[0]--;
                    countMoney[1]--;
                }
                countMoney[2]++;
            }
        }
        return true;
    }
}
