package GcdAndLcm;

import java.util.Scanner;

public class Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        Gcd gcd = new Gcd(a, b);
        Lcm lcm = new Lcm(a, b);
        System.out.printf("%d와 %d의 최대공약수 : %d\n", a, b, gcd.getGcd());
        System.out.printf("%d와 %d의 최소공배수 : %d\n", a, b, lcm.getLcm());
    }
}
