package tag.dp;

/**
 * @ClassName countNumbersWithUniqueDigits
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/11 21:03
 * @Version 1.0
 */
public class countNumbersWithUniqueDigits {


    public int countNumbersWithUniqueDigits(int n) {
        if (n == 1) {
            return 10;
        } else if (n > 10 ) {
            return 0;
        }else if(n == 0){
            return 1;
        }
        int res = 9;
        for (int i = 9, count = 1; count <= n - 1; i--, count++) {
            res *= i;
        }
        return res + countNumbersWithUniqueDigits(n - 1);
    }

}
