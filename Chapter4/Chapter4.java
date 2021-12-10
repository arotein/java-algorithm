package Chapter4;

public class Chapter4 {
    public static void main(String[] args) {
//      삽입정렬(Insertion Sort)
        int[] a = {40, 60, 90, 34, 78, 12, 56, 3, 57, 100};
        InsertionSort ins = new InsertionSort();
        ins.run(a);

//      버블정렬(Bubble Sort)
        int[] b = {40, 60, 90, 34, 78, 12, 56, 3, 57, 100};
        BubbleSort bs = new BubbleSort();
        bs.run(b);

//      선택정렬(Selection Sort)
        int[] c = {40, 60, 90, 34, 78, 12, 56, 3, 57, 100};
        SelectionSort ss = new SelectionSort();
        ss.run(c);
    }
}
