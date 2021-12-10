package Chapter4;

public class BubbleSort extends PrintArray {
    public void run(int... a) {
        int temp;
        System.out.println("정렬 전 배열");
        printArray(a);
        for (int out = a.length - 1; out > 0; out--) {
            for (int in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) {
                    temp = a[in + 1];
                    a[in + 1] = a[in];
                    a[in] = temp;
                }
            }
        }
        System.out.println("버블정렬 후 배열");
        printArray(a);
    }
}
