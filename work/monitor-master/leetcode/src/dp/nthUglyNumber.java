package dp;

/**
 * @ClassName nthUglyNumber
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/14 22:04
 * @Version 1.0
 */
public class nthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] num = new int[n];
        num[0] = 1;
        int index2 = 0,index3 = 0,index5 = 0;
        int[] result=new int[n];
        result[0]=1;

        int begin = 1;
        while(begin<n){
            result[begin]=Math.min(result[index2]*2,Math.min(result[index3]*3,result[index5]*5));
            if(result[begin]==result[index2]*2) index2++;
            if(result[begin]==result[index3]*3) index3++;
            if(result[begin]==result[index5]*5) index5++;
            begin++;
        }
        return result[--begin];
    }
}
