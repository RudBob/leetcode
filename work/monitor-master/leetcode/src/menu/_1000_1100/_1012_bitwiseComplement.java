package menu._1000_1100;

public class _1012_bitwiseComplement {
    public int bitwiseComplement(int N) {
        String bin = Integer.toBinaryString(N);
        // 求反
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '0') {
                sb.append("1");
                first = false;
            } else if (!first) {
                sb.append("0");
            }
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return Integer.parseInt(sb.toString(),2);
    }
}
