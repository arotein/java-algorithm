package Chapter4;

public class PrintArray {
    public void printArray(int... a) {
        for (int e : a) {
            System.out.printf("[%d]", e);
        }
        System.out.println();
    }
}
