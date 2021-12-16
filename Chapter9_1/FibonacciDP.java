package Chapter9_1;

//동적계획법(Dynamic Programming)을 활용한 피보나치 수
public class FibonacciDP {
    public int[] fibonacciNum = new int[1000];

    public int fibonacci(int n) {
        for (int i = 0; i <= n; i++) {
            switch (i) {
                case 0: fibonacciNum[i] = 0; break;
                case 1: fibonacciNum[i] = 1; break;
                default: fibonacciNum[i] = fibonacciNum[i-1] + fibonacciNum[i-2];
            }
        }
        return fibonacciNum[n];
    }
}
