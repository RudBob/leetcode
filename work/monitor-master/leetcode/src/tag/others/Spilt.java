package tag.others;

/**
 * @ClassName tag.others.Spilt
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/29 16:04
 * @Version 1.0
 */
public class Spilt {
    public static void main(String[] args) {
        String a = "12 3 4  5    6";
        String[] res = a.split(" ");
        for (String s :
                res) {
            System.out.println(s);
        }
    }
}
