package Chapter9_1;

public class FibonacciRec {
//    n번째 피보나치수 리턴
    public int fibonacci(int n) {
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
