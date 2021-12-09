package Chapter4;

public class Chapter4 {
    public static void main(String[] args) {
        int[] a = {90, 34, 78, 12, 56, 3, 57, 100};

        //        삽입정렬(insertion sort)
        InsertionSort ins = new InsertionSort();
        ins.run(a);
    }
}
