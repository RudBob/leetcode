package tag.string;

/**
 * @ClassName canConstruct
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/22 13:09
 * @Version 1.0
 */
public class canConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder magazineSB = new StringBuilder(magazine);
        for (int i = 0, len = ransomNote.length(); i < len; i++) {
            char c = ransomNote.charAt(i);
            int index = magazineSB.indexOf(c + "");
            if (index == -1) {
                return false;
            } else {
                magazineSB.deleteCharAt(index);
            }
        }
        return true;
    }
}
