package Chapter4;

public class InsertionSort extends PrintArray {
    public void run(int... a) {
        int temp, out, in;

        System.out.println("정렬 전 배열");
        printArray(a);

        for (out = 1; out < a.length; out++) {
            temp = a[out];
            for (in = out - 1; in >= 0; in--) {
                if (a[in] > temp) {
                    a[in + 1] = a[in];
                } else {
                    break;
                }
            }
            a[in + 1] = temp;
        }

        System.out.println("삽입정렬 후 배열");
        printArray(a);
    }

    public void ch(int... ch) {
        ch[0] = 0;
    }
}
