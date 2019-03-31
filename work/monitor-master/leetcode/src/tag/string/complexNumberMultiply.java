package tag.string;


public class complexNumberMultiply {

    public String complexNumberMultiply(String a, String b) {
        ComplexNumber a1 = strToComNum(a);
        ComplexNumber b1 = strToComNum(b);
        ComplexNumber res = multiply(a1, b1);
        return res.toString();
    }

    private ComplexNumber strToComNum(String a) {
        // 找实部.
        int realNum = 0;
        int i = 0;
        GetNum getNum = new GetNum(a, 0, i).invoke();
        realNum = getNum.getRealNum();
        i = getNum.getI();
        // 所以跳过 '+'
        i++;
        getNum = new GetNum(a, 0, i).invoke();
        int imaginary = getNum.getRealNum();
        // 找虚部
        return new ComplexNumber(realNum, imaginary);
    }

    public ComplexNumber multiply(ComplexNumber c1, ComplexNumber c2) {
        ComplexNumber res = new ComplexNumber();
        res.real = c1.real * c2.real - c1.imaginary * c2.imaginary;
        res.imaginary = c1.real * c2.imaginary + c1.imaginary * c2.real;
        return res;
    }

    private class GetNum {
        private String a;
        private int realNum;
        private int i;

        public GetNum(String a, int realNum, int i) {
            this.a = a;
            this.realNum = realNum;
            this.i = i;
        }

        public int getRealNum() {
            return realNum;
        }

        public int getI() {
            return i;
        }

        public GetNum invoke() {
            int realFuhao = 1;
            if ('-' == a.charAt(i)) {
                i++;
                realFuhao = -1;
            }
            //一定存在实部(题意)
            for (; i < a.length() && Character.isDigit(a.charAt(i)); i++) {
                realNum = realNum * 10 + (a.charAt(i) - '0');
            }
            realNum *= realFuhao;
            return this;
        }
    }
}

class ComplexNumber {
    int real;
    int imaginary;

    public ComplexNumber() {
    }

    public ComplexNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public String toString() {
        return real + "+" + imaginary + "i";
    }
}
