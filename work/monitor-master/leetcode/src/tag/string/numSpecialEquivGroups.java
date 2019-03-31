package tag.string;

import java.util.*;

/**
 * @ClassName numSpecialEquivGroups
 * @Description TODO
 * @Author 任耀
 * @Date 2019/2/1 14:32
 * @Version 1.0
 */
public class numSpecialEquivGroups {
    // 24.2%
    public int numSpecialEquivGroups(String[] A) {
        Map<Integer, List<str>> map = new HashMap<>(A.length);
        // 按长度分组
        for (String str : A) {
            int len = str.length();
            List<str> value = map.get(len);
            if (value != null) {
                value.add(new str(str));
            } else {
                value = new ArrayList<>();
                value.add(new str(str));
                map.put(len, value);
            }
        }
        int count = 0;
        // 遍历
        for (Integer len : map.keySet()) {
            List<str> valueList = map.get(len);
            for (str key : valueList) {
                if (!key.used) {
                    count++;
                    key.used = true;
                    for (str key2 :
                            valueList) {
                        if (!key2.used && key.equalsStr(key2)) {
                            key2.used = true;
                        }
                    }
                }
            }
        }
        return count;
    }
}

class str {
    String value;
    boolean used;
    String jiShu;
    String ouShu;

    public str(String value) {
        this.value = value;
        jiShu = getJi(value);
        ouShu = getOu(value);
    }

    private String getJi(String value) {
        int len = value.length();
        char[] res = new char[(len + 1) / 2];
        for (int i = 0; i < len; i += 2) {
            res[(i + 1) / 2] = value.charAt(i);
        }
        Arrays.sort(res);
        return new String(res);
    }

    private String getOu(String value) {
        int len = value.length();
        char[] res;
        if (len <= 1) {
            return null;
        } else {
            res = new char[len / 2];
        }
        for (int i = 1; i < len; i += 2) {
            res[i / 2] = value.charAt(i);
        }
        Arrays.sort(res);
        return new String(res);
    }

    public boolean equalsStr(str o) {
        boolean res1 = false, res2 = false;
        if (o.ouShu == null && ouShu == null) {
            return jiShu.equals(o.jiShu);
        } else if (o.ouShu != null && ouShu == null) {
            return false;
        } else if (o.ouShu == null) {
            return false;
        } else {
            return jiShu.equals(o.jiShu) && ouShu.equals(o.ouShu);
        }
    }
}
