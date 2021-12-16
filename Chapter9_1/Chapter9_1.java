package Chapter9_1;

public class Chapter9_1 {
    public static void main(String[] args) {
        FibonacciRec fr = new FibonacciRec();
        FibonacciDP fd = new FibonacciDP();
        FibonacciRecDP frd = new FibonacciRecDP();
        int n = 99;
        frd.initFibonacciNumbers();

//        long start = System.nanoTime();
//        for (int i = 0; i <= n; i++) {
//            System.out.printf("%d ", fr.fibonacci(i));
//        }
//        long end = System.nanoTime();
//        System.out.println();
//        System.out.println("걸린시간 : " + (float) (end - start)/1000000000 + "s");

        long startFd = System.nanoTime();
        for (int k = 0; k < 1000; k++) {
            for (int i = 0; i <= n; i++) {
                int a = fd.fibonacci(i);
//                System.out.printf("%d ", fd.fibonacci(i));
            }
        }
        long endFd = System.nanoTime();

        long startFrd = System.nanoTime();
        for (int k = 0; k < 1000; k++) {
            for (int i = 0; i <= n; i++) {
                int b = frd.fibonacci(i);
            }
        }
        long endFrd = System.nanoTime();
        System.out.println("DP와 RDP의 걸린시간 차이 : " + (float) (endFd - startFd) / (endFrd - startFrd) + "배");
    }
}
