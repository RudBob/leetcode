package tag.string;

/**
 * @ClassName isLongPressedName
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/22 14:24
 * @Version 1.0
 */
public class isLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() == 0 || typed.length() < name.length()) {
            return false;
        }
        int indexOfName = 0;
        for (int i = 0, len = typed.length(); i < len; i++) {
            if(indexOfName == name.length()){
                return true;
            }
            if (typed.charAt(i) == name.charAt(indexOfName)) {
                indexOfName++;
            } else if (i > 0 && typed.charAt(i) == typed.charAt(i - 1)) {
            } else {
                return false;
            }
        }
        return indexOfName == name.length();
    }
}
