package tag.string;

/**
 * @ClassName compareVersion
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/1 13:53
 * @Version 1.0
 */
public class compareVersion {
    public int compareVersion(String version1, String version2) {
        String v1 = version1;
        String v2 = version2;
        String[] v1s = v1.split("\\.");
        String[] v2s = v2.split("\\.");
        for (int i = 0, len = Math.max(v1s.length, v2s.length); i < len; i++) {
            int int1 = i >= v1s.length ? 0 : Integer.parseInt(v1s[i]);
            int int2 = i >= v2s.length ? 0 : Integer.parseInt(v2s[i]);
            if (int1 > int2) {
                return 1;
            } else if (int1 < int2) {
                return -1;
            }
        }
        return 0;
    }
}
