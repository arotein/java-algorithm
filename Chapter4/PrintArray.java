package Chapter4;

class PrintArray {
    public void printIntArray(int... a) {
        for (int e : a) {
            System.out.printf("[%d]", e);
        }
        System.out.println();
    }
}
