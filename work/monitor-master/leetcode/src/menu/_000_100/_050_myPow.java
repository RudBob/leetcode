package menu._000_100;

/**
 * @ClassName _050_myPow
 * @Description TODO
 * @Author 任耀
 * @Date 2019/7/15 16:03
 * @Version 1.0
 */
public class _050_myPow {
    public double myPow(double x, int n) {
//        long N = n;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        } else if (n == 0) {
            return 1;
        }
        return myPowZ(x,n);
    }

    private double myPowZ(double x, long n) {
        // n % 2 == 0 , x^ n = (x^(n/2)) * (x^(n/2))
        // n % 2 == 1 , x^ n =  (x^(n/2)) * (x^(n/2)) * x;
        if (n == 1) {
            return x;
        } else if (n == 0) {
            return 1;
        }
        double k = myPowZ(x, n / 2);
        if (n % 2 == 0) {
            return k * k;
        } else {
            return k * k * x;
        }
    }

}
