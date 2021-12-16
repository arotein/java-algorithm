package Chapter8;

//재귀호출 및 퀵정렬
public class Chapter8 {
    public static void main(String[] args) {
//        int result;
//        RecursiveCall recur = new RecursiveCall();
//        result = recur.factorial(15);
//        System.out.println(result);

        int[] a = {4, 7, 1, 6, 2, 5, 3};

        PrintArray pa = new PrintArray();
        pa.printIntArray(a);

        QuickSort qs = new QuickSort();
        qs.sortArray(a, 0, a.length - 1);
        pa.printIntArray(a);


    }
}
