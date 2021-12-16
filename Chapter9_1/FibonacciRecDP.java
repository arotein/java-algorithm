package Chapter9_1;

//재귀호출+동적계획법
public class FibonacciRecDP {
    public int[] fibonacciNumbers = new int[1000];

    public void initFibonacciNumbers() {
        for (int i = 0; i < fibonacciNumbers.length; i++) {
            fibonacciNumbers[i] = -1;
        }
    }

    public int fibonacci(int n) {
        if (fibonacciNumbers[n] == -1) {
            switch (n) {
                case 0:
                    fibonacciNumbers[n] = 0; break;
                case 1:
                    fibonacciNumbers[n] = 1; break;
                default:
                    fibonacciNumbers[n] = fibonacci(n - 1) + fibonacci(n - 2);
            }
        }
        return fibonacciNumbers[n];
    }
}
