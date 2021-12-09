package GcdAndLcm;

public class Lcm {
    long a, b;

    Lcm(long a, long b) {
        this.a = a;
        this.b = b;
    }

    public long getLcm() {
        Gcd gcd = new Gcd(a, b);
        long result = a * b / gcd.getGcd();
        return result;
    }
}
