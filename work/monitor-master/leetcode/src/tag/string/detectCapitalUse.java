package tag.string;

/**
 * @ClassName detectCapitalUse
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/21 15:14
 * @Version 1.0
 */
public class detectCapitalUse {
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        boolean headIsUpperCase = Character.isUpperCase(word.charAt(0));
        if (headIsUpperCase) {
            if (len > 1) {
                headIsUpperCase = Character.isUpperCase(word.charAt(1));
                // 前两位都是大写
                if(headIsUpperCase){
                    for (int i = 1; i < len; i++) {
                        if (Character.isLowerCase(word.charAt(i))) {
                            return false;
                        }
                    }
                }else {// 第一位是大写，第二位是小写.
                    for (int i = 1; i < len; i++) {
                        if (Character.isUpperCase(word.charAt(i))) {
                            return false;
                        }
                    }
                }
            } else {
                return true;
            }
        } else {
            for (int i = 1; i < len; i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
class solutionDetectCapitalUse2{

    public boolean detectCapitalUse(String word) {
        int len = word.length();
        boolean headIsUpperCase = Character.isUpperCase(word.charAt(0));
        if (headIsUpperCase) {
            int sumUpperCase = 1;
            for (int i = 1; i < len; i++) {
                if(Character.isUpperCase(word.charAt(i))){
                    sumUpperCase++;
                }
            }
            return sumUpperCase == 1 || sumUpperCase == len;
        } else {
            for (int i = 1; i < len; i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
