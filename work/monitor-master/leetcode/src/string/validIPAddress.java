package string;

/**
 * @ClassName validIPAddress
 * @Description TODO
 * @Author 任耀
 * @Date 2019/1/30 16:35
 * @Version 1.0
 */
public class validIPAddress {

    public String validIPAddress(String IP) {
        int len = IP.length();
        // 题意中说：多余的 0 不被允许，但是无论是测试还是提交，预期结果都是 IPv6。
        if (IP.contains(".") && len >= 7 && len <= 15 && checkIpv4(IP)) {
            return "IPv4";
        } else if (IP.contains(":") && len >= 15 && len <= 39 && checkIpv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean checkIpv6(String ip) {
        String[] v = ip.split(":");
        // 找个数
        if (count(ip, ':', 7) && v.length == 8) {
            for (int i = 0; i < 8; i++) {
                // 排除多余的 0
                if (v[i].length() > 4) {
                    return false;
                }
                // 转16进制为10进制后转回去，看看是否正常.
                try {
                    Integer.parseInt(v[i], 16);
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean count(String ip, char k, int cou) {
        int count = 0;
        if (ip.contains("-")) {
            return false;
        }
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) == k) {
                count++;
            }else if(ip.charAt(i) == '-'){
                return false;
            }
        }
        return count == cou;
    }

    private boolean checkIpv4(String ip) {
        // 需要转义
        String[] values = ip.split("\\.");
        if (count(ip, '.', 3) && values.length == 4) {
            for (int i = 0; i < 4; i++) {
                try {
                    int k = Integer.parseInt(values[i]);
                    if (!Integer.toString(k).equals(values[i]) || k > 255) {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
