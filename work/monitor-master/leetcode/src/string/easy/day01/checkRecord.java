package string.easy.day01;

/**
 * @ClassName checkRecord
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/21 22:21
 * @Version 1.0
 */
public class checkRecord {
    public boolean checkRecord(String s) {
        return s.indexOf('A') == s.lastIndexOf('A') && !s.contains("LLL");
    }
}
