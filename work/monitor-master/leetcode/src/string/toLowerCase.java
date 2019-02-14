package string;

/**
 * @ClassName toLowerCase
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/19 17:40
 * @Version 1.0
 */
public class toLowerCase {
    public String toLowerCase(String str) {
        StringBuilder res = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                //大写的时候
                res.append(Character.toLowerCase(c));
            }else {
                // 其他时候
                res.append(c);
            }
        }
        return res.toString();
    }

}
