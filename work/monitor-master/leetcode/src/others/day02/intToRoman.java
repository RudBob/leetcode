package others.day02;

public class intToRoman {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        while (num >= 1000) {
            res.append("M");
            num -= 1000;
        }
        if (num >= 900) {
            num -= 900;
            res.append("CM");
        }
        while (num >= 500) {
            res.append("D");
            num -= 500;
        }
        if (num >= 400) {
            num -= 400;
            res.append("CD");
        }
        while (num >= 100) {
            res.append("C");
            num -= 100;
        }
        if (num >= 90) {
            num -= 90;
            res.append("XC");
        }
        while (num >= 50) {
            res.append("L");
            num -= 50;
        }
        if (num >= 40) {
            num -= 40;
            res.append("XL");
        }
        while (num >= 10) {
            res.append("X");
            num -= 10;
        }
        if (num >= 9) {
            num -= 9;
            res.append("IX");
        }
        while (num >= 5) {
            res.append("V");
            num -= 5;
        }
        if (num >= 4) {
            num -= 4;
            res.append("IV");
        }
        while (num >= 1) {
            res.append("I");
            num--;
        }
        return res.toString();
    }

    public String intToRoman2(int num) {
        StringBuilder res = new StringBuilder();
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; num > 0; i++) {
            while (num >= nums[i]) {
                res.append(roman[i]);
                num -= nums[i];
            }
            if(nums[i] == 1){
                break;
            }
            if (num >= nums[++i]) {
                num -= nums[i];
                res.append(roman[i]);
            }
        }
        return res.toString();
    }
}
