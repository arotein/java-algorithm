package Chapter4;

public class SelectionSort extends PrintArray {
    public void run(int... a) {
        int temp, minIndex;
        System.out.println("정렬 전 배열");
        printIntArray(a);

        for (int out = 0; out < a.length - 1; out++) {
            minIndex = out;
            for (int in = out + 1; in < a.length; in++) {
                if (a[minIndex] > a[in]) {
                    minIndex = in;
                }
            }
            temp = a[out];
            a[out] = a[minIndex];
            a[minIndex] = temp;
        }

        System.out.println("선택정렬 후 배열");
        printIntArray(a);
    }
}
