package GcdAndLcm;

//유클리드 호제법(최대공약수)
public class Gcd {
    long a, b;

    Gcd(long a, long b) {
        this.a = a;
        this.b = b;
    }

    public long getGcd() {
        long a1, b1, a2, b2, result;

//        뺄셈 이용하는 방법
//        a1 = a;
//        b1 = b;
//        while (a1 != b1) {
//            if (a1 > b1) {
//                a1 -= b1;
//            } else {
//                b1 -= a1;
//            }
//        }

//        나머지 구하는 방법
        a2 = a;
        b2 = b;
        while (a2 != 0 && b2 != 0) {
            if (a2 > b2) {
                a2 %= b2;
            } else {
                b2 %= a2;
            }
        }
        if (a2 == 0) {
            result = b2;
        } else {
            result = a2;
        }
        return result;
    }
}