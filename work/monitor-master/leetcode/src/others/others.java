package others;

/**
 * @ClassName others.others
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/30 10:58
 * @Version 1.0
 */
public class others {
    public static void main(String[] args) {
        String s = "10101";//1+4+16==21
        // Integer 中封装好了一个方法：
        // 能够直接计算二进制中的1的个数，在竞赛中很有用.
        // JDk8中的实现方法使用的是 & 操作，所以比正常的遍历要快的多.
//        System.out.println(Integer.bitCount(21));
        // 上文是21的二进制，所以21的二进制中有 3 个‘1’,

        System.out.println(myDec(21, 2));
    }

    private static char[] array = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
            .toCharArray();

    public static String myDec(int number, int n) {
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            result.insert(0, array[number % n]);
            number /= n;
        }
        return result.toString();
    }

}
